package queries;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class NumericRange {
	
	public Integer f;
	public Integer t;
	
	public void setF(Integer f) {
		this.f = f;
	}
	public void setT(Integer t) {
		this.t = t;
	}

    public Integer from() {
        return f == null ? 0 : f;
    }

    public Integer to() {
        return t == null ? 0 : t;
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
