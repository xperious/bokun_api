package is.bokun.dtos.carrental;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarTypeInfoDto {

	public Long id;
	public String title;
	public String exampleCarModel;
	
	public List<String> flags = new ArrayList<>();
	
	public CarTypeInfoDto() {}
	
	public CarTypeInfoDto(Long id, String title, List<String> flags) {
		this.id = id;
		this.title = title;
		this.flags = flags;
	}
}
