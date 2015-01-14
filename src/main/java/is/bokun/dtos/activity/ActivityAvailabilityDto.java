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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public long getActivityOwnerId() {
        return activityOwnerId;
    }

    public void setActivityOwnerId(long activityOwnerId) {
        this.activityOwnerId = activityOwnerId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Long getStartTimeId() {
        return startTimeId;
    }

    public void setStartTimeId(Long startTimeId) {
        this.startTimeId = startTimeId;
    }

    public boolean isFlexible() {
        return flexible;
    }

    public void setFlexible(boolean flexible) {
        this.flexible = flexible;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocalizedDate() {
        return localizedDate;
    }

    public void setLocalizedDate(String localizedDate) {
        this.localizedDate = localizedDate;
    }

    public int getAvailabilityCount() {
        return availabilityCount;
    }

    public void setAvailabilityCount(int availabilityCount) {
        this.availabilityCount = availabilityCount;
    }

    public int getBookedParticipants() {
        return bookedParticipants;
    }

    public void setBookedParticipants(int bookedParticipants) {
        this.bookedParticipants = bookedParticipants;
    }

    public int getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(int minParticipants) {
        this.minParticipants = minParticipants;
    }

    public boolean isPickupAllotment() {
        return pickupAllotment;
    }

    public void setPickupAllotment(boolean pickupAllotment) {
        this.pickupAllotment = pickupAllotment;
    }

    public int getPickupAvailabilityCount() {
        return pickupAvailabilityCount;
    }

    public void setPickupAvailabilityCount(int pickupAvailabilityCount) {
        this.pickupAvailabilityCount = pickupAvailabilityCount;
    }

    public boolean isUnlimitedAvailability() {
        return unlimitedAvailability;
    }

    public void setUnlimitedAvailability(boolean unlimitedAvailability) {
        this.unlimitedAvailability = unlimitedAvailability;
    }

    public boolean isComboActivity() {
        return comboActivity;
    }

    public void setComboActivity(boolean comboActivity) {
        this.comboActivity = comboActivity;
    }

    public List<ComboStartTimeInfoDto> getComboStartTimes() {
        return comboStartTimes;
    }

    public void setComboStartTimes(List<ComboStartTimeInfoDto> comboStartTimes) {
        this.comboStartTimes = comboStartTimes;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public Double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Map<Long, Double> getPricesByCategory() {
        return pricesByCategory;
    }

    public void setPricesByCategory(Map<Long, Double> pricesByCategory) {
        this.pricesByCategory = pricesByCategory;
    }

    public Double getPickupPrice() {
        return pickupPrice;
    }

    public void setPickupPrice(Double pickupPrice) {
        this.pickupPrice = pickupPrice;
    }

    public Map<Long, Double> getPickupPricesByCategory() {
        return pickupPricesByCategory;
    }

    public void setPickupPricesByCategory(Map<Long, Double> pickupPricesByCategory) {
        this.pickupPricesByCategory = pickupPricesByCategory;
    }

    public Double getDropoffPrice() {
        return dropoffPrice;
    }

    public void setDropoffPrice(Double dropoffPrice) {
        this.dropoffPrice = dropoffPrice;
    }

    public Map<Long, Double> getDropoffPricesByCategory() {
        return dropoffPricesByCategory;
    }

    public void setDropoffPricesByCategory(Map<Long, Double> dropoffPricesByCategory) {
        this.dropoffPricesByCategory = dropoffPricesByCategory;
    }

    public Map<Long, Double> getExtraPrices() {
        return extraPrices;
    }

    public void setExtraPrices(Map<Long, Double> extraPrices) {
        this.extraPrices = extraPrices;
    }
}
