package is.bokun.dtos.carrental;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import is.bokun.dtos.search.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarSearchResultsDto extends AbstractSearchResultsDto {

	public List<CarTypeDto> items = new ArrayList<>();

	public List<CarTypeDto> getItems() {
		return items;
	}

	public void setItems(List<CarTypeDto> items) {
		this.items = items;
	}
}
