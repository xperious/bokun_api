package dtos.activity;

import java.util.Date;

public class ActivityAvailabilityDto {

	public String id;
	public String startTime;
	public Long startTimeId;
	public Date date;
	public String localizedDate;
    public int availabilityCount;
    public boolean unlimitedAvailability;
    public int adultPrice;
    
    public ActivityAvailabilityDto() {}

    public boolean isUnavailable() {
    	return !(availabilityCount > 0 || unlimitedAvailability == true);
    }
    
    public boolean isSoldOut() {
    	return unlimitedAvailability == false && availabilityCount == 0;
    }

}
