package queries;

import org.codehaus.jackson.annotate.JsonIgnore;

import utils.StringUtils;

/**
 * Filters documents that exists within a range from a specific center point.
 */
public class GeoDistanceRangeFilter {

	public GeoPoint center = new GeoPoint();
	public String fromDistance;
	public String toDistance;
	public boolean includeLower, includeUpper = true;
	
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
