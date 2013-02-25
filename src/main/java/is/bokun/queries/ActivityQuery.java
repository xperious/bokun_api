package is.bokun.queries;

import java.util.ArrayList;
import java.util.List;

import is.bokun.utils.StringUtils;

public class ActivityQuery extends AbstractDateRangeQuery { 

    public int adults = 1;
    public List<Integer> children = new ArrayList<>();
    
    public LocationFilters agendaLocationFilters = new LocationFilters(); 
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
}
