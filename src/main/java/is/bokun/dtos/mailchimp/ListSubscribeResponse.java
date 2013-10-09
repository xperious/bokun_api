package is.bokun.dtos.mailchimp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListSubscribeResponse {

	public String email;
	public String euid;
	public String leid;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEuid() {
		return euid;
	}
	public void setEuid(String euid) {
		this.euid = euid;
	}
	public String getLeid() {
		return leid;
	}
	public void setLeid(String leid) {
		this.leid = leid;
	}
	
}
