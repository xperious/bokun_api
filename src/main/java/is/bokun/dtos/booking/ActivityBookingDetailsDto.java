package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "activityBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityBookingDetailsDto extends ProductBookingDetailsDto {
	
	public Date date;
	
	public String startTime;
	public Long startTimeId;
	
	@XmlElementWrapper
	@XmlElement(name="pricingCategoryBooking")
	public List<ActivityPricingCategoryBookingDto> pricingCategoryBookings = new ArrayList<>();
	
	@XmlElementWrapper(name = "extraBookings")
	@XmlElement(name="extraBooking")
    public List<ExtraBookingDetailsDto> extras = new ArrayList<>();
    
	@XmlElementWrapper
	@XmlElement(name="field")
    public List<BookingFieldDto> bookingFields = new ArrayList<>();

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

	public List<ActivityPricingCategoryBookingDto> getPricingCategoryBookings() {
		return pricingCategoryBookings;
	}

	public void setPricingCategoryBookings(
			List<ActivityPricingCategoryBookingDto> pricingCategoryBookings) {
		this.pricingCategoryBookings = pricingCategoryBookings;
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

	public List<BookingFieldDto> getBookingFields() {
		return bookingFields;
	}

	public void setBookingFields(List<BookingFieldDto> bookingFields) {
		this.bookingFields = bookingFields;
	}

}
