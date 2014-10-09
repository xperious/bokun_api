package is.bokun.dtos.booking;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.PickupPlaceDto;
import is.bokun.dtos.activity.ActivityDto;
import is.bokun.dtos.activity.PickupPricingTypeEnum;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "activityBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityBookingDetailsDto extends ProductBookingDetailsDto {
	
	public Date date;
	
	public String startTime;
	public Long startTimeId;

    public ActivityDto activity;

    public boolean flexible;
    public String selectedFlexDayOption;

    public boolean customized;

    @XmlElementWrapper
    @XmlElement(name="comboBooking")
    public List<ProductBookingBasicsDto> comboChildBookings;

    public ProductBookingBasicsDto comboParentBooking;

	@XmlElementWrapper
	@XmlElement(name="pricingCategoryBooking")
	public List<ActivityPricingCategoryBookingDto> pricingCategoryBookings = new ArrayList<>();
	
	@XmlElementWrapper(name = "extraBookings")
	@XmlElement(name="extraBooking")
    public List<ExtraBookingDetailsDto> extras = new ArrayList<>();
    
	@XmlElementWrapper
	@XmlElement(name="field")
    public List<BookingFieldDto> bookingFields = new ArrayList<>();
    
	public PickupPlaceDto pickupPlace;
	public String pickupPlaceDescription;
	public String pickupPlaceRoomNumber;
	public boolean pickup;
    public String pickupTime;
	
	public PickupPlaceDto dropoffPlace;
	public String dropoffPlaceDescription;
	public boolean dropoff;
	
	public PickupPricingTypeEnum bookedPickupPricingType;
	public PickupPricingTypeEnum bookedDropoffPricingType;

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

	public void setDropoff(boolean dropoff) {
		this.dropoff = dropoff;
	}

	public PickupPricingTypeEnum getBookedPickupPricingType() {
		return bookedPickupPricingType;
	}

	public void setBookedPickupPricingType(
			PickupPricingTypeEnum bookedPickupPricingType) {
		this.bookedPickupPricingType = bookedPickupPricingType;
	}

	public PickupPricingTypeEnum getBookedDropoffPricingType() {
		return bookedDropoffPricingType;
	}

	public void setBookedDropoffPricingType(
			PickupPricingTypeEnum bookedDropoffPricingType) {
		this.bookedDropoffPricingType = bookedDropoffPricingType;
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

    public List<ProductBookingBasicsDto> getComboChildBookings() {
        return comboChildBookings;
    }

    public void setComboChildBookings(List<ProductBookingBasicsDto> comboChildBookings) {
        this.comboChildBookings = comboChildBookings;
    }

    public ProductBookingBasicsDto getComboParentBooking() {
        return comboParentBooking;
    }

    public void setComboParentBooking(ProductBookingBasicsDto comboParentBooking) {
        this.comboParentBooking = comboParentBooking;
    }

    public ActivityDto getActivity() {
        return activity;
    }

    public void setActivity(ActivityDto activity) {
        this.activity = activity;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

}
