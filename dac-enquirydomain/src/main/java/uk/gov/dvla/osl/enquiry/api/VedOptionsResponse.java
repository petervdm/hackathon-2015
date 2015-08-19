package uk.gov.dvla.osl.enquiry.api;
/**
 * Created by Andrew Shapton on 05/05/2015.
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class VedOptionsResponse {


    @Length(max = 3)
    private String ved6Months;

    @Length(max = 3)
    private String ved12Months;

    public VedOptionsResponse() {
        // Jackson deserialization
    }

    public VedOptionsResponse(String ved6Months, String ved12Months) {
        this.ved12Months = ved12Months;
        this.ved6Months = ved6Months;
    }
    @JsonProperty
    public String getVed6Months() {
        return ved6Months;
    }

    @JsonProperty
    public String getVed12Months() {
        return ved12Months;
    }
}