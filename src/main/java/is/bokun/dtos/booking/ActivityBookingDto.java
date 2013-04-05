package is.bokun.dtos.booking;

import java.util.*;

import is.bokun.dtos.VendorDto;
import org.codehaus.jackson.annotate.JsonIgnore;

import is.bokun.dtos.activity.*;

public class ActivityBookingDto extends ProductBookingDto {

	public Date date;
	
	public ProductInfoDto activity;
	public StartTimeDto startTime;
	
	public int bookedPrice;
	public int bookedChildDiscount;
	public int bookedTeenDiscount;

    public Integer activityPrice;
    public Integer extrasPrice;
	
	public String firstName;
	public String lastName;
	
	public int adults;
	public int teens;
	public int children;
	
	public int maxBookableCount;
	public boolean unlimitedAvailability;
	
	public List<ExtraBookingDto> extraBookings = new ArrayList<>();
	
	@JsonIgnore
	public Date getSortDate() {
		return date;
	}

    @Override
    public VendorDto getVendor() {
        return activity.vendor;
    }
}
