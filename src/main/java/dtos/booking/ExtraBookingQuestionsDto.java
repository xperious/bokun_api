package dtos.booking;

import java.util.*;

public class ExtraBookingQuestionsDto {

	public Long bookingId;
	public BookingItemInfoDto extra;
	public int unitCount;
	
	public List<BookingQuestionWithIdGroupDto> questionGroups = new ArrayList<BookingQuestionWithIdGroupDto>();
	
}
