package is.bokun.queries;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

/**
 * For filtering results with fields that have values within a certain date range.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class DateRangeFilter {

    /**
     * The lower bound of the range. Defaults to start from the first.
     */
    public Date from;
    /**
     * The upper bound of the range. Defaults to unbounded.
     */
    public Date to;

    /**
     * Should the first "from" (if set) be inclusive or not. Defaults to true.
     */
    public boolean includeLower = true;
    /**
     * Should the last "to" (if set) be inclusive or not. Defaults to true.
     */
    public boolean includeUpper = true;

    public void setFrom(Date f) {
        this.from = f;
    }
    public void setTo(Date t) {
        this.to = t;
    }

    public void setIncludeLower(boolean includeLower) {
        this.includeLower = includeLower;
    }

    public void setIncludeUpper(boolean includeUpper) {
        this.includeUpper = includeUpper;
    }

    @JsonIgnore
    public boolean isActive() {
        return from != null || to != null;
    }
}
