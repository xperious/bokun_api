package is.bokun.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDto {
	
	public String errorCode;
	public String errorDescription;
	
	public ErrorDto() {}

}
