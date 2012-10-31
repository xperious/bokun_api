package dtos.booking;

import java.util.*;

public class ActivityBookingAnswersDto {

	public Long bookingId;
	
	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
	public List<ExtraBookingAnswersDto> extraBookings = new ArrayList<ExtraBookingAnswersDto>();
	
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
	public List<ExtraBookingAnswersDto> getExtraBookings() {
		return extraBookings;
	}
	public void setExtraBookings(List<ExtraBookingAnswersDto> extraBookings) {
		this.extraBookings = extraBookings;
	}
	
	
}
