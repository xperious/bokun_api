package is.bokun.queries;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import is.bokun.utils.StringUtils;

/**
 * Abstract query class for date ranges, extends the AbstractQuery superclass with start and end dates.
 * The dates do not include time.<br/>
 * The dates should be provided in one of the following formats (in order of parsing):
 * "dd.MM.yy", "dd.MM.yyyy", "yyyy-MM-dd".
 *
 * @author Olafur Gauti Gudmundsson
 */
public abstract class AbstractDateRangeQuery extends AbstractQuery {

    /**
     * The start date of the range.
     */
	public String startDate;
    /**
     * The end date of the range.
     */
    public String endDate;
	
	public AbstractDateRangeQuery() {
		super();
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
    @JsonIgnore
	public boolean isAvailabilityQuery() {
		return !StringUtils.isNullOrEmpty(startDate) && !StringUtils.isNullOrEmpty(endDate);
	}

    @JsonIgnore
    public Date parseStartDate() {
    	return StringUtils.parseDate(startDate);
    }
    
    @JsonIgnore
    public Date parseEndDate() {
    	return StringUtils.parseDate(endDate);
    }
}
