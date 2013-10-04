package is.bokun.queries;

import com.fasterxml.jackson.annotation.*;

import is.bokun.utils.StringUtils;

/**
 * Filters results that exists within a range from a specific center point.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoDistanceRangeFilter {

    /**
     * The center geo point from which to calculate the distance.
     */
	public GeoPoint center = new GeoPoint();

    /**
     * The minimum distance, specified as a number followed by a distance unit (either mi/miles or km can be set).
     * Default value is "10km".
     */
	public String fromDistance = "10km";

    /**
     * The maximum distance, specified as a number followed by a distance unit (either mi/miles or km can be set).
     * Default value is "100km".
     */
	public String toDistance;

    /**
     * Should the "fromDistance" be inclusive or not. Defaults to true.
     */
    public boolean includeLower = true;

    /**
     * Should the "toDistance" be inclusive or not. Defaults to true.
     */
    public boolean includeUpper = true;
	
	public GeoDistanceRangeFilter() {}

	public void setCenter(GeoPoint center) {
		this.center = center;
	}

	public void setFromDistance(String fromDistance) {
		this.fromDistance = fromDistance;
	}

	public void setToDistance(String toDistance) {
		this.toDistance = toDistance;
	}

	public void setIncludeLower(boolean includeLower) {
		this.includeLower = includeLower;
	}

	public void setIncludeUpper(boolean includeUpper) {
		this.includeUpper = includeUpper;
	}
	
	@JsonIgnore
	public boolean isActive() {
		return center != null && !center.isEmpty() && (!StringUtils.isNullOrEmpty(fromDistance) || !StringUtils.isNullOrEmpty(toDistance));
	}
	
	
	// fluid methods

	@JsonIgnore
	public GeoDistanceRangeFilter center(double lat, double lng) {
		this.center = new GeoPoint(lat, lng);
		return this;
	}
	
	@JsonIgnore
	public GeoDistanceRangeFilter range(String from, String to) {
		this.fromDistance = from;
		this.toDistance = to;
		return this;
	}
	
	@JsonIgnore
	public GeoDistanceRangeFilter from(String from) {
		this.fromDistance = from;
		return this;
	}
	
	@JsonIgnore
	public GeoDistanceRangeFilter to(String to) {
		this.toDistance = to;
		return this;
	}
	
	@JsonIgnore
	public GeoDistanceRangeFilter includeUpper(boolean include) {
		this.includeUpper = include;
		return this;
	}
	
	@JsonIgnore
	public GeoDistanceRangeFilter includeLower(boolean include) {
		this.includeLower = include;
		return this;
	}
}
