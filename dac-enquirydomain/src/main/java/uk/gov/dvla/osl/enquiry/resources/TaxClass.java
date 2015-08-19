package uk.gov.dvla.osl.enquiry.resources;

public class TaxClass

{
    String typeApproval;
    String co2;
    String propulsion;

    public String getCo2() {
        return co2;
    }

    public String getPropulsion() {
        return propulsion;
    }

    public String getTypeApproval() {
        return typeApproval;
    }





    public void setCo2(String co2) {
        this.co2 = co2;
    }

    public void setPropulsion(String propulsion) {
        this.propulsion = propulsion;
    }

    public void setTypeApproval(String typeApproval) {
        this.typeApproval = typeApproval;
    }






    @Override
    public String toString() {return "CO2=" + co2;}
}