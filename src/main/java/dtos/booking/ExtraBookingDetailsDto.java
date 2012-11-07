package dtos.booking;

import java.util.*;

public class ExtraBookingDetailsDto {

	public Long bookingId;
	public String title;
	public int unitCount;
	public int unitPrice;
	
	public List<BookingAnswerWithIdDto> answers = new ArrayList<BookingAnswerWithIdDto>();
}
