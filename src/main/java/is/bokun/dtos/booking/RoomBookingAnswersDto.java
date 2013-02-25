package is.bokun.dtos.booking;

import java.util.*;

public class RoomBookingAnswersDto {

	public Long bookingId;
	
	public List<BookingAnswerGroupDto> answerGroups = new ArrayList<BookingAnswerGroupDto>();
	public List<ExtraBookingAnswersDto> extraBookings = new ArrayList<ExtraBookingAnswersDto>();
	
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
	public List<ExtraBookingAnswersDto> getExtraBookings() {
		return extraBookings;
	}
	public void setExtraBookings(List<ExtraBookingAnswersDto> extraBookings) {
		this.extraBookings = extraBookings;
	}
	
	
}
