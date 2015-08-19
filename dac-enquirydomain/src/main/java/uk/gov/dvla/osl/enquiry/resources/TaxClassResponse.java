package uk.gov.dvla.osl.enquiry.resources;
/**
 * Created by Andrew Shapton on 05/05/2015.
 */
public class TaxClassResponse {

	String taxClass;
	String result;

	public String getTaxClass () { return taxClass;}

	public void setTaxClass(String taxClass) {
		this.taxClass = taxClass;
	}


	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String toString() {
		return  "Response: taxclass" + getTaxClass() +">";
	}
}
