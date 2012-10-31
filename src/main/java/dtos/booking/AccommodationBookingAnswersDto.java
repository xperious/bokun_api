package dtos.booking;

import java.util.*;

public class AccommodationBookingAnswersDto {

	public Long bookingId;
	
	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
	
	public List<RoomBookingAnswersDto> roomBookings = new ArrayList<RoomBookingAnswersDto>();

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public List<BookingAnswerDto> getAnswers() {
		return answers;
	}

	public void setAnswers(List<BookingAnswerDto> answers) {
		this.answers = answers;
	}

	public List<RoomBookingAnswersDto> getRoomBookings() {
		return roomBookings;
	}

	public void setRoomBookings(List<RoomBookingAnswersDto> roomBookings) {
		this.roomBookings = roomBookings;
	}
	
}
