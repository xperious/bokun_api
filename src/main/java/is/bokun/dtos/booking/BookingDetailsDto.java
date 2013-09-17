package is.bokun.dtos.booking;

import is.bokun.dtos.CustomerDto;

import java.util.*;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "booking")
@XmlType(name = "booking")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingDetailsDto {

	@XmlElement(name = "id")
	public Long bookingId;
	@XmlElement
    public String confirmationCode;
	@XmlElement
    public BookingStatusEnum status;
	@XmlElement
    public String qrCodeUrl;
    
	@XmlElement
	public int totalPrice;
	@XmlElement
	public int totalPriceConverted;

	@XmlTransient
	public PaymentProviderDetailsDto paymentProviderDetails;
	
	@XmlElement
	public CustomerDto customer;
	
	@XmlElementWrapper
	@XmlElement(name="accommodationBooking")
	public List<AccommodationBookingDetailsDto> accommodationBookings = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="carRentalBooking")
	public List<CarRentalBookingDetailsDto> carRentalBookings = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="activityBooking")
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
