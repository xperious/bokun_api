package is.bokun.dtos.booking;

import is.bokun.dtos.CustomerDto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "Booking")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingDetailsDto {

	@XmlAttribute(name = "id")
	public Long bookingId;
	@XmlElement
    public String confirmationCode;
	@XmlElement
    public String status;
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
