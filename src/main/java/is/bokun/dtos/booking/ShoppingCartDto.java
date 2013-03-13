package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ShoppingCartDto {

	public String sessionId;
	public String customerUUID;
	public Date lastAccessDate;
	
	public int totalPrice;
	
	public List<AccommodationBookingDto> accommodationBookings = new ArrayList<>();
	public List<ActivityBookingDto> activityBookings = new ArrayList<>();

	
	public ShoppingCartDto() {}

    public int getSize() {
        return getProductBookings().size();
    }
	
	@JsonIgnore
	public List<ProductBookingDto> getProductBookings() {
		List<ProductBookingDto> bookings = new ArrayList<>();
		
		bookings.addAll(accommodationBookings);
		bookings.addAll(activityBookings);
		
		Collections.sort(bookings, new Comparator<ProductBookingDto>() {
			@Override
			public int compare(ProductBookingDto arg0, ProductBookingDto arg1) {
				return arg0.getSortDate().compareTo(arg1.getSortDate());
			}
		});
		
		return bookings;
	}
	
	@JsonIgnore
    public boolean isEmpty() {
        return accommodationBookings.isEmpty() && activityBookings.isEmpty();
    }
}
