package is.bokun.dtos;

import is.bokun.utils.StringUtils;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtranetUserDto {

	public Long id;
	public String firstName;
	public String lastName;
	
	public ExtranetUserDto() {}
	
	public ExtranetUserDto(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@JsonIgnore
	public String getFullNameShort() {
		StringBuilder b = new StringBuilder();
		b.append(firstName);
		if ( !StringUtils.isNullOrEmpty(lastName) ) {
			b.append(" " + lastName.substring(0,1) + ".");
		}
		return b.toString();
	}
}
