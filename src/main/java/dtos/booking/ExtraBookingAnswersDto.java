package dtos.booking;

import java.util.*;

public class ExtraBookingAnswersDto {

	public Long bookingId;
	
	public List<BookingAnswerWithIdDto> answers = new ArrayList<BookingAnswerWithIdDto>();

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public List<BookingAnswerWithIdDto> getAnswers() {
		return answers;
	}

	public void setAnswers(List<BookingAnswerWithIdDto> answers) {
		this.answers = answers;
	}
}
