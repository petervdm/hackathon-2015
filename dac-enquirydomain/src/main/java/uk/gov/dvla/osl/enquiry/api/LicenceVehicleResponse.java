package uk.gov.dvla.osl.enquiry.api;
/**
 * Created by Andrew Shapton on 05/05/2015.
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class LicenceVehicleResponse {

    @Length(max = 2)
    private String result;

    public LicenceVehicleResponse() {
        // Jackson deserialization
    }

    @JsonProperty
    public String getResult() {
        return "OK";
    }

}