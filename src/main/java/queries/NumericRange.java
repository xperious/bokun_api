package queries;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class NumericRange {
	
	public Integer from;
	public Integer to;
	
	public void setFrom(Integer f) {
		this.from = f;
	}
	public void setTo(Integer t) {
		this.to = t;
	}

    public Integer from() {
        return from == null ? 0 : from;
    }

    public Integer to() {
        return to == null ? 0 : to;
    }
	
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
