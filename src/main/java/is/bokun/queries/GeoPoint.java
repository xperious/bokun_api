package is.bokun.queries;

import org.codehaus.jackson.annotate.*;

/**
 * Represents a point in geographical coordinates: latitude and longitude.<br/>
 * Latitude ranges between -90 and 90 degrees, inclusive. Values above or below this range will be
 * clamped to the nearest value within this range. For example, specifying a latitude of 100 will set the value to 90.<br/>
 * Longitude ranges between -180 and 180 degrees, inclusive.Values above or below this range will be
 * wrapped such that they fall within the range [-180, 180). For example, 480, 840 and 1200 will all be wrapped to 120 degrees.<br/>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPoint {

	private double lat,lng;
	
	public GeoPoint() {}
	
	public GeoPoint(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
        if ( lat < -90 ) {
            this.lat = -90;
        } else if ( lat > 90 ) {
            this.lat = 90;
        } else {
            this.lat = lat;
        }
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
        if ( lng < -180 ) {
            this.lng = -180;
        } else if ( lng > 180 ) {
            this.lng = 180;
        } else {
		    this.lng = lng;
        }
	}
	
	@JsonIgnore
	public boolean isEmpty() {
		return lat == 0d && lng == 0d;
	}
	
}
