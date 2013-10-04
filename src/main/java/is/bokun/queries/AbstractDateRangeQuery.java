package is.bokun.queries;

import java.util.Date;

import org.codehaus.jackson.annotate.*;

import is.bokun.utils.StringUtils;

/**
 * Abstract query class for date ranges, extends the AbstractQuery superclass with start and end dates.
 * The dates can include time, although by default they are assumed not to.
 * The date strings are parsed using a list of formats, and the output of the first one that successfully parses the date string
 * is used. Implementing classes can provide their own date/time formats. The default list of formats is (in order of parsing):
 * "dd.MM.yy", "dd.MM.yyyy", "yyyy-MM-dd".
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractDateRangeQuery extends AbstractQuery {

    /**
     * The start date of the range.
     */
	public String startDate;
    /**
     * The end date of the range.
     */
    public String endDate;
    
    public String[] dateFormats = {"dd.MM.yy", "dd.MM.yyyy", "yyyy-MM-dd"};
	
	public AbstractDateRangeQuery() {
		super();
	}
	
	public AbstractDateRangeQuery(String[] dateFormats) {
		super();
		this.dateFormats = dateFormats;
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
    	return StringUtils.parseDate(startDate, dateFormats);
    }
    
    @JsonIgnore
    public Date parseEndDate() {
    	return StringUtils.parseDate(endDate, dateFormats);
    }
}
