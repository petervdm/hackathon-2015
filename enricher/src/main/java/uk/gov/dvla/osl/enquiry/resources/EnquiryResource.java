package uk.gov.dvla.osl.enquiry.resources;


import uk.gov.dvla.osl.enquiry.dao.TweetDao;




import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

@Path("/enrich")
@Produces(MediaType.APPLICATION_JSON)
public class EnquiryResource {

    private TweetDao dao;

    public EnquiryResource(TweetDao dao) {
        this.dao = dao;
    }

    @POST
    public void addTweet(@Valid TweetInfo tweet) {

        String response = null;
        try {
            response = sendPost(tweet.getTweet());

            int found = response.indexOf("result",0);

            int end = response.length() - 3;

            String sent = response.substring(found+9,end);

            System.out.println(sent);
            dao.insert(tweet.getCreatedOn(), tweet.getUser(), tweet.getTweet(), sent);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace().toString());
            System.out.println(e.getMessage());
        }

        System.out.print(response);

    }

    private String sendPost(String tweettext) throws Exception {

        String USER_AGENT = "Mozilla/5.0";

        String url= "http://api.datumbox.com/1.0/TwitterSentimentAnalysis.json";
       // String uuencoded_text = "some%20stuff%20thats%20bad";

        String uuencoded_text = URLEncoder.encode(tweettext, "UTF-8");



        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "api_key=3115ba031f75c4355fec58e0ff64ba92&text="+uuencoded_text;

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'POST' request to URL : " + url);
        //System.out.println("Post parameters : " + urlParameters);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.print(response.toString());

        return response.toString();
    }

}
