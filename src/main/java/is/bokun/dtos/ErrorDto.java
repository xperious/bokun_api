package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDto {
	
	public String errorCode;
	public String errorDescription;
	
	public ErrorDto() {}

}
