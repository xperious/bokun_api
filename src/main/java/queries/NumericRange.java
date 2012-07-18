package queries;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class NumericRange {
	
	public Integer f;
	public Integer t;

    public Integer from() {
        return f == null ? 0 : f;
    }

    public Integer to() {
        return t == null ? 0 : t;
    }

	public Object filter(String field) {
		/*
		if ( (f != null && f >= 0) && (t != null && t > f) ) {
			return numericRangeFilter(field).from(f).to(t).includeLower(true).includeUpper(true);
		} else if ( (f == null) && (t != null && t > 0) ) {
			return numericRangeFilter(field).lte(t);
		} else if ( (f != null && f >= 0) && (t == null) ) {
			return numericRangeFilter(field).gte(f);
		}*/
		return null;
	}
	
	public String asComparison(String low, String high, String varName) {
		if ( (f != null && f >= 0) && (t != null && t > f) ) {
			return "(" + low + " <= " + varName + ") && (" + varName + " <= " + high + ")";
		} else if ( (f == null) && (t != null && t > 0) ) {
			return varName + " <= " + high;
		} else if ( (f != null && f >= 0) && (t == null) ) {
			return low + " <= " + varName;
		}
		return "true";
	}
}
