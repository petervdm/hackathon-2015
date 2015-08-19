package uk.gov.dvla.osl.enquiry.healthcheck;

/**
 * Created by Andrew Shapton on 05/05/2015.
 */



import com.codahale.metrics.health.HealthCheck;

public class VehicleLicenceHealthCheck extends HealthCheck {
    private final String template;

    public VehicleLicenceHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}