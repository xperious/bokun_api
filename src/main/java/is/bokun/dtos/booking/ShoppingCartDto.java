package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement(name = "ShoppingCart")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoppingCartDto {

	public String sessionId;
	public String customerUUID;
	public Date lastAccessDate;
	
	public int totalPrice;
	public int totalPriceInInvoiceCurrency;
	
	public List<AccommodationBookingDto> accommodationBookings = new ArrayList<>();
	public List<CarRentalBookingDto> carRentalBookings = new ArrayList<>();
	public List<ActivityBookingDto> activityBookings = new ArrayList<>();
    public List<RouteBookingDto> routeBookings = new ArrayList<>();

	
	public ShoppingCartDto() {}

    public int getSize() {
        return getProductBookings().size();
    }
	
	@JsonIgnore
	public List<ProductBookingDto> getProductBookings() {
		List<ProductBookingDto> bookings = new ArrayList<>();
		
		bookings.addAll(accommodationBookings);
		bookings.addAll(carRentalBookings);
		bookings.addAll(activityBookings);
        bookings.addAll(routeBookings);
		
		Collections.sort(bookings, new Comparator<ProductBookingDto>() {
			@Override
			public int compare(ProductBookingDto arg0, ProductBookingDto arg1) {
				return arg0.getSortDate().compareTo(arg1.getSortDate());
			}
		});
		
		return bookings;
	}

    @JsonIgnore
    public ProductBookingDto findProductBookingById(String productCategory, Long id) {
        for (ProductBookingDto dto : getProductBookings()) {
            if ( dto.getProductCategory().equals(productCategory) && dto.id.equals(id) ) {
                return dto;
            }
        }
        return null;
    }
	
	@JsonIgnore
    public boolean isEmpty() {
        return getProductBookings().isEmpty();
    }

    public List<CarRentalBookingDto> getCarRentalBookings() {
        return carRentalBookings;
    }

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getCustomerUUID() {
		return customerUUID;
	}

	public void setCustomerUUID(String customerUUID) {
		this.customerUUID = customerUUID;
	}

	public Date getLastAccessDate() {
		return lastAccessDate;
	}

	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalPriceInInvoiceCurrency() {
		return totalPriceInInvoiceCurrency;
	}

	public void setTotalPriceInInvoiceCurrency(int totalPriceInInvoiceCurrency) {
		this.totalPriceInInvoiceCurrency = totalPriceInInvoiceCurrency;
	}

	public List<AccommodationBookingDto> getAccommodationBookings() {
		return accommodationBookings;
	}

	public void setAccommodationBookings(List<AccommodationBookingDto> accommodationBookings) {
		this.accommodationBookings = accommodationBookings;
	}

	public void setCarRentalBookings(List<CarRentalBookingDto> carRentalBookings) {
		this.carRentalBookings = carRentalBookings;
	}

	public List<ActivityBookingDto> getActivityBookings() {
		return activityBookings;
	}

	public void setActivityBookings(List<ActivityBookingDto> activityBookings) {
		this.activityBookings = activityBookings;
	}

	public List<RouteBookingDto> getRouteBookings() {
		return routeBookings;
	}

	public void setRouteBookings(List<RouteBookingDto> routeBookings) {
		this.routeBookings = routeBookings;
	}
}
