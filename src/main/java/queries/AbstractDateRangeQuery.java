package queries;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import utils.StringUtils;

public abstract class AbstractDateRangeQuery extends AbstractQuery {

	public String startDate, endDate;
	
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
