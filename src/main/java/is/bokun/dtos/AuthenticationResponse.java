package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationResponse {

	public boolean success;
	public String securityToken;
	public CustomerDto customer;
	
	public AuthenticationResponse() {}
	
	public static AuthenticationResponse success(CustomerDto customer, String securityToken) {
		AuthenticationResponse r = new AuthenticationResponse();
		r.success = true;
		r.customer = customer;
		r.securityToken = securityToken;
		return r;
	}
	
	public static AuthenticationResponse failed() {
		return new AuthenticationResponse();
	}

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
