import wordcloud.CollisionMode;
import wordcloud.PolarBlendMode;
import wordcloud.PolarWordCloud;
import wordcloud.WordFrequency;
import wordcloud.bg.CircleBackground;
import wordcloud.font.scale.SqrtFontScalar;
import wordcloud.nlp.FrequencyAnalyzer;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Paul Kisbee on 19/08/2015.
 */
public class WordCloud {

    private String outFile = "wordcloud.png";

    public void getWordCloud(List<String> posTweets, List<String> negTweets) throws Exception {

        System.out.println("- - - Generating Word Cloud");

        try {

            final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
            frequencyAnalyzer.setWordFrequencesToReturn(750);
            frequencyAnalyzer.setMinWordLength(4);
            //frequencyAnalyzer.setStopWords(loadStopWords());

            //final List<WordFrequency> wordFreqPos = frequencyAnalyzer.load(getInputStream(posFile));
            //final List<WordFrequency> wordFreqNeg = frequencyAnalyzer.load(getInputStream(negFile));

            final List<WordFrequency> wordFreqPos = frequencyAnalyzer.load(posTweets);
            final List<WordFrequency> wordFreqNeg = frequencyAnalyzer.load(negTweets);

            final PolarWordCloud wordCloud = new PolarWordCloud(600, 600, CollisionMode.PIXEL_PERFECT, PolarBlendMode.BLUR);
            wordCloud.setPadding(2);
            wordCloud.setBackground(new CircleBackground(300));
            wordCloud.setFontScalar(new SqrtFontScalar(10, 40));
            wordCloud.build(wordFreqPos, wordFreqNeg);
            wordCloud.writeToFile(outFile);

        } catch (Exception e) {
            throw e;
        }

    }
}
