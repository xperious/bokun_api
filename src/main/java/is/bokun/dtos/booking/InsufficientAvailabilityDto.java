package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InsufficientAvailabilityDto {

	public List<InsufficientAvailabilityItemDto> items = new ArrayList<>();
	
	public List<InsufficientAvailabilityItemDto> getItems() {
		return items;
	}
	
	public void setItems(List<InsufficientAvailabilityItemDto> items) {
		this.items = items;
	}
	
	@JsonIgnore
	public boolean isEmpty() {
		return items.isEmpty();
	}
}
