package is.bokun.queries;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * For filtering results with fields that have values within a certain numeric range.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class NumericRangeFilter {

    /**
     * The lower bound of the range. Defaults to start from the first.
     */
	public Integer from;
    /**
     * The upper bound of the range. Defaults to unbounded.
     */
    public Integer to;

    /**
     * Should the first "from" (if set) be inclusive or not. Defaults to true.
     */
	public boolean includeLower = true;
    /**
     * Should the last "to" (if set) be inclusive or not. Defaults to true.
     */
    public boolean includeUpper = true;
	
	public void setFrom(Integer f) {
		this.from = f;
	}
	public void setTo(Integer t) {
		this.to = t;
	}
	
	public void setIncludeLower(boolean includeLower) {
		this.includeLower = includeLower;
	}

	public void setIncludeUpper(boolean includeUpper) {
		this.includeUpper = includeUpper;
	}

	@JsonIgnore
    public Integer validatedFrom() {
        return from == null ? 0 : from;
    }
	@JsonIgnore
    public Integer validatedTo() {
        return to == null ? 0 : to;
    }
	
	@JsonIgnore
	public boolean isActive() {
		if ( (from != null && from >= 0) && (to != null && to > from) ) {
			// both end point specified
			return true;
		} else if ( (from == null) && (to != null && to > 0) ) {
			return true;
		} else if ( (from != null && from >= 0) && (to == null) ) {
			return true;
		}
		return false;
	}
	
	@JsonIgnore
	public String asComparison(String low, String high, String varName) {
		if ( (from != null && from >= 0) && (to != null && to > from) ) {
			return "(" + low + " <" + (includeLower ? "=" : "") + " " + varName + ") && (" + varName + " <" + (includeUpper ? "=" : "") + " " + high + ")";
		} else if ( (from == null) && (to != null && to > 0) ) {
			return varName + " <" + (includeUpper ? "=" : "") + " " + high;
		} else if ( (from != null && from >= 0) && (to == null) ) {
			return low + " <" + (includeLower ? "=" : "") + " " + varName;
		}
		return "true";
	}
}
