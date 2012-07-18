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
}
