package is.bokun.dtos.carrental;

import is.bokun.dtos.LocationDto;



public class CarRentalLocationDto {

	public Long id;	
	public String title;
	
	public boolean allDay;
	public int openingHour;
	public int closingHour;
	
	public int priceForPickup;
	public int priceForDropoff;
	public int priceForPickupAndDropoff;
	
	public LocationDto location = new LocationDto();

}
