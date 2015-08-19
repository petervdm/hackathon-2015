import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul Kisbee on 19/08/2015.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Aggregator Started");

        try {
            // CONNECT TO DATABASE
            MySqlAccess db = new MySqlAccess();
            WordCloud wc = new WordCloud();
            db.init();

            // GET TWEETS
            ResultSet tweets = db.getTweets();

            String tweetdate = "1900-01-01";
            int tweethour = 25;

            List<String> posTweets = new ArrayList<String>();
            List<String> negTweets = new ArrayList<String>();
            int posCount = 0;
            int neuCount = 0;
            int negCount = 0;

            /*
            posTweets.add("good stuff");
            posTweets.add("good stuff tastes good");
            posTweets.add("good stuff looks nice");
            posTweets.add("good stuff is expensive");
            posTweets.add("good stuff smells nice");
            posTweets.add("good stuff sparkles");

            negTweets.add("bad stuff");
            negTweets.add("bad stuff tastes bad");
            negTweets.add("bad stuff looks nasty");
            negTweets.add("bad stuff is cheap");
            negTweets.add("bad stuff smells horrible");
            negTweets.add("bad stuff is dull");
            */

            String thistweetdate = "";
            int thistweethour = 25;

            while (tweets.next()) {
                String tweettime = tweets.getString(1);
                String tweet = tweets.getString(2);
                String sentiment = tweets.getString(3);


                tweetdate = tweettime.substring(0,9);
                tweethour = Integer.parseInt(tweettime.substring(11,12));

                System.out.println("'" + sentiment + "'");
                if (sentiment.equals("positive")) {
                    posCount++;
                    posTweets.add(tweet);
                } else {
                    if (sentiment.equals("negative")) {
                        negCount++;
                        negTweets.add(tweet);
                    } else {
                        neuCount++;
                    }
                }
            }

            System.out.println("Pos: " + posCount);
            System.out.println("Neu: " + neuCount);
            System.out.println("Neg: " + negCount);

            // GET & STORE WORD CLOUD IMAGE
            wc.getWordCloud(posTweets, negTweets);

            // WRITE TOTALS
            db.writeTotals(tweetdate, tweethour, posCount, neuCount, negCount, "TBD");

            // CLOSE DATABASE
            db.end();

        } catch (Exception e) {
            throw e;
        }

        System.out.println("Aggregator Ended");
    }
}
