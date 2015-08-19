package uk.gov.dvla.osl.enquiry.resources;
/**
 * Created by Andrew Shapton on 05/05/2015.
 */
public class Response {
	
	String duty;
	String taxClass;
	String result;

	public String getTaxClass () { return taxClass;}

	public void setTaxClass(String taxClass) {
		this.taxClass = taxClass;
	}

	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	} 
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String toString() {
		return  "Response: duty" + getDuty() +">";
	}
}
