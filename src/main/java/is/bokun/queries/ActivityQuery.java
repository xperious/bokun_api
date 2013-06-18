package is.bokun.queries;

import java.util.ArrayList;
import java.util.List;

import is.bokun.utils.StringUtils;

/**
 * Query object for searching Activities.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class ActivityQuery extends AbstractDateRangeQuery {

    /**
     * Number of adult participants.<br/>
     * Note: This is only relevant if date range is specified, else ignored.
     */
    public int adults = 1;
    /**
     * Child participants. The list should contain one item for each
     * child, and the item value should be the age of the child.<br/>
     * Note: This is only relevant if date range is specified, else ignored.
     */
    public List<Integer> children = new ArrayList<>();

    /**
     * Filter the results by location of any point in the agenda.
     */
    public LocationFilters agendaLocationFilters = new LocationFilters();

    /**
     * Filter the results by location of start points. Therefore only applied to
     * agenda items with places which are marked as possible start points of the
     * activity. <br/>
     * Useful for searching for all activities available from a certain location.
     */
    public LocationFilters startPointLocationFilters = new LocationFilters();

    public ActivityQuery() {
    }
    
	public ActivitySortField sortField() {
		if ( StringUtils.isNullOrEmpty(sortField) ) {
			return null;
		} else {
			try {
				return ActivitySortField.valueOf(sortField.toUpperCase());
			} catch ( Throwable ignored ) {
				return null;
			}
		}
	}
	
	public boolean sortingByPrice() {
		return sortField() != null && sortField() == ActivitySortField.PRICE;
	}

    public void setAdults(int adults) {
		this.adults = adults;
	}

	public void setChildren(List<Integer> children) {
		this.children = children;
	}

	public int totalPassengerCount() {
        return adults + children.size();
    }

	public void setAgendaLocationFilters(LocationFilters agendaLocationFilters) {
		this.agendaLocationFilters = agendaLocationFilters;
	}

	public void setStartPointLocationFilters(LocationFilters startPointLocationFilters) {
		this.startPointLocationFilters = startPointLocationFilters;
	}

	public int getAdults() {
		return adults;
	}

	public List<Integer> getChildren() {
		return children;
	}

	public LocationFilters getAgendaLocationFilters() {
		return agendaLocationFilters;
	}

	public LocationFilters getStartPointLocationFilters() {
		return startPointLocationFilters;
	}
}
