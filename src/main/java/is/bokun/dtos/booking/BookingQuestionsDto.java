package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingQuestionsDto {

	public List<BookingQuestionDto> questions = new ArrayList<BookingQuestionDto>();
	
	public List<AccommodationBookingQuestionsDto> accommodationBookings = new ArrayList<AccommodationBookingQuestionsDto>();
	public List<CarRentalBookingQuestionsDto> carRentalBookings = new ArrayList<CarRentalBookingQuestionsDto>();
	public List<ActivityBookingQuestionsDto> activityBookings = new ArrayList<ActivityBookingQuestionsDto>();
	
	public boolean isEmpty() {
		return accommodationBookings.isEmpty() && activityBookings.isEmpty() && carRentalBookings.isEmpty();
	}
	
	public int size() {
		return accommodationBookings.size() + activityBookings.size() + carRentalBookings.size();
	}
}
