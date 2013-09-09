package is.bokun.dtos.booking;

import java.util.*;

import is.bokun.dtos.VendorDto;

import org.codehaus.jackson.annotate.*;

import is.bokun.dtos.activity.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityBookingDto extends ProductBookingDto {

	public Date date;
	
	public ProductInfoDto activity;
	public StartTimeDto startTime;

    public Integer activityPrice;
    public Integer extrasPrice;
	
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
	public Double getTotalParticipantPrice() {
		double total = 0d;
		for (ActivityPricingCategoryBookingDto pc : pricingCategoryBookings) {
			total += (pc.bookedPrice * pc.quantity);
		}
		return total;
	}
}
