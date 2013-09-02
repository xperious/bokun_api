package is.bokun.dtos.booking;

import is.bokun.dtos.CustomerDto;

import java.util.*;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDetailsDto {

	public Long bookingId;
    public String confirmationCode;
    public String status;
    public String qrCodeUrl;
    
	public int totalPrice;
	public int totalPriceConverted;

	public PaymentProviderDetailsDto paymentProviderDetails;
	
	public CustomerDto customer;
	
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
	
	@JsonIgnore
	public AccommodationBookingDetailsDto findAccommodationBooking(Long id) {
		for (AccommodationBookingDetailsDto b : accommodationBookings) {
			if ( b.bookingId.equals(id) ) {
				return b;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public ActivityBookingDetailsDto findActivityBooking(Long id) {
		for (ActivityBookingDetailsDto b : activityBookings) {
			if ( b.bookingId.equals(id) ) {
				return b;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public CarRentalBookingDetailsDto findCarRentalBooking(Long id) {
		for (CarRentalBookingDetailsDto b : carRentalBookings) {
			if ( b.bookingId.equals(id) ) {
				return b;
			}
		}
		return null;
	}
	
}
