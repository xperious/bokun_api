package is.bokun.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomFieldIntValueDto extends CustomFieldDto {

	public Integer value;
	
	public CustomFieldIntValueDto(Integer value, List<String> flags) {
		this.value = value;
		this.flags = flags;
	}
}
