package is.bokun.dtos.activity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityAvailabilityDto {

	public String id;
    public long activityId;
    public long activityOwnerId;
    public String startTime;
	public Long startTimeId;
    public boolean flexible;
	public Date date;
	public String localizedDate;
    public int availabilityCount;
    public int bookedParticipants;
    public int minParticipants;

    public boolean pickupAllotment;
    public int pickupAvailabilityCount;
    public boolean unlimitedAvailability;

    public boolean comboActivity;
    public List<ComboStartTimeInfoDto> comboStartTimes = new ArrayList<>();
    
    public List<String> flags = new ArrayList<>();
    
    public Double defaultPrice;
    public Map<Long,Double> pricesByCategory = new HashMap<>();

    public Double pickupPrice;
    public Map<Long,Double> pickupPricesByCategory = new HashMap<>();

    public Double dropoffPrice;
    public Map<Long,Double> dropoffPricesByCategory = new HashMap<>();

    public Map<Long,Double> extraPrices = new HashMap<>();

    public ActivityAvailabilityDto() {}

    public boolean isUnavailable() {
    	return !(availabilityCount > 0 || unlimitedAvailability);
    }
    
    public boolean isSoldOut() {
    	return !unlimitedAvailability && availabilityCount == 0;
    }
    
    public int minParticipantsToBookNow() {
    	return (minParticipants - bookedParticipants) <= 0 ? 1 : (minParticipants - bookedParticipants);
    }

}
