package dtos.activity;

import java.util.Date;

public class ActivityAvailabilityDto {

	public Long startTimeId;
	public Date date;
	public String localizedDate;
    public int availabilityCount;
    public boolean unlimitedAvailability;
    
    public ActivityAvailabilityDto() {}
}
