package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.*;

import is.bokun.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityBookingRequestDto {

	public Long activityId;
	public Long startTimeId;
	public String date;
	
	public Map<Long,Integer> participantsByPricingCategory = new HashMap<>();
	
	public List<ExtraBookingRequestDto> extras = new ArrayList<ExtraBookingRequestDto>();
	
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

	public Map<Long, Integer> getParticipantsByPricingCategory() {
		return participantsByPricingCategory;
	}

	public void setParticipantsByPricingCategory(
			Map<Long, Integer> participantsByPricingCategory) {
		this.participantsByPricingCategory = participantsByPricingCategory;
	}

	public List<ExtraBookingRequestDto> getExtras() {
		return extras;
	}

	public void setExtras(List<ExtraBookingRequestDto> extras) {
		this.extras = extras;
	}
	
}
