package is.bokun.queries;

import org.codehaus.jackson.annotate.*;

/**
 * Filters results that include only hits that exists within a specific distance from a geo point.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoDistanceFilter {

    /**
     * The center geo point from which to calculate the distance.
     */
	public GeoPoint center = new GeoPoint();

    /**
     * The distance, specified as a number followed by a distance unit (either mi/miles or km can be set).
     * Default value is "50km".
     */
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
