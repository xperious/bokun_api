package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "booking")
@XmlType(name = "booking")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingDetailsDto {

    @XmlElement
    public Date creationDate;

	@XmlElement(name = "id")
	public Long bookingId;
	@XmlElement
	public String language;
	@XmlElement
    public String confirmationCode;
    @XmlElement
    public String externalBookingReference;
	@XmlElement
    public BookingStatusEnum status;
	@XmlElement
    public String qrCodeUrl;
    @XmlElement
    public String currency;
    
	@XmlElement
	public Integer totalPrice;
	@XmlElement
	public Integer totalPriceConverted;

	@XmlTransient
	public PaymentProviderDetailsDto paymentProviderDetails;
	
	@XmlElement
	public CustomerDto customer;

    @XmlElement
    public AffiliateDto affiliate;

    @XmlElement
    public BookingAgentWithLinksDto agent;

    @XmlElement
    public VendorDto seller;

    @XmlElement
    public BookingChannelDto bookingChannel;

    @XmlElement
    public IntegratedSystemConfigDto systemConfig;

    @XmlElementWrapper
	@XmlElement(name="accommodationBooking")
	public List<AccommodationBookingDetailsDto> accommodationBookings = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="carRentalBooking")
	public List<CarRentalBookingDetailsDto> carRentalBookings = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="activityBooking")
	public List<ActivityBookingDetailsDto> activityBookings = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="routeBooking")
    public List<RouteBookingDetailsDto> routeBookings = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="bookingField")
    public List<BookingFieldDto> bookingFields = new ArrayList<>();



    @JsonIgnore
	public List<ProductBookingDetailsDto> getProductBookings() {
		List<ProductBookingDetailsDto> productBookings = new ArrayList<>();
        if ( accommodationBookings != null ) {
            productBookings.addAll(accommodationBookings);
        }
        if ( carRentalBookings != null ) {
            productBookings.addAll(carRentalBookings);
        }
        if ( activityBookings != null ) {
            productBookings.addAll(activityBookings);
        }
        if ( routeBookings != null ) {
            productBookings.addAll(routeBookings);
        }
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

    @JsonIgnore
    public RouteBookingDetailsDto findRouteBooking(Long id) {
        for (RouteBookingDetailsDto b : routeBookings) {
            if ( b.bookingId.equals(id) ) {
                return b;
            }
        }
        return null;
    }

    @JsonIgnore
    public Double calculateTotalDiscountedPrice() {
        double total = 0;
        for (ProductBookingDetailsDto b : getProductBookings()) {
            total += b.getPriceWithDiscount();
        }
        return total;
    }

    @JsonIgnore
    public Double calculateSavedAmount() {
        double saved = 0;
        for (ProductBookingDetailsDto b : getProductBookings()) {
            saved += b.getSavedAmount();
        }
        return saved;
    }

    @JsonIgnore
    public Double calculatePaidAmount() {
        double paidAmount = 0;
        for (SettlementDto p : getSettlements()) {
            if ( p.getAmount() != null) {
                paidAmount += p.getAmount();
            }
        }
        return paidAmount;
    }

    @JsonIgnore
    public List<SettlementDto> getSettlements() {
        List<SettlementDto> list = new ArrayList<>();
        for (ProductBookingDetailsDto pb : getProductBookings()) {
            list.addAll(pb.invoice.settlements);
        }
        return list;
    }

    @JsonIgnore
    public int calculateTotalPrice() {
        int total = 0;
        for (ProductBookingDetailsDto b : getProductBookings()) {
            total += b.totalPrice;
        }
        return total;
    }

}
