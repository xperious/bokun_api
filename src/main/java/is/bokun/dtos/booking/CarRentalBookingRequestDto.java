package is.bokun.dtos.booking;

import is.bokun.utils.*;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class CarRentalBookingRequestDto {

	public Long carRentalId;
	
	public String pickupDate;
	public int pickupHour;
	public int pickupMinute;
	public Long pickupLocationId;
	
	public String dropoffDate;
	public int dropoffHour;
	public int dropoffMinute;
	public Long dropoffLocationId;
	
	public List<CarBookingDTO> cars = new ArrayList<>();
	
	
	public Long getCarRentalId() {
		return carRentalId;
	}
	public void setCarRentalId(Long carRentalId) {
		this.carRentalId = carRentalId;
	}
	public String getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	public int getPickupHour() {
		return pickupHour;
	}
	public void setPickupHour(int pickupHour) {
		this.pickupHour = pickupHour;
	}
	public int getPickupMinute() {
		return pickupMinute;
	}
	public void setPickupMinute(int pickupMinute) {
		this.pickupMinute = pickupMinute;
	}
	public String getDropoffDate() {
		return dropoffDate;
	}
	public void setDropoffDate(String dropoffDate) {
		this.dropoffDate = dropoffDate;
	}
	public int getDropoffHour() {
		return dropoffHour;
	}
	public void setDropoffHour(int dropoffHour) {
		this.dropoffHour = dropoffHour;
	}
	public int getDropoffMinute() {
		return dropoffMinute;
	}
	public void setDropoffMinute(int dropoffMinute) {
		this.dropoffMinute = dropoffMinute;
	}
	public Long getPickupLocationId() {
		return pickupLocationId;
	}
	public void setPickupLocationId(Long pickupLocationId) {
		this.pickupLocationId = pickupLocationId;
	}
	public Long getDropoffLocationId() {
		return dropoffLocationId;
	}
	public void setDropoffLocationId(Long dropoffLocationId) {
		this.dropoffLocationId = dropoffLocationId;
	}
	public List<CarBookingDTO> getCars() {
		return cars;
	}
	public void setCars(List<CarBookingDTO> cars) {
		this.cars = cars;
	}
	@JsonIgnore
    public Date getStartDate() {
        return StringUtils.parseDate(pickupDate);
    }
    @JsonIgnore
    public Date getEndDate() {
        return StringUtils.parseDate(dropoffDate);
    }
    @JsonIgnore
    public int getDayCount() {
        return DateUtils.getNightCount(getStartDate(), getEndDate());
    }
	
	
	public static class CarBookingDTO {
		
		public Long carTypeId;
		public int unitCount;
		public List<ExtraBookingDTO> extras = new ArrayList<ExtraBookingDTO>();
		public Long getCarTypeId() {
			return carTypeId;
		}
		public void setCarTypeId(Long carTypeId) {
			this.carTypeId = carTypeId;
		}
		public int getUnitCount() {
			return unitCount;
		}
		public void setUnitCount(int unitCount) {
			this.unitCount = unitCount;
		}
		public List<ExtraBookingDTO> getExtras() {
			return extras;
		}
		public void setExtras(List<ExtraBookingDTO> extras) {
			this.extras = extras;
		}
	}
	
    public static class ExtraBookingDTO {
    	
    	public Long extraId;
    	public int unitCount;
    	
    	public ExtraBookingDTO() {}

		public Long getExtraId() {
			return extraId;
		}

		public void setExtraId(Long extraId) {
			this.extraId = extraId;
		}

		public int getUnitCount() {
			return unitCount;
		}

		public void setUnitCount(int unitCount) {
			this.unitCount = unitCount;
		}
    	
    }
}
