package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomFieldDoubleValueDto extends CustomFieldDto {

	public Double value;

    public CustomFieldDoubleValueDto() {}
	
	public CustomFieldDoubleValueDto(Double value, List<String> flags) {
		this.value = value;
		this.flags = flags;
	}

    @Override @JsonIgnore
    public Object getObject() {
        return value;
    }
}
