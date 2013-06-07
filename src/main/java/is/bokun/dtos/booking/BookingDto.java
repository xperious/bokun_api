package is.bokun.dtos.booking;

import java.util.*;

public class BookingDto {

	public Long id;
    public Date creationDate;
    public Date lastModifiedDate;
    
    public String confirmationCode;
    public String status;
    
	public int totalPrice;
	
	public List<AccommodationBookingDto> accommodationBookings = new ArrayList<>();
	public List<CarRentalBookingDto> carRentalBookings = new ArrayList<>();
	public List<ActivityBookingDto> activityBookings = new ArrayList<>();

}
