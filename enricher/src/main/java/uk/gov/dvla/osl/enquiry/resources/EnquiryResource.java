package uk.gov.dvla.osl.enquiry.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/enrich")
@Produces(MediaType.APPLICATION_JSON)
public class EnquiryResource {

    @POST
    public void getSomething(String tweet) {
        System.out.print(tweet);
    }
}
