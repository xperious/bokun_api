package is.bokun.queries;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * A filter allowing to include only hits that fall within a polygon of points.
 * If applied, then only results within the polygon will be returned.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class GeoPolygonFilter {

    /**
     * The points that describe the polygon.
     */
    public List<GeoPoint> points = new ArrayList<>();

    public GeoPolygonFilter() {}

	public List<GeoPoint> getPoints() {
		return points;
	}
	public void setPoints(List<GeoPoint> points) {
		this.points = points;
	}
	
	@JsonIgnore
	public boolean isActive() {
		return points != null && !points.isEmpty();
	}


	@JsonIgnore
	public GeoPolygonFilter add(double lat, double lng) {
		points.add(new GeoPoint(lat, lng));
		return this;
	}
}
