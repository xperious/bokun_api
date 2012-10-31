package dtos.booking;

import java.util.*;

public class BookingAnswersDto {

	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
	
	public List<AccommodationBookingAnswersDto> accommodationsBookings = new ArrayList<AccommodationBookingAnswersDto>();
	public List<ActivityBookingAnswersDto> activityBookings = new ArrayList<ActivityBookingAnswersDto>();
	
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
}
