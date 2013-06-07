package is.bokun.dtos.booking;

import java.util.*;

public class BookingDetailsDto {

	public Long bookingId;
    public String confirmationCode;
    public String status;
    
	public int totalPrice;
	public int totalPriceConverted;

	public PaymentProviderDetailsDto paymentProviderDetails;
	
	public List<AccommodationBookingDetailsDto> accommodationBookings = new ArrayList<>(); 
	public List<CarRentalBookingDetailsDto> carRentalBookings = new ArrayList<>(); 
	public List<ActivityBookingDetailsDto> activityBookings = new ArrayList<>(); 
}
