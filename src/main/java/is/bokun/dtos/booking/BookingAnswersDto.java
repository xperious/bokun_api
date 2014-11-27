package is.bokun.dtos.booking;

import is.bokun.dtos.CustomerDto;
import is.bokun.utils.StringUtils;

import com.fasterxml.jackson.annotation.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingAnswersDto {

	public List<BookingAnswerDto> answers = new ArrayList<>();
	
	public List<AccommodationBookingAnswersDto> accommodationsBookings = new ArrayList<>();
	public List<CarRentalBookingAnswersDto> carRentalBookings = new ArrayList<>();
	public List<ActivityBookingAnswersDto> activityBookings = new ArrayList<>();
    public List<RouteBookingAnswersDto> routeBookings = new ArrayList<>();
	
	public List<BookingAnswerDto> getAnswers() {
		return answers;
	}
	public void setAnswers(List<BookingAnswerDto> answers) {
		this.answers = answers;
	}
	public List<AccommodationBookingAnswersDto> getAccommodationsBookings() {
		return accommodationsBookings;
	}
	public void setAccommodationsBookings(
			List<AccommodationBookingAnswersDto> accommodationsBookings) {
		this.accommodationsBookings = accommodationsBookings;
	}
	public List<ActivityBookingAnswersDto> getActivityBookings() {
		return activityBookings;
	}
	public void setActivityBookings(List<ActivityBookingAnswersDto> activityBookings) {
		this.activityBookings = activityBookings;
	}
    public List<CarRentalBookingAnswersDto> getCarRentalBookings() {
		return carRentalBookings;
	}
	public void setCarRentalBookings(
			List<CarRentalBookingAnswersDto> carRentalBookings) {
		this.carRentalBookings = carRentalBookings;
	}

    public List<RouteBookingAnswersDto> getRouteBookings() {
        return routeBookings;
    }

    public void setRouteBookings(List<RouteBookingAnswersDto> routeBookings) {
        this.routeBookings = routeBookings;
    }

    @JsonIgnore
	public void setSubscribeToEmailList(boolean subscribe) {
		answers.add(new BookingAnswerDto("email-list-subscription", Boolean.toString(subscribe)));
	}
	
	@JsonIgnore
	public boolean isSubscribeToEmailList() {
		for (BookingAnswerDto a : answers) {
			if ( "email-list-subscription".equalsIgnoreCase(a.getType()) ) {
				return "true".equalsIgnoreCase(a.getAnswer());
			}
		}
		return false;
	}
	
	@JsonIgnore
	public void setCustomerInfo(CustomerDto c) {
		answers.add(new BookingAnswerDto("first-name", c.getFirstName()));
		answers.add(new BookingAnswerDto("last-name", c.getLastName()));
		answers.add(new BookingAnswerDto("email", c.getEmail()));
		if ( !StringUtils.isNullOrEmpty(c.getPhoneNumber()) ) {
			answers.add(new BookingAnswerDto("phone-number", c.getPhoneNumber()));
		}
		if ( !StringUtils.isNullOrEmpty(c.getNationality()) ) {
			answers.add(new BookingAnswerDto("nationality", c.getNationality()));
		}
		if ( !StringUtils.isNullOrEmpty(c.getAddress()) ) {
			answers.add(new BookingAnswerDto("address", c.getAddress()));
		}
		if ( !StringUtils.isNullOrEmpty(c.getPostCode()) ) {
			answers.add(new BookingAnswerDto("post-code", c.getPostCode()));
		}
		if ( !StringUtils.isNullOrEmpty(c.getPlace()) ) {
			answers.add(new BookingAnswerDto("place", c.getPlace()));
		}
		if ( !StringUtils.isNullOrEmpty(c.getCountry()) ) {
			answers.add(new BookingAnswerDto("country", c.getCountry()));
		}		
		if ( !StringUtils.isNullOrEmpty(c.getOrganization()) ) {
			answers.add(new BookingAnswerDto("organization", c.getOrganization()));
		}
	}
	
	@JsonIgnore
    public CustomerDto getCustomerInfo() {
        CustomerDto dto = new CustomerDto();
        for (BookingAnswerDto a : answers) {
            if ( "first-name".equalsIgnoreCase(a.getType()) ) {
                dto.setFirstName(a.getAnswer());
            } else if ( "last-name".equalsIgnoreCase(a.getType()) ) {
                dto.setLastName(a.getAnswer());
            } else if ( "email".equalsIgnoreCase(a.getType()) ) {
                dto.setEmail(a.getAnswer());
            } else if ( "phone-number".equalsIgnoreCase(a.getType()) ) {
                dto.setPhoneNumber(a.getAnswer());
            } else if ( "nationality".equalsIgnoreCase(a.getType()) ) {
                dto.setNationality(a.getAnswer());
            } else if ( "address-street".equalsIgnoreCase(a.getType()) ) {
                dto.setAddress(a.getAnswer());
            } else if ( "address-postcode".equalsIgnoreCase(a.getType()) ) {
                dto.setPostCode(a.getAnswer());
            } else if ( "address-place".equalsIgnoreCase(a.getType()) ) {
                dto.setPlace(a.getAnswer());
            } else if ( "address-country".equalsIgnoreCase(a.getType()) ) {
                dto.setCountry(a.getAnswer());
            } else if ( "organization".equalsIgnoreCase(a.getType()) ) {
                dto.setOrganization(a.getAnswer());
            } else if ( "gender".equalsIgnoreCase(a.getType()) ) {
                dto.setSex(a.getAnswer());
            }
        }
        return dto;
    }
}
