package is.bokun.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomFieldTextValueDto extends CustomFieldDto {

	public String value;

    public CustomFieldTextValueDto() {}
	
	public CustomFieldTextValueDto(String value, List<String> flags) {
		this.value = value;
		this.flags = flags;
	}

    @Override @JsonIgnore
    public Object getObject() {
        return value;
    }
}
