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

	public List<BookingQuestionDto> getQuestions() {
		return questions;
	}

	public void setQuestions(List<BookingQuestionDto> questions) {
		this.questions = questions;
	}

	public List<AccommodationBookingQuestionsDto> getAccommodationBookings() {
		return accommodationBookings;
	}

	public void setAccommodationBookings(List<AccommodationBookingQuestionsDto> accommodationBookings) {
		this.accommodationBookings = accommodationBookings;
	}

	public List<CarRentalBookingQuestionsDto> getCarRentalBookings() {
		return carRentalBookings;
	}

	public void setCarRentalBookings(List<CarRentalBookingQuestionsDto> carRentalBookings) {
		this.carRentalBookings = carRentalBookings;
	}

	public List<ActivityBookingQuestionsDto> getActivityBookings() {
		return activityBookings;
	}

	public void setActivityBookings(List<ActivityBookingQuestionsDto> activityBookings) {
		this.activityBookings = activityBookings;
	}

	public List<RouteBookingQuestionsDto> getRouteBookings() {
		return routeBookings;
	}

	public void setRouteBookings(List<RouteBookingQuestionsDto> routeBookings) {
		this.routeBookings = routeBookings;
	}
}
