package is.bokun.queries;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * A filter allowing to filter hits based on a point location using a bounding box.
 * If applied, then only results within the box will be returned.
 * When a result has multiple locations: once a single location / point matches the filter, the hit will be included in the filter.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class GeoBoundingBoxFilter {

    /**
     * The top-left coordinates of the box.
     */
	public GeoPoint topLeft;
    /**
     * The bottom-right coordinates of the box.
     */
    public GeoPoint bottomRight;
	
	public GeoBoundingBoxFilter() {}

	public GeoPoint getTopLeft() {
		return topLeft;
	}
	public void setTopLeft(GeoPoint topLeft) {
		this.topLeft = topLeft;
	}
	public GeoPoint getBottomRight() {
		return bottomRight;
	}
	public void setBottomRight(GeoPoint bottomRight) {
		this.bottomRight = bottomRight;
	}
	
	@JsonIgnore
	public boolean isActive() {
		return topLeft != null && !topLeft.isEmpty() && bottomRight != null && !bottomRight.isEmpty();
	}
	
	
	// fluid methods

	@JsonIgnore
	public GeoBoundingBoxFilter topLeft(double lat, double lng) {
		this.topLeft = new GeoPoint(lat, lng);
		return this;
	}
	
	@JsonIgnore
	public GeoBoundingBoxFilter bottomRight(double lat, double lng) {
		this.bottomRight = new GeoPoint(lat, lng);
		return this;
	}
}
