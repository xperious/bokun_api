package is.bokun.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DerivedPhotoDto {

	public String name;
	public String url;
}
