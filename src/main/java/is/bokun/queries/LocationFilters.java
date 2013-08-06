package is.bokun.queries;

import org.codehaus.jackson.annotate.*;

/**
 * All the supported location filters.
 * <br/><br/>
 * Note that GeoDistanceFilter and GeoDistanceRangeFilter are mutually exclusive, that is, if GeoDistanceFilter is applied,
 * then GeoDistanceRangeFilter will be ignored.
 * <br/>
 * Similarly, GeoBoundingBoxFilter and GeoPolygonFilter are mutually exclusive: if GeoBoundingBoxFilter is applied, then
 * GeoPolygonFilter will be ignored.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationFilters {

    /**
     * Match results within a given distance from a center point.
     */
	public GeoDistanceFilter geoDistanceFilter;
    /**
     * Match results within a given distance range from a center point.
     */
	public GeoDistanceRangeFilter geoDistanceRangeFilter;

    /**
     * Match results within a given box.
     */
	public GeoBoundingBoxFilter geoBoundingBoxFilter;
    /**
     * Match results within a given polygon.
     */
	public GeoPolygonFilter geoPolygonFilter;
	
	public void setGeoDistanceFilter(GeoDistanceFilter geoDistanceFilter) {
		this.geoDistanceFilter = geoDistanceFilter;
	}
	public void setGeoDistanceRangeFilter(
			GeoDistanceRangeFilter geoDistanceRangeFilter) {
		this.geoDistanceRangeFilter = geoDistanceRangeFilter;
	}
	public void setGeoBoundingBoxFilter(GeoBoundingBoxFilter geoBoundingBoxFilter) {
		this.geoBoundingBoxFilter = geoBoundingBoxFilter;
	}
	public void setGeoPolygonFilter(GeoPolygonFilter geoPolygonFilter) {
		this.geoPolygonFilter = geoPolygonFilter;
	}
	
	public GeoDistanceFilter getGeoDistanceFilter() {
		return geoDistanceFilter;
	}
	public GeoDistanceRangeFilter getGeoDistanceRangeFilter() {
		return geoDistanceRangeFilter;
	}
	public GeoBoundingBoxFilter getGeoBoundingBoxFilter() {
		return geoBoundingBoxFilter;
	}
	public GeoPolygonFilter getGeoPolygonFilter() {
		return geoPolygonFilter;
	}
	
	@JsonIgnore
	public boolean hasGeoDistanceFilter() {
		return geoDistanceFilter != null && geoDistanceFilter.isActive();
	}
	@JsonIgnore
	public boolean hasGeoDistanceRangeFilter() {
		return geoDistanceRangeFilter != null && geoDistanceRangeFilter.isActive();
	}
	@JsonIgnore
	public boolean hasGeoBoundingBoxFilter() {
		return geoBoundingBoxFilter != null && geoBoundingBoxFilter.isActive();
	}
	@JsonIgnore
	public boolean hasGeoPolygonFilter() {
		return geoPolygonFilter != null && geoPolygonFilter.isActive();
	}
}
