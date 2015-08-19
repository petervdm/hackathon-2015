package uk.gov.dvla.osl.enquiry;

import io.dropwizard.Application;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import uk.gov.dvla.osl.enquiry.resources.EnquiryResource;

public class EnquiryApplication extends Application<EnquiryConfiguration> {
    public static void main(String[] args) throws Exception {
        new EnquiryApplication().run(args);
    }

    @Override
    public String getName() {
        return "enquiry";
    }

    @Override
    public void initialize(Bootstrap<EnquiryConfiguration> bootstrap) {
        super.initialize(bootstrap);

        // Add support to Dropwizard for Java8 features such as java.time.Date.
        bootstrap.addBundle(new Java8Bundle());
    }


    @Override
    public void run(EnquiryConfiguration configuration,
                    Environment environment) {

        final EnquiryResource resource = new EnquiryResource();

        environment.jersey().register(resource);

    }
}