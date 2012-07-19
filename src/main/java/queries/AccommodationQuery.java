package queries;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import utils.DateUtils;
import utils.StringUtils;


public class AccommodationQuery extends AbstractQuery {
	
	public String cin, cout;

	public List<RoomQuery> r = new ArrayList<RoomQuery>();

	public String t;

	public AccommodationSortField sort;
	public SortOrder order;

	public AccommodationQuery() {
		r.add(new RoomQuery(2, null));
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

	public Set<Long> idsFromParam(String name) {  
		return StringUtils.commaSeparatedStringToIds(rawQueryString.get(name)[0]);
	}

    public boolean hasType() {
        if ( t == null || t.trim().isEmpty() ) {
            return false;
        }
        return type() != null;
    }

    public String type() {
    	if ( t == null || t.trim().isEmpty() ) {
    		return null;
    	}
    	return t.toUpperCase();
    }
	
	public boolean isAvailabilityQuery() {
		return checkInDate() != null && checkOutDate() != null;
	}
	
	public Date checkInDate() {
		return startDate();
	}
	public Date checkOutDate() {
		return endDate();
	}
	
	public List<RoomQuery> rooms() {
		return r;
	}

    public int nightCount() {
        if ( !isAvailabilityQuery() ) {
            return 0;
        }
        return DateUtils.getNightCount(checkInDate(), checkOutDate());
    }

	public int minCapacityNeeded() {
		int min = r.get(0).sleepingPlacesNeeded();
		for ( RoomQuery q : r ) {
			min = Math.min(min, q.sleepingPlacesNeeded());
		}
		return min;
	}

    public int totalCapacityNeeded() {
        int count = 0;
        for ( RoomQuery q : r ) {
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
