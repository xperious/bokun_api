package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import is.bokun.dtos.carrental.CarTypeAvailabilityDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarTypeAvailabilityBookingDto {

	public Long id;
	
	public CarTypeAvailabilityDto availability;
	
	public int bookedPrice;
}
