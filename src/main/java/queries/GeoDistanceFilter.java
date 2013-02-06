package queries;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Filters documents that include only hits that exists within a specific distance from a geo point.
 *
 */
public class GeoDistanceFilter {

	public GeoPoint center = new GeoPoint();
	public String distance = "50km";
	
	public GeoDistanceFilter() {}
	
	public GeoPoint getCenter() {
		return center;
	}
	public void setCenter(GeoPoint center) {
		this.center = center;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	@JsonIgnore
	public boolean isActive() {
		return center != null && !center.isEmpty();
	}
	
	
	// fluid methods
	
	@JsonIgnore
	public GeoDistanceFilter center(double centerLat, double centerLng) {
		this.center = new GeoPoint(centerLat, centerLng);
		return this;
	}
	
	@JsonIgnore
	public GeoDistanceFilter distance(String distance) {
		this.distance = distance;
		return this;
	}
	
}
