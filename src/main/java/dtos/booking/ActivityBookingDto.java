package dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import dtos.activity.*;

public class ActivityBookingDto extends ProductBookingDto {

	public Date date;
	
	public ProductInfoDto activity;
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
	
	public List<ExtraBookingDto> extraBookings = new ArrayList<>();
	
	@JsonIgnore
	public Date getSortDate() {
		return date;
	}
}
