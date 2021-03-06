package is.bokun.dtos.carrental;

import is.bokun.dtos.*;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarRentalDto extends ProductDto {

	public List<CarTypeDto> carTypes = new ArrayList<>();
	public List<CarRentalLocationDto> pickupLocations = new ArrayList<>();
	public List<CarRentalLocationDto> dropoffLocations = new ArrayList<>();
	public List<BookableExtraDto> bookableExtras = new ArrayList<>();

    public Long defaultPickupLocationId;
    public Long defaultDropoffLocationId;

    public int defaultPickupHour;
    public int defaultPickupMinute;
    public int defaultDropoffHour;
    public int defaultDropoffMinute;
	
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
	
	@JsonIgnore
    public CarTypeDto findCarType(Long id) {
    	for (CarTypeDto rt : carTypes) { 
    		if ( rt.id.equals(id) ) {
    			return rt;
    		}
    	}
    	return null;
    }
}
