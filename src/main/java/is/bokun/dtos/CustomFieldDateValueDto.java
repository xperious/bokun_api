package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomFieldDateValueDto extends CustomFieldDto {

	public Date value;
	
	public CustomFieldDateValueDto(Date value, List<String> flags) {
		this.value = value;
		this.flags = flags;
	}
}
