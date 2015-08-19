package uk.gov.dvla.osl.enquiry.api;
/**
 * Created by Andrew Shapton on 05/05/2015.
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class CalculateTaxClassResponse {

    @Length(max = 2)
    private int taxClass;

    public CalculateTaxClassResponse() {
        // Jackson deserialization
    }

    public CalculateTaxClassResponse(int taxClass) {
        this.taxClass = taxClass;
    }

    @JsonProperty
    public int getTaxClass() {
        return taxClass;
    }

}