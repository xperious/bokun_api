package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeekdayDto {

	public int index;
	public String name;
	
	public WeekdayDto() {}
	
	public WeekdayDto(int index, String name) {
		this.index = index;
		this.name = name;
	}
}
