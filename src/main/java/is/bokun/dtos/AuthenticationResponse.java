package is.bokun.dtos;

import is.bokun.dtos.UserAccountDto;

public class AuthenticationResponse {

	public boolean success;
	public String securityToken;
	public UserAccountDto user;
	
	public AuthenticationResponse() {}
	
	public static AuthenticationResponse success(UserAccountDto user, String securityToken) {
		AuthenticationResponse r = new AuthenticationResponse();
		r.success = true;
		r.user = user;
		r.securityToken = securityToken;
		return r;
	}
	
	public static AuthenticationResponse failed() {
		return new AuthenticationResponse();
	}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public UserAccountDto getUser() {
        return user;
    }

    public void setUser(UserAccountDto user) {
        this.user = user;
    }
}
