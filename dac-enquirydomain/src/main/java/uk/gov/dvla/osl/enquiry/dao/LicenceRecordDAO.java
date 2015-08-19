package uk.gov.dvla.osl.enquiry.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 * Created by adminuser3 on 15/05/2015.
 */
public interface LicenceRecordDAO {


        // Insert the new license record


        @SqlUpdate("Insert into licence" +
                "("+
                "issuedatetime,"+
                "validfromdate,"+
                "validtodate,"+
                "licenceperiod,"+
                "amountpaid,"+
                "licencestatus,"+
                "isadvanced,"+
                "extraweeks,"+
                "taxclass,"+
                "isoffroad,"+
                "vehicleid"+
                " ) values (" +
                ":issuedatetime,"+
                ":validfromdate,"+
                ":validtodate,"+
                ":licenceperiod,"+
                ":amountpaid,"+
                ":licencestatus,"+
                ":isadvanced,"+
                ":extraweeks,"+
                ":taxclass,"+
                ":isoffroad,"+
                ":vehicleid"+
                ")")
            void insert(@Bind("issuedatetime") java.sql.Timestamp issuedatetime,
                                      @Bind("validfromdate") java.sql.Date validfromdate,
                                      @Bind("validtodate") java.sql.Date validtodate,
                                      @Bind("licenceperiod") long licenceperiod,
                                      @Bind("amountpaid") Float amonutpaid,
                                      @Bind("licencestatus") Integer licencestatus,
                                      @Bind("isadvanced") String isadvanced,
                                      @Bind("extraweeks") Integer extraweeks,
                                      @Bind("taxclass") String taxclass,
                                      @Bind("isoffroad") String isoffroad,
                                      @Bind("vehicleid") long vehicleid
                                      );


}
