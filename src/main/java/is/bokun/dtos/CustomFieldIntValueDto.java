package is.bokun.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "customIntField")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomFieldIntValueDto extends CustomFieldDto {

	public Integer value;

    public CustomFieldIntValueDto() {}

	public CustomFieldIntValueDto(Integer value, List<String> flags) {
		this.value = value;
		this.flags = flags;
	}

    @Override @JsonIgnore
    public Object getObject() {
        return value;
    }
}
