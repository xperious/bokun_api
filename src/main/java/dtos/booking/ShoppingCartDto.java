package dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ShoppingCartDto {

	public String sessionId;
	public String userUUID;
	public Date lastAccessDate;
	
	public int totalPrice;
	
	public List<AccommodationBookingDto> accommodationBookings = new ArrayList<AccommodationBookingDto>();
	public List<ActivityBookingDto> activityBookings = new ArrayList<ActivityBookingDto>();

	
	public ShoppingCartDto() {}
	
	@JsonIgnore
	public List<ProductBookingDto> getProductBookings() {
		List<ProductBookingDto> bookings = new ArrayList<ProductBookingDto>();
		
		bookings.addAll(accommodationBookings);
		
		return bookings;
	}
	
	@JsonIgnore
    public boolean isEmpty() {
        return accommodationBookings.isEmpty();
    }
}
