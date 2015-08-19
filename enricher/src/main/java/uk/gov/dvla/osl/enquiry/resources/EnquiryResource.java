package uk.gov.dvla.osl.enquiry.resources;


import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/enrich")
@Produces(MediaType.APPLICATION_JSON)
public class EnquiryResource {

    @POST
    public void addTweet(@Valid TweetInfo tweet) {
        System.out.print(tweet.getTweet());
    }
}
