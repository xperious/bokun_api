package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class BookingDetailsDto {

	public Long bookingId;
    public String confirmationCode;
    public String status;
    public String qrCodeUrl;
    
	public int totalPrice;
	public int totalPriceConverted;

	public PaymentProviderDetailsDto paymentProviderDetails;
	
	public List<AccommodationBookingDetailsDto> accommodationBookings = new ArrayList<>(); 
	public List<CarRentalBookingDetailsDto> carRentalBookings = new ArrayList<>(); 
	public List<ActivityBookingDetailsDto> activityBookings = new ArrayList<>();
	
	@JsonIgnore
	public List<ProductBookingDetailsDto> getProductBookings() {
		List<ProductBookingDetailsDto> productBookings = new ArrayList<>();
		productBookings.addAll(accommodationBookings);
		productBookings.addAll(carRentalBookings);
		productBookings.addAll(activityBookings);
		return productBookings;
	}
	
}
