package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingQuestionsDto {

	public List<BookingQuestionDto> questions = new ArrayList<>();
	
	public List<AccommodationBookingQuestionsDto> accommodationBookings = new ArrayList<>();
	public List<CarRentalBookingQuestionsDto> carRentalBookings = new ArrayList<>();
	public List<ActivityBookingQuestionsDto> activityBookings = new ArrayList<>();
    public List<RouteBookingQuestionsDto> routeBookings = new ArrayList<>();
	
	public boolean isEmpty() {
		return accommodationBookings.isEmpty() && activityBookings.isEmpty() && carRentalBookings.isEmpty() && routeBookings.isEmpty();
	}
	
	public int size() {
		return accommodationBookings.size() + activityBookings.size() + carRentalBookings.size() + routeBookings.size();
	}
}
