package uk.gov.dvla.osl.enquiry;

/**
 * Created by adminuser3 on 05/05/2015.
 */


import io.dropwizard.Configuration;
        import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

public class EnquiryConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultTaxClass = "48";

    @NotEmpty
    private String defaultCO2 = "1000";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultTaxClass() {
        return defaultTaxClass;
    }

    @JsonProperty
    public String getDefaultCO2() {
        return defaultCO2;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultTaxClass = name;
    }


}