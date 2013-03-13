package is.bokun.dtos.booking;

import is.bokun.dtos.CustomerDto;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.*;

public class BookingAnswersDto {

	public List<BookingAnswerDto> answers = new ArrayList<>();
	
	public List<AccommodationBookingAnswersDto> accommodationsBookings = new ArrayList<>();
	public List<ActivityBookingAnswersDto> activityBookings = new ArrayList<>();
	
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
            } else if ( "address".equalsIgnoreCase(a.getType()) ) {
                dto.setAddress(a.getAnswer());
            } else if ( "post-code".equalsIgnoreCase(a.getType()) ) {
                dto.setPostCode(a.getAnswer());
            } else if ( "place".equalsIgnoreCase(a.getType()) ) {
                dto.setPlace(a.getAnswer());
            } else if ( "country".equalsIgnoreCase(a.getType()) ) {
                dto.setCountry(a.getAnswer());
            } else if ( "organization".equalsIgnoreCase(a.getType()) ) {
                dto.setOrganization(a.getAnswer());
            }
        }
        return dto;
    }
}
