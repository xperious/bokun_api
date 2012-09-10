package queries;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import utils.StringUtils;

/**
 * @author Olafur Gauti Gudmundsson
 */
public abstract class AbstractQuery {

    public LocationQuery lq = new LocationQuery();

    public NumericRange pr; // price range
    
    public Map<String,String> facets = new HashMap<String,String>();

    public int pg = 1;
    public int ps = 20;
    
    public AbstractQuery() {
    }
    
    protected abstract String getStartDateParam();
    protected abstract String getEndDateParam();
    
    public void setFacets(Map<String,String> facetMap) {
    	this.facets = facetMap;
    }
    public Map<String,String> getFacets() {
    	return facets;
    }
    public Set<String> getFacetValues(String name) {
    	return StringUtils.commaSeparatedToSet(facets.get(name));
    }
    public boolean hasFacet(String name) {
    	return facets.containsKey(name);
    }
    public String getSingleFacetValue(String name) {
    	Set<String> set = getFacetValues(name);
    	if ( set.isEmpty() ) {
    		return "";
    	} else {
    		return set.iterator().next();
    	}
    }
    
    public void setLq(LocationQuery l) {
    	this.lq = l;
    }
    public LocationQuery getLq() {
    	return lq;
    }
    public void setLocation(LocationQuery l) {
    	setLq(l);
    }
    public void setPr(NumericRange p) {
    	this.pr = p;
    }
    public NumericRange getPr() {
    	return pr;
    }
    public void setPrice(NumericRange p) {
    	this.pr = p;
    }
    public void setPage(int pg) {
    	this.pg = pg;
    }
    public void setPg(int pg) {
    	this.pg = pg;
    }
    public void setPs(int ps) {
    	this.ps = ps;
    }
    public void setPageSize(int ps) {
    	this.ps = ps;
    }
    
    public abstract void setStartDateStr(String s);
    public Date startDate() {
        return StringUtils.parseDate(getStartDateParam());
    }
    public abstract void setEndDateStr(String s);
    public Date endDate() {
        return StringUtils.parseDate(getEndDateParam());
    }

    public boolean hasLocation() {
        return lq != null && !(lq.lat == 0 && lq.lng == 0);
    }

    public LocationQuery location() {
        return lq;
    }
    
    public NumericRange priceRange() {
    	return pr;
    }

    public boolean filterByPrice() {
    	if ( pr == null ) {
    		return false;
    	}
		if ( (pr.from != null && pr.from >= 0) && (pr.to != null && pr.to > pr.from) ) {
			return true;
		} else if ( (pr.from == null) && (pr.to != null && pr.to > 0) ) {
			return true;
		} else if ( (pr.from != null && pr.from >= 0) && (pr.to == null) ) {
			return true;
		}
		return false;
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
