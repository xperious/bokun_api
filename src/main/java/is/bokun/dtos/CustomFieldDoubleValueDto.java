package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomFieldDoubleValueDto extends CustomFieldDto {

	public Double value;
	
	public CustomFieldDoubleValueDto(Double value, List<String> flags) {
		this.value = value;
		this.flags = flags;
	}
}
