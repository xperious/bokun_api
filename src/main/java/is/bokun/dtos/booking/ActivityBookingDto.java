package is.bokun.dtos.booking;

import java.util.*;

import is.bokun.dtos.*;

import com.fasterxml.jackson.annotation.*;

import is.bokun.dtos.activity.*;

@JsonIgnoreProperties(ignoreUnknown = true)
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
}
