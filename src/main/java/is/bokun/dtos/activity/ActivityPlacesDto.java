package is.bokun.dtos.activity;

import is.bokun.dtos.PickupPlaceDto;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityPlacesDto {

	public List<PickupPlaceDto> pickupPlaces = new ArrayList<>();
	
	public List<PickupPlaceDto> dropoffPlaces = new ArrayList<>();
}
