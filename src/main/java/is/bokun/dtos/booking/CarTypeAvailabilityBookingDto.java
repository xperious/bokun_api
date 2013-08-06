package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import is.bokun.dtos.carrental.CarTypeAvailabilityDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarTypeAvailabilityBookingDto {

	public Long id;
	
	public CarTypeAvailabilityDto availability;
	
	public int bookedPrice;
}
