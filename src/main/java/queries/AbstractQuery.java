package queries;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import utils.StringUtils;

/**
 * @author Olafur Gauti Gudmundsson
 */
public abstract class AbstractQuery {

    public String v; // view mode

    public LocationQuery l;

    public NumericRange p; // price range

    public int pg = 1;
    public int ps = 20;

    public Map<String,String[]> rawQueryString = new HashMap<String, String[]>();

    protected abstract String getStartDateParam();
    protected abstract String getEndDateParam();
    
    public boolean hasNonEmptyParam(String name) {
        return rawQueryString.containsKey(name) && !rawQueryString.get(name)[0].trim().isEmpty();
    }
    
    public String getFirstParamValue(String name) {
    	if ( hasNonEmptyParam(name) ) {
    		return rawQueryString.get(name)[0];
    	} else {
    		return null;
    	}
    }
    
    public abstract void setStartDateStr(String s);
    public Date startDate() {
        return StringUtils.parseDate(getStartDateParam());
    }
    public abstract void setEndDateStr(String s);
    public Date endDate() {
        return StringUtils.parseDate(getEndDateParam());
    }

    public boolean viewMap() {
        return v != null && v.equalsIgnoreCase("map");
    }
    public boolean viewList() {
        return v == null || !viewMap();
    }

    public boolean hasLocation() {
        return l != null && !(l.lat == 0 && l.lng == 0);
    }

    public LocationQuery location() {
        return l;
    }

    public boolean filterByPrice() {
        return p != null && p.filter("test") != null;
    }

    public int page() {
        if ( pg <= 0 ) {
            return 1;
        }
        return pg;
    }

    public int pageSize() {
        if ( ps <= 0 ) {
            return 20;
        }
        return ps;
    }
}
