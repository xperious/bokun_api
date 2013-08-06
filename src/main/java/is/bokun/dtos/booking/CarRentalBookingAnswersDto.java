package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarRentalBookingAnswersDto {

	public Long bookingId;
	
	public List<BookingAnswerGroupDto> answerGroups = new ArrayList<BookingAnswerGroupDto>();
	
	public List<CarBookingAnswersDto> carBookings = new ArrayList<CarBookingAnswersDto>();

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public List<BookingAnswerGroupDto> getAnswerGroups() {
		return answerGroups;
	}

	public void setAnswerGroups(List<BookingAnswerGroupDto> answerGroups) {
		this.answerGroups = answerGroups;
	}

	public List<CarBookingAnswersDto> getCarBookings() {
		return carBookings;
	}

	public void setRoomBookings(List<CarBookingAnswersDto> carBookings) {
		this.carBookings = carBookings;
	}
}
