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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExampleCarModel() {
		return exampleCarModel;
	}

	public void setExampleCarModel(String exampleCarModel) {
		this.exampleCarModel = exampleCarModel;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}
}
