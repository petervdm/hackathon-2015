package uk.gov.dvla.osl.enquiry.dataMapper;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import uk.gov.dvla.osl.cim.LicenceRecord;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by adminuser3 on 15/05/2015.
 */
public class LicenceRecordMapper implements ResultSetMapper<LicenceRecord> {

    public LicenceRecord map(int i, ResultSet r, StatementContext c) throws SQLException {

        LicenceRecord license = new LicenceRecord();
        return license;
    }



}
