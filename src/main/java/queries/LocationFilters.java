package queries;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * All the supported location filters.
 * Note that if GeoDistanceFilter is applied, then GeoDistanceRangeFilter will be ignored.
 * Similarly, if GeoBoundingBoxFilter is applied, then GeoPolygonFilter will be ignored.
 */
public class LocationFilters {

	public GeoDistanceFilter geoDistanceFilter;
	public GeoDistanceRangeFilter geoDistanceRangeFilter;
	public GeoBoundingBoxFilter geoBoundingBoxFilter;
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
