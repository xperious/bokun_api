package is.bokun.queries;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.*;

import is.bokun.utils.DateUtils;
import is.bokun.utils.StringUtils;

/**
 * Query object for searching Accommodations.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccommodationQuery extends AbstractDateRangeQuery {

    /**
     * List of room requirements (number of rooms and number of guests in each room). <br/>
     * Note: This is only relevant if date range is specified, else ignored.
     */
	public List<RoomQuery> rooms = new ArrayList<>();

    /**
     * Filter the results by location.
     */
	public LocationFilters locationFilters = new LocationFilters();

	public AccommodationQuery() {
		super();
		rooms.add(new RoomQuery(2, null));
	}
	
	public void setRooms(List<RoomQuery> rooms) {
		this.rooms = rooms;
	}
	public void setLocationFilters(LocationFilters l) {
		this.locationFilters = l;
	}
	@JsonIgnore
	public boolean hasDistanceField() {
		return locationFilters != null && (locationFilters.hasGeoDistanceFilter() || locationFilters.hasGeoDistanceRangeFilter());
	}
	@JsonIgnore
	public GeoPoint getDistancePoint() {
		if ( hasDistanceField() ) {
			if ( locationFilters.hasGeoDistanceFilter() ) {
				return locationFilters.geoDistanceFilter.center;
			} else if ( locationFilters.hasGeoDistanceRangeFilter() ) {
				return locationFilters.geoDistanceRangeFilter.center;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public AccommodationSortField sortField() {
		if ( StringUtils.isNullOrEmpty(sortField) ) {
			return null;
		} else {
			try {
				return AccommodationSortField.valueOf(sortField.toUpperCase());
			} catch ( Throwable ignored ) {
				return null;
			}
		}
	}
	@JsonIgnore
	public boolean sortingByPrice() {
		return sortField() != null && sortField() == AccommodationSortField.PRICE;
	}
	@JsonIgnore
	public boolean sortingByDistance() {
		return sortField() != null && sortField() == AccommodationSortField.DISTANCE;
	}


	@JsonIgnore
    public boolean hasTypeFilter() {
        return hasFacetFilter("type") && !getSingleFacetFilterValue("type").trim().isEmpty();
    }

	@JsonIgnore
    public String typeFilter() {
    	if ( !hasTypeFilter() ) {
    		return null;
    	}
    	return getSingleFacetFilterValue("type").toUpperCase();
    }

    public int nightCount() {
        if ( !isAvailabilityQuery() ) {
            return 0;
        }
        return DateUtils.getNightCount(parseStartDate(), parseEndDate());
    }

	public int minCapacityNeeded() {
		int min = rooms.get(0).sleepingPlacesNeeded();
		for ( RoomQuery q : rooms ) {
			min = Math.min(min, q.sleepingPlacesNeeded());
		}
		return min;
	}

    public int totalCapacityNeeded() {
        int count = 0;
        for ( RoomQuery q : rooms ) {
            count += q.sleepingPlacesNeeded();
        }
        return count;
    }
    
    public int totalPersons() {
    	return totalAdults() + totalChildren();
    }

	public int totalAdults() {
		int sum = 0;
		for ( RoomQuery q : rooms ) {
			sum += q.adults;
		}
		return sum;
	}

	public int totalChildren() {
		int sum = 0;
		for ( RoomQuery q : rooms ) {
			sum += q.children.size();
		}
		return sum;
	}

}
