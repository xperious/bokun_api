package queries;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class LocationQuery {

	public double lat,lng;
	public String pref;
	public String dist;

	public String distance() {
		if ( dist == null || dist.trim().isEmpty() ) {
			return "50km";
		} else {
			return dist;
		}
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public void setPref(String pref) {
		this.pref = pref;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
}
