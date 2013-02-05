package dtos.booking;

import java.util.*;

public class BookingQuestionsDto {

	public List<BookingQuestionDto> questions = new ArrayList<BookingQuestionDto>();
	
	public List<AccommodationBookingQuestionsDto> accommodationBookings = new ArrayList<AccommodationBookingQuestionsDto>();
	public List<ActivityBookingQuestionsDto> activityBookings = new ArrayList<ActivityBookingQuestionsDto>();
	
	public boolean isEmpty() {
		return accommodationBookings.isEmpty() && activityBookings.isEmpty();
	}
	
	public int size() {
		return accommodationBookings.size() + activityBookings.size();
	}
}
