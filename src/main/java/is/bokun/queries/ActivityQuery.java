package is.bokun.queries;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import is.bokun.utils.StringUtils;

/**
 * Query object for searching Activities.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityQuery extends AbstractDateRangeQuery {

    /**
     * Number of participants.<br/>
     * Note: This is only relevant if date range is specified, else ignored.
     */
    public int participants = 1;

    /**
     * Set to true if you only want combo activities in the search results.
     */
    public Boolean comboActivity;

    /**
     * Age specified participants. The list should contain one item for each
     * participant, and the item value should be the age of the participant.<br/>
     * Note: This is only relevant if date range is specified, else ignored.
     */
    public List<Integer> participantsByAge = new ArrayList<>();

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


	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public List<Integer> getParticipantsByAge() {
		return participantsByAge;
	}

	public void setParticipantsByAge(List<Integer> participantsByAge) {
		this.participantsByAge = participantsByAge;
	}

	public int totalPassengerCount() {
        return participants + participantsByAge.size();
    }

	public void setAgendaLocationFilters(LocationFilters agendaLocationFilters) {
		this.agendaLocationFilters = agendaLocationFilters;
	}

	public void setStartPointLocationFilters(LocationFilters startPointLocationFilters) {
		this.startPointLocationFilters = startPointLocationFilters;
	}

	public LocationFilters getAgendaLocationFilters() {
		return agendaLocationFilters;
	}

	public LocationFilters getStartPointLocationFilters() {
		return startPointLocationFilters;
	}

    public Boolean getComboActivity() {
        return comboActivity;
    }

    public void setComboActivity(Boolean comboActivity) {
        this.comboActivity = comboActivity;
    }
}
