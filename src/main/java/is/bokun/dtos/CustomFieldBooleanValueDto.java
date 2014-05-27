package is.bokun.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomFieldBooleanValueDto extends CustomFieldDto {

	public Boolean value;

    public CustomFieldBooleanValueDto() {}
	
	public CustomFieldBooleanValueDto(Boolean value, List<String> flags) {
		this.value = value;
		this.flags = flags;
	}

    @Override @JsonIgnore
    public Object getObject() {
        return value;
    }
}
