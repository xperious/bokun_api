package is.bokun.dtos.booking;

import is.bokun.queries.CarQuery;
import is.bokun.utils.*;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class CarRentalBookingRequestDto {

	public Long carRentalId;
	
	public String pickupDate;
	public Long pickupLocationId;
	
	public String dropoffDate;
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
	public String getDropoffDate() {
		return dropoffDate;
	}
	public void setDropoffDate(String dropoffDate) {
		this.dropoffDate = dropoffDate;
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
        return StringUtils.parseDate(pickupDate, CarQuery.DATE_FORMATS);
    }
    @JsonIgnore
    public Date getEndDate() {
        return StringUtils.parseDate(dropoffDate, CarQuery.DATE_FORMATS);
    }
    @JsonIgnore
    public int getDayCount() {
        return DateUtils.getRentalDayCount(getStartDate(), getEndDate());
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
