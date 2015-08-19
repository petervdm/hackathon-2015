package uk.gov.dvla.osl.enquiry;

/**
 * Created by Andrew Shapton on 05/05/2015.
 */

import com.mongodb.DB;
import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import uk.gov.dvla.osl.enquiry.healthcheck.VehicleLicenceHealthCheck;
import uk.gov.dvla.osl.enquiry.resources.EnquiryEventHandler;
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

        // JDBI connectivity to the License System of record database domain
        final DBIFactory dbiFactory = new DBIFactory();
       // final DBI dbiRecord = dbiFactory.build(environment, configuration.getRecordDatabase(), "recordDatabase");
        // DAO
       // final LicenceRecordDAO licenceRecordDAO = dbiRecord.onDemand(LicenceRecordDAO.class);


        MongoClient mongoClient = null;
        DB dmv_db;
        try {
            mongoClient = new MongoClient("server07", 27017);

        } catch (Exception e) {
            e.printStackTrace();
        }

        dmv_db = mongoClient.getDB("enq");
        /* initialise connectivity to the Mongo database (dematerialised views) */
        // only needed when authorisation is in place...
        //boolean auth = dmv_db.authenticate("mongo", "12345".toCharArray());

        final EnquiryResource resource = new EnquiryResource(
                configuration.getTemplate(),
                configuration.getDefaultTaxClass());
        final EnquiryEventHandler ehResource = new EnquiryEventHandler(dmv_db);


        final VehicleLicenceHealthCheck healthCheck =
                new VehicleLicenceHealthCheck(configuration.getTemplate());

       // environment.healthChecks().register("template", healthCheck);

        // register primary functionality
        environment.jersey().register(resource);

        // register event handler resources for DMVs - should we break these out into a different copmonent to scale independently ?
        environment.jersey().register(ehResource);



    }
}