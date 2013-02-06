package queries;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class NumericRangeFilter {
	
	public Integer from, to;
	public boolean includeLower, includeUpper = true;
	
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
			return "(" + low + " <= " + varName + ") && (" + varName + " <= " + high + ")";
		} else if ( (from == null) && (to != null && to > 0) ) {
			return varName + " <= " + high;
		} else if ( (from != null && from >= 0) && (to == null) ) {
			return low + " <= " + varName;
		}
		return "true";
	}
}
