package uk.gov.dvla.osl.enquiry.resources;
/**
 * Created by Andrew Shapton on 05/05/2015.
 */
public class Ved
{
	String   taxPeriod;
	String   co2;
    int		 taxClass    ;
	int		 engineSize;
	String 	    typeApproval;

	public String getTypeApproval() {
		return typeApproval;
	}

	public void setTypeApproval(String typeApproval) {
		this.typeApproval = typeApproval;
	}

	public String getTaxPeriod() {
		return taxPeriod;
	}
	public String getCo2() {
		return co2;
	}
	public int getTaxClass() {
		return taxClass;
	}
	public int getEngineSize() {return engineSize;}

	public void setTaxPeriod(String tp) {taxPeriod = tp;}
	public void setCo2(String emissions) {	co2 = emissions;}
	public void setTaxClass(int tc) {	taxClass = tc;}
    public void setEngineSize(int es) {	engineSize = es;}

	@Override
	public String toString() {
		return "VED [taxPeriod=" + taxPeriod + ", co2=" + co2 +"]";
	}
		
}
