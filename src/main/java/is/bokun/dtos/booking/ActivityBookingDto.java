package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.*;

import com.fasterxml.jackson.annotation.*;

import is.bokun.dtos.activity.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ActivityBookingDto extends ProductBookingDto {

	public Date date;
	
	public ProductInfoDto activity;
	public StartTimeDto startTime;

    public boolean flexible;
    public String selectedFlexDayOption;

    public Integer activityPrice;
    public Integer extrasPrice;
    
	public PickupPlaceDto pickupPlace;
	public String pickupPlaceDescription;
	public String pickupPlaceRoomNumber;
	public boolean pickup;
	
	public PickupPlaceDto dropoffPlace;
	public String dropoffPlaceDescription;
	public boolean dropoff;
	
	public Double pickupPrice;
	public Double dropoffPrice;
	
	public int maxBookableCount;
	public boolean unlimitedAvailability;
	
	public List<ActivityPricingCategoryBookingDto> pricingCategoryBookings = new ArrayList<>();
	
	public List<ExtraBookingDto> extraBookings = new ArrayList<>();
	
	@JsonIgnore
	public Date getSortDate() {
		return date;
	}

    @Override
    public VendorDto getVendor() {
        return activity.vendor;
    }
    
	@Override
	public String getProductCategory() {
		return "ACTIVITIES";
	}
	
	@JsonIgnore
	public int getTotalParticipants() {
		int total = 0;
		for (ActivityPricingCategoryBookingDto pc : pricingCategoryBookings) {
			total += pc.quantity;
		}
		return total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ProductInfoDto getActivity() {
		return activity;
	}

	public void setActivity(ProductInfoDto activity) {
		this.activity = activity;
	}

	public StartTimeDto getStartTime() {
		return startTime;
	}

	public void setStartTime(StartTimeDto startTime) {
		this.startTime = startTime;
	}

	public boolean isFlexible() {
		return flexible;
	}

	public void setFlexible(boolean flexible) {
		this.flexible = flexible;
	}

	public String getSelectedFlexDayOption() {
		return selectedFlexDayOption;
	}

	public void setSelectedFlexDayOption(String selectedFlexDayOption) {
		this.selectedFlexDayOption = selectedFlexDayOption;
	}

	public Integer getActivityPrice() {
		return activityPrice;
	}

	public void setActivityPrice(Integer activityPrice) {
		this.activityPrice = activityPrice;
	}

	public Integer getExtrasPrice() {
		return extrasPrice;
	}

	public void setExtrasPrice(Integer extrasPrice) {
		this.extrasPrice = extrasPrice;
	}

	public PickupPlaceDto getPickupPlace() {
		return pickupPlace;
	}

	public void setPickupPlace(PickupPlaceDto pickupPlace) {
		this.pickupPlace = pickupPlace;
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

	public boolean isPickup() {
		return pickup;
	}

	public void setPickup(boolean pickup) {
		this.pickup = pickup;
	}

	public PickupPlaceDto getDropoffPlace() {
		return dropoffPlace;
	}

	public void setDropoffPlace(PickupPlaceDto dropoffPlace) {
		this.dropoffPlace = dropoffPlace;
	}

	public String getDropoffPlaceDescription() {
		return dropoffPlaceDescription;
	}

	public void setDropoffPlaceDescription(String dropoffPlaceDescription) {
		this.dropoffPlaceDescription = dropoffPlaceDescription;
	}

	public boolean isDropoff() {
		return dropoff;
	}

	public void setDropoff(boolean dropoff) {
		this.dropoff = dropoff;
	}

	public Double getPickupPrice() {
		return pickupPrice;
	}

	public void setPickupPrice(Double pickupPrice) {
		this.pickupPrice = pickupPrice;
	}

	public Double getDropoffPrice() {
		return dropoffPrice;
	}

	public void setDropoffPrice(Double dropoffPrice) {
		this.dropoffPrice = dropoffPrice;
	}

	public int getMaxBookableCount() {
		return maxBookableCount;
	}

	public void setMaxBookableCount(int maxBookableCount) {
		this.maxBookableCount = maxBookableCount;
	}

	public boolean isUnlimitedAvailability() {
		return unlimitedAvailability;
	}

	public void setUnlimitedAvailability(boolean unlimitedAvailability) {
		this.unlimitedAvailability = unlimitedAvailability;
	}

	public List<ActivityPricingCategoryBookingDto> getPricingCategoryBookings() {
		return pricingCategoryBookings;
	}

	public void setPricingCategoryBookings(List<ActivityPricingCategoryBookingDto> pricingCategoryBookings) {
		this.pricingCategoryBookings = pricingCategoryBookings;
	}

	public List<ExtraBookingDto> getExtraBookings() {
		return extraBookings;
	}

	public void setExtraBookings(List<ExtraBookingDto> extraBookings) {
		this.extraBookings = extraBookings;
	}
}
