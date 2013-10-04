package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraBookingAnswersDto {

	public Long bookingId;
	
	public List<BookingAnswerWithIdGroupDto> answerGroups = new ArrayList<BookingAnswerWithIdGroupDto>();

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public List<BookingAnswerWithIdGroupDto> getAnswerGroups() {
		return answerGroups;
	}

	public void setAnswerGroups(List<BookingAnswerWithIdGroupDto> answerGroups) {
		this.answerGroups = answerGroups;
	}
}
