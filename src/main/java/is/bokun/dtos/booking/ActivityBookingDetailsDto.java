package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityBookingDetailsDto extends ProductBookingDetailsDto {
	
	public Date date;
	public List<ActivityPricingCategoryBookingDto> pricingCategoryBookings = new ArrayList<>();
    public List<ExtraBookingDetailsDto> extras = new ArrayList<>();
    public Map<String,String> fields = new HashMap<>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ExtraBookingDetailsDto> getExtras() {
        return extras;
    }

    public void setExtras(List<ExtraBookingDetailsDto> extras) {
        this.extras = extras;
    }

	public Map<String, String> getFields() {
		return fields;
	}

	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}

	public List<ActivityPricingCategoryBookingDto> getPricingCategoryBookings() {
		return pricingCategoryBookings;
	}

	public void setPricingCategoryBookings(
			List<ActivityPricingCategoryBookingDto> pricingCategoryBookings) {
		this.pricingCategoryBookings = pricingCategoryBookings;
	}

}
