package dtos.activity;

import java.util.*;

public class ActivityDayAvailabilitiesDto {

	public Date date;
	public String localizedDate;
	
	public List<ActivityAvailabilityDto> availabilities = new ArrayList<>();
}
