package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import is.bokun.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityBookingRequestDto {

	public Long activityId;
	public Long startTimeId;
	public String date;
    public String flexibleDayOption;
	
	public boolean pickup;
	public Long pickupPlaceId;
	public String pickupPlaceDescription;
	public String pickupPlaceRoomNumber;
	
	public boolean dropoff;
	public Long dropoffPlaceId;
	public String dropoffPlaceDescription;
	
	public List<ActivityPricingCategoryBookingDto> pricingCategoryBookings = new ArrayList<>();
	
	public List<ExtraBookingRequestDto> extras = new ArrayList<>();
	
	public ActivityBookingRequestDto() {}
	
	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getStartTimeId() {
		return startTimeId;
	}

	public void setStartTimeId(Long startTimeId) {
		this.startTimeId = startTimeId;
	}

    public String getFlexibleDayOption() {
        return flexibleDayOption;
    }

    public void setFlexibleDayOption(String flexibleDayOption) {
        this.flexibleDayOption = flexibleDayOption;
    }

    public void setPickup(boolean pickup) {
        this.pickup = pickup;
    }

    public void setDropoff(boolean dropoff) {
        this.dropoff = dropoff;
    }

    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@JsonIgnore
    public Date getDateObject() {
        return StringUtils.parseDate(date);
    }

    @JsonIgnore
    public int getTotalParticipants() {
        int counter = 0;
        for (ActivityPricingCategoryBookingDto pcb : pricingCategoryBookings) {
            counter += pcb.quantity;
        }
        return counter;
    }

	public List<ActivityPricingCategoryBookingDto> getPricingCategoryBookings() {
		return pricingCategoryBookings;
	}

	public void setPricingCategoryBookings(
			List<ActivityPricingCategoryBookingDto> pricingCategoryBookings) {
		this.pricingCategoryBookings = pricingCategoryBookings;
	}

	public List<ExtraBookingRequestDto> getExtras() {
		return extras;
	}

	public void setExtras(List<ExtraBookingRequestDto> extras) {
		this.extras = extras;
	}

	public Long getPickupPlaceId() {
		return pickupPlaceId;
	}

	public void setPickupPlaceId(Long pickupPlaceId) {
		this.pickupPlaceId = pickupPlaceId;
	}

	public String getPickupPlaceDescription() {
		return pickupPlaceDescription;
	}

	public void setPickupPlaceDescription(String pickupPlaceDescription) {
		this.pickupPlaceDescription = pickupPlaceDescription;
	}

	public String getPickupPlaceRoomNumber() {
		return pickupPlaceRoomNumber;
	}

	public void setPickupPlaceRoomNumber(String pickupPlaceRoomNumber) {
		this.pickupPlaceRoomNumber = pickupPlaceRoomNumber;
	}

	public Long getDropoffPlaceId() {
		return dropoffPlaceId;
	}

	public void setDropoffPlaceId(Long dropoffPlaceId) {
		this.dropoffPlaceId = dropoffPlaceId;
	}

	public String getDropoffPlaceDescription() {
		return dropoffPlaceDescription;
	}

	public void setDropoffPlaceDescription(String dropoffPlaceDescription) {
		this.dropoffPlaceDescription = dropoffPlaceDescription;
	}
	
}
