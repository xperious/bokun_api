package dtos;

import com.codiform.moo.annotation.Property;

public class TripadvisorWidgetSettingsDto {

	public boolean enabled = false;
	public String pageUrl;
	public boolean showTravelerRating = false;
	public boolean showPopularityIndex = false;
	public boolean showRecentReviews = false;
	public int numberOfReviews = 5;
	
	@Property(translation = "extractLocationId()")
	public String locationId;
}
