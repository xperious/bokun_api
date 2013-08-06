package is.bokun.dtos.activity;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityDayAvailabilitiesDto {

	public Date date;
	public String localizedDate;
	
	public List<ActivityAvailabilityDto> availabilities = new ArrayList<>();
}
