package is.bokun.dtos.carrental;

import is.bokun.dtos.*;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class CarRentalDto extends ProductDto {

	public List<CarTypeDto> carTypes = new ArrayList<>();
	public List<CarRentalLocationDto> pickupLocations = new ArrayList<>();
	public List<CarRentalLocationDto> dropoffLocations = new ArrayList<>();
	public List<BookableExtraDto> bookableExtras = new ArrayList<>();
	
	public CarRentalDto() {
		super();
	}
	
	@JsonIgnore
	public CarRentalLocationDto findPickupLocation(Long locationId) {
		for (CarRentalLocationDto l : pickupLocations) {
			if ( l.id.equals(locationId) ) {
				return l;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public CarRentalLocationDto findDropoffLocation(Long locationId) {
		for (CarRentalLocationDto l : dropoffLocations) {
			if ( l.id.equals(locationId) ) {
				return l;
			}
		}
		return null;
	}
}
