package queries;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import utils.DateUtils;


public class AccommodationQuery extends AbstractQuery {
	
	public String cin, cout;

	public List<RoomQuery> rooms = new ArrayList<RoomQuery>();

	public AccommodationSortField sort;
	public SortOrder order;

	public AccommodationQuery() {
		super();
		rooms.add(new RoomQuery(2, null));
	}
	
	public void setCin(String s) {
		this.cin = s;
	}
	public void setCout(String s) {
		this.cout = s;
	}
	
	public void setRooms(List<RoomQuery> rooms) {
		this.rooms = rooms;
	}
	public List<RoomQuery> getRooms() {
		return rooms;
	}
	public List<RoomQuery> rooms() {
		return rooms;
	}
	
	public void setSort(AccommodationSortField s) {
		this.sort = s;
	}
	public AccommodationSortField getSort() {
		return sort;
	}
	public void setSortOrder(SortOrder s) {
		this.order = s;
	}
	public SortOrder getSortOrder() {
		return order;
	}

	@Override
	public void setStartDateStr(String s) {
		cin = s;
	}

	@Override
	public void setEndDateStr(String s) {
		cout = s;
	}

	@Override
	protected String getStartDateParam() {
		return cin;
	}

	@Override
	protected String getEndDateParam() {
		return cout;
	}

    public boolean hasType() {
        return hasFacet("type") && !facets.get("type").trim().isEmpty();
    }

    public String type() {
    	if ( !hasType() ) {
    		return null;
    	}
    	return facets.get("type").toUpperCase();
    }
	
    @JsonIgnore
	public boolean isAvailabilityQuery() {
		return checkInDate() != null && checkOutDate() != null;
	}
	
	public Date checkInDate() {
		return startDate();
	}
	public Date checkOutDate() {
		return endDate();
	}

    public int nightCount() {
        if ( !isAvailabilityQuery() ) {
            return 0;
        }
        return DateUtils.getNightCount(checkInDate(), checkOutDate());
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

	public int totalAdults() {
		int sum = 0;
		for ( RoomQuery q : rooms() ) {
			sum += q.adl;
		}
		return sum;
	}

	public int totalChildren() {
		int sum = 0;
		for ( RoomQuery q : rooms() ) {
			sum += q.children().size();
		}
		return sum;
	}

}
