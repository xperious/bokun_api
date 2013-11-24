package is.bokun.dtos.activity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityAvailabilityDto {

	public String id;
	public String startTime;
	public Long startTimeId;
	public Date date;
	public String localizedDate;
    public int availabilityCount;
    public int bookedParticipants;
    public int minParticipants;
    public boolean unlimitedAvailability;

    public boolean comboActivity;
    public List<ComboStartTimeInfoDto> comboStartTimes = new ArrayList<>();
    
    public List<String> flags = new ArrayList<>();
    
    public double defaultPrice;
    public Map<Long,Double> pricesByCategory = new HashMap<>();
    
    public ActivityAvailabilityDto() {}

    public boolean isUnavailable() {
    	return !(availabilityCount > 0 || unlimitedAvailability == true);
    }
    
    public boolean isSoldOut() {
    	return unlimitedAvailability == false && availabilityCount == 0;
    }
    
    public int minParticipantsToBookNow() {
    	return (minParticipants - bookedParticipants) <= 0 ? 1 : (minParticipants - bookedParticipants);
    }

}
