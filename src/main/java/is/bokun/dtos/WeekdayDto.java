package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "weekday")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeekdayDto {

	public int index;
	public String name;
	
	public WeekdayDto() {}
	
	public WeekdayDto(int index, String name) {
		this.index = index;
		this.name = name;
	}
}
