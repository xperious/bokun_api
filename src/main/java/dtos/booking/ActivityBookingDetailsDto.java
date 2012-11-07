package dtos.booking;

import java.util.*;

public class ActivityBookingDetailsDto {

	public Long bookingId;
	public String title;
	public Date date;
	
	public int totalPrice;
	
	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
	public List<ExtraBookingDetailsDto> extras = new ArrayList<ExtraBookingDetailsDto>();
	
}
