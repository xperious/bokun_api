package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccommodationBookingAnswersDto {

	public Long bookingId;
	
	public List<BookingAnswerGroupDto> answerGroups = new ArrayList<BookingAnswerGroupDto>();
	
	public List<RoomBookingAnswersDto> roomBookings = new ArrayList<RoomBookingAnswersDto>();

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

	public List<RoomBookingAnswersDto> getRoomBookings() {
		return roomBookings;
	}

	public void setRoomBookings(List<RoomBookingAnswersDto> roomBookings) {
		this.roomBookings = roomBookings;
	}
	
}
