package dtos.booking;

import java.util.*;

public class ExtraBookingQuestionsDto {

	public Long bookingId;
	public BookingItemInfoDto extra;
	
	public List<BookingQuestionWithIdDto> questions = new ArrayList<BookingQuestionWithIdDto>();
	
}
