package dtos.booking;

import java.util.*;

public class BookingDetailsDto {

	public Long bookingId;
    public String confirmationCode;
    public String status;
    
	public int totalPrice;
	public int totalPriceConverted;
	
	public PaymentDetailsDto paymentDetails;
	
	public List<AccommodationBookingDetailsDto> accommodationBookings = new ArrayList<AccommodationBookingDetailsDto>(); 
	public List<ActivityBookingDetailsDto> activityBookings = new ArrayList<ActivityBookingDetailsDto>(); 
}
