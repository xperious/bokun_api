package queries;

import org.codehaus.jackson.annotate.JsonIgnore;

public class GeoPoint {

	public double lat,lng;
	
	public GeoPoint() {}
	
	public GeoPoint(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	@JsonIgnore
	public boolean isEmpty() {
		return lat == 0d && lng == 0d;
	}
	
}
