package dtos.booking;

import java.util.*;

import dtos.activity.*;

public class ActivityBookingDto extends ProductBookingDto {

	public Date date;
	
	public ActivityDto activity;
	public StartTimeDto startTime;
	
	public int bookedPrice;
	public int bookedChildDiscount;
	public int bookedTeenDiscount;
	
	public String firstName;
	public String lastName;
	
	public int adults;
	public int teens;
	public int children;
	
	public int maxBookableCount;
	public boolean unlimitedAvailability;
	
	public List<ActivityExtraBookingDto> extraBookings = new ArrayList<ActivityExtraBookingDto>();
	
	public Date getSortDate() {
		return date;
	}
}
