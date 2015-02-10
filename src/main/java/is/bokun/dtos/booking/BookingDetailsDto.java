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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public String getExternalBookingReference() {
        return externalBookingReference;
    }

    public void setExternalBookingReference(String externalBookingReference) {
        this.externalBookingReference = externalBookingReference;
    }

    public BookingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BookingStatusEnum status) {
        this.status = status;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalPriceConverted() {
        return totalPriceConverted;
    }

    public void setTotalPriceConverted(Integer totalPriceConverted) {
        this.totalPriceConverted = totalPriceConverted;
    }

    public PaymentProviderDetailsDto getPaymentProviderDetails() {
        return paymentProviderDetails;
    }

    public void setPaymentProviderDetails(PaymentProviderDetailsDto paymentProviderDetails) {
        this.paymentProviderDetails = paymentProviderDetails;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public AffiliateDto getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(AffiliateDto affiliate) {
        this.affiliate = affiliate;
    }

    public BookingAgentWithLinksDto getAgent() {
        return agent;
    }

    public void setAgent(BookingAgentWithLinksDto agent) {
        this.agent = agent;
    }

    public VendorDto getSeller() {
        return seller;
    }

    public void setSeller(VendorDto seller) {
        this.seller = seller;
    }

    public BookingChannelDto getBookingChannel() {
        return bookingChannel;
    }

    public void setBookingChannel(BookingChannelDto bookingChannel) {
        this.bookingChannel = bookingChannel;
    }

    public IntegratedSystemConfigDto getSystemConfig() {
        return systemConfig;
    }

    public void setSystemConfig(IntegratedSystemConfigDto systemConfig) {
        this.systemConfig = systemConfig;
    }

    public List<AccommodationBookingDetailsDto> getAccommodationBookings() {
        return accommodationBookings;
    }

    public void setAccommodationBookings(List<AccommodationBookingDetailsDto> accommodationBookings) {
        this.accommodationBookings = accommodationBookings;
    }

    public List<CarRentalBookingDetailsDto> getCarRentalBookings() {
        return carRentalBookings;
    }

    public void setCarRentalBookings(List<CarRentalBookingDetailsDto> carRentalBookings) {
        this.carRentalBookings = carRentalBookings;
    }

    public List<ActivityBookingDetailsDto> getActivityBookings() {
        return activityBookings;
    }

    public void setActivityBookings(List<ActivityBookingDetailsDto> activityBookings) {
        this.activityBookings = activityBookings;
    }

    public List<RouteBookingDetailsDto> getRouteBookings() {
        return routeBookings;
    }

    public void setRouteBookings(List<RouteBookingDetailsDto> routeBookings) {
        this.routeBookings = routeBookings;
    }

    public List<BookingFieldDto> getBookingFields() {
        return bookingFields;
    }

    public void setBookingFields(List<BookingFieldDto> bookingFields) {
        this.bookingFields = bookingFields;
    }
}
