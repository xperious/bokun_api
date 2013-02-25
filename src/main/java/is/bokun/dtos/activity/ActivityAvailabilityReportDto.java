package is.bokun.dtos.activity;

import java.text.SimpleDateFormat;
import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ActivityAvailabilityReportDto {

	public List<ActivityAvailabilityDto> availabilities = new ArrayList<ActivityAvailabilityDto>();
	
	public ActivityAvailabilityReportDto() {}
	
	public ActivityAvailabilityReportDto(List<ActivityAvailabilityDto> availabilities) {
		this.availabilities = availabilities;
	}
	
	@JsonIgnore
	public ActivityAvailabilityDto findByStartTimeAndDate(Long startTimeId, Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for (ActivityAvailabilityDto a : availabilities) {
			if ( a.startTimeId.equals(startTimeId) && formatter.format(a.date).equals(formatter.format(date)) ) {
				return a;
			}
		}
		return null;
	}
}
