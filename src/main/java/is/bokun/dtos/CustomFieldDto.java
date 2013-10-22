package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomFieldDto {
	
	public List<String> flags = new ArrayList<>();

}
