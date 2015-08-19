package uk.gov.dvla.osl.enquiry.resources;

/**
 * Created by Andrew Shapton on 05/05/2015.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/enquiry")
@Produces(MediaType.APPLICATION_JSON)
public class EnquiryResource {
    private final String template;
    private final String defaultName;
    private static final Logger LOGGER = LoggerFactory.getLogger(EnquiryResource.class);

    public EnquiryResource(String template,
                           String defaultName
    ) {
        // pass in objects here from the EnquiryApplication class.....
        this.template = template;
        this.defaultName = defaultName;

    }
}
