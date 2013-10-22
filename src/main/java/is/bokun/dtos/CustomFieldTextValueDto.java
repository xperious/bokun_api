package is.bokun.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomFieldTextValueDto extends CustomFieldDto {

	public String value;
	
	public CustomFieldTextValueDto(String value, List<String> flags) {
		this.value = value;
		this.flags = flags;
	}
}
