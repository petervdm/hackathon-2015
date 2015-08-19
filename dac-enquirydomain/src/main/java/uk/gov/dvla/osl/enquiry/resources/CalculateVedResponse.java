package uk.gov.dvla.osl.enquiry.resources;
/**
 * Created by Andrew Shapton on 05/05/2015.
 */
public class CalculateVedResponse {
	
	String duty6;
	String result;
	String duty12;

	public String getDuty6() {
		return duty6;
	}

	public void setDuty6(String duty6) {
		this.duty6 = duty6;
	}

	public String getDuty12() {
		return duty12;
	}

	public void setDuty12(String duty12) {
		this.duty12 = duty12;
	}

	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String toString() {
		return  getDuty12();
	}
}
