package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import is.bokun.utils.StringUtils;

public class ActivityBookingRequestDto {

	public Long activityId;
	public Long startTimeId;
	public String date;
	public int adults;
	public int teens;
	public int children;
	public List<ExtraBookingDTO> extras = new ArrayList<ExtraBookingDTO>();
	
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

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getTeens() {
		return teens;
	}

	public void setTeens(int teens) {
		this.teens = teens;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public List<ExtraBookingDTO> getExtras() {
		return extras;
	}

	public void setExtras(List<ExtraBookingDTO> extras) {
		this.extras = extras;
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
