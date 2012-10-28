package dtos;

import org.codehaus.jackson.annotate.JsonIgnore;

public class UserAccountDto {

	public String uuid;
	public String email;
	public String firstName;
	public String lastName;
	
	@JsonIgnore
	public String password;
}
