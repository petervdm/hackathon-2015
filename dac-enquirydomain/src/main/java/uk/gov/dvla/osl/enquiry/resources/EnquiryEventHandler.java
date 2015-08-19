package uk.gov.dvla.osl.enquiry.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.dvla.osl.cim.LicenceRecord;
import uk.gov.dvla.osl.cim.VehicleRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.sql.Date;
import java.sql.Timestamp;

import javax.ws.rs.core.Response;

/**
 * Created by Andrew Shapton on 23/05/2015.
 * <p/>
 * Handle the events for this domain
 */

@Path("/enquiry/event/subscribe")
@Produces(MediaType.APPLICATION_JSON)


public class EnquiryEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnquiryResource.class);
    private DB db;

    public EnquiryEventHandler(DB db) {
        this.db = db;
    }


    @POST
    @Path("/vehicleadded")
    @Timed
    @ExceptionMetered
    @Consumes(MediaType.APPLICATION_JSON)

    public Response vehicleadded(@HeaderParam("dvla-cid") String cid,
                                 VehicleRecord vehicleRecord) {

        LOGGER.info("Enquiry: newVehicle: Start: Correlation ID: "+cid);
        // assume the event is in JSON form  extract the data from the JSOn message

        LOGGER.info("Enquiry: newVehicle Event '" + vehicleRecord + "'.");


        {    // To directly connect to a single MongoDB server:
            try {
                DBCollection table = db.getCollection("vehicles");

                // the upsert of the document is done - just need to add lots of fields
                // depending on the JSON payload

                Long vehicleid = vehicleRecord.getVehicleId();

                String taxClass = "48";
                // will need to calculate tax class here.....
                // call tax class rules.....
                String wheelPlan = vehicleRecord.getWheelplan();
                String bodyType = vehicleRecord.getBodyType();
                Integer co2 = vehicleRecord.getCarbonDioxide();
                Integer vehiclestatus = vehicleRecord.getStatusId();
                String vrn = vehicleRecord.getVrn();
                String colour = vehicleRecord.getColour();
                int atwm = vehicleRecord.getAxle1TrackWidthMax();
                int capacity = vehicleRecord.getCapacity();
                String make = vehicleRecord.getMake();
                String model = vehicleRecord.getModel();
                String vin = vehicleRecord.getVin();
                String engine = vehicleRecord.getEngineNumber();
                String category = vehicleRecord.getCategory();
                String euroDirectiveNumber = vehicleRecord.getEuroDirectiveNumber();
                Integer grossWeight = vehicleRecord.getGrossWeight();
                Integer seatingCapacity = vehicleRecord.getSeatingCapacity();
                String propulsion = vehicleRecord.getPropulsion();


                // end of scaffold code
                BasicDBObject vidQuery = new BasicDBObject("vehicleid", vehicleid);
                DBObject thisVehicleId = table.findOne(vidQuery);

                DBObject modifiedObject = new BasicDBObject();


                modifiedObject.put("$set", new BasicDBObject()
                                .append("wheelPlan", wheelPlan)
                                .append("bodyType", bodyType)
                                .append("TaxClass", taxClass)
                                .append("CO2", co2)
                                .append("vehiclestatus", vehiclestatus)
                                .append("vrn", vrn)
                                .append("colour", colour)
                                .append("axletractwidthmax", atwm)
                                .append("capacity", capacity)
                                .append("make", make)
                                .append("model", model)
                                .append("vin", vin)
                                .append("engine", engine)
                                .append("category", category)
                                .append("euroDirectiveNumber", euroDirectiveNumber)
                                .append("grossWeight", grossWeight)
                                .append("seatingCapacity", seatingCapacity)
                                .append("propulsion", propulsion)
                                .append("keepers", new java.util.ArrayList())
                                .append("licences", new java.util.ArrayList())
                );

                // perform an upsert - by setting 3rd argument to true - drastically reduces the hits on the database.

                table.update(vidQuery, modifiedObject, true, false);


            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                throw new RuntimeException(e);
            }

            try {

                LOGGER.info("Enquiry:vehicleadded: End: Correlation ID: "+cid);
                return Response.created(new URI("")).build();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                throw new RuntimeException(e);

            }
        }
    }

    private Response registerVehicle(String response) {

        return Response.ok().build();
    }

    @POST
    @Path("/licenceadded")
    @Timed
    @ExceptionMetered
    @Consumes(MediaType.APPLICATION_JSON)

    public Response licenceAdded(@HeaderParam("dvla-cid") String cid,
                                 LicenceRecord licenceRecord) {

        LOGGER.info("Enquiry:licenceAdded Start: Correlation ID: "+cid);
        // assume the event is in JSON form  extract the data from the JSOn message

        LOGGER.info("Enquiry: licenceAdded Event '" + licenceRecord + "'.");


        {    // To directly connect to a single MongoDB server:
            try {
                DBCollection table = db.getCollection("vehicles");

                // the upsert of the document is done - just need to add lots of fields
                // depending on the JSON payload




                 long licenceId =licenceRecord.getLicenceId();
                 long vehicleId= licenceRecord.getVehicleId();
                 int extraWeeks = licenceRecord.getExtraWeeks();
                 String isAdvanced = licenceRecord.getIsAdvanced();
                 String isOffRoad = licenceRecord.getIsOffRoad();
                 Timestamp issueDateTime = licenceRecord.getIssueDateTime();
                 int licencePeriod = licenceRecord.getLicencePeriod();
                 int licenceStatus = licenceRecord.getLicenceStatus();
                 String taxClass = licenceRecord.getTaxClass();
                 Date validFromDate = licenceRecord.getValidFromDate();
                 Date validToDate = licenceRecord.getValidToDate();
                 Float amountPaid = licenceRecord.getAmountPaid();

                // find the vehicle associated with the ID.
                // extract the licence information (use the VehicleID to find the vehicle)
                BasicDBObject vidQuery = new BasicDBObject("vehicleid", vehicleId);
                DBObject thisVid = table.findOne(vidQuery);


                // the use "push" or "addtoset" to add the item to the set.
                DBObject modifiedObject = new BasicDBObject();
                modifiedObject.put("licenceID", licenceId);
                modifiedObject.put("extraWeeks", extraWeeks);
                modifiedObject.put("isAdvanced",isAdvanced);
                modifiedObject.put("isOffRoad",isOffRoad);
                modifiedObject.put("issueDateTime",issueDateTime);
                modifiedObject.put("licencePeriod",licencePeriod);
                modifiedObject.put("licenceStatus",licenceStatus);
                modifiedObject.put("taxClass",taxClass);
                modifiedObject.put("validFromDate",validFromDate);
                modifiedObject.put("validToDate",validToDate);
                modifiedObject.put("amountPaid",amountPaid);
                // add the licence record to the array
                table.update(thisVid, new BasicDBObject(
                                "$push", new BasicDBObject("licences", modifiedObject)), false,
                        false);

            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                throw new RuntimeException(e);
            }

            try {

                LOGGER.info("Enquiry:licenceRecord: End: Correlation ID: "+cid);
                return Response.created(new URI("")).build();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                throw new RuntimeException(e);

            }
        }
    }

    private Response newLicense(String response) {

        return Response.ok().build();
    }

}
