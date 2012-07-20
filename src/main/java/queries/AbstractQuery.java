package queries;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

import utils.StringUtils;

/**
 * @author Olafur Gauti Gudmundsson
 */
public abstract class AbstractQuery {

    public String vm; // view mode

    public LocationQuery lq;

    public NumericRange pr; // price range
    
    public List<FacetQuery> facets = new ArrayList<FacetQuery>();

    public int pg = 1;
    public int ps = 20;

    @JsonIgnore
    public Map<String,String[]> rawQueryString = new HashMap<String, String[]>();
    
    public AbstractQuery() {
    }
    
    protected abstract String getStartDateParam();
    protected abstract String getEndDateParam();
    
    public void setFacets(List<FacetQuery> facets) {
    	this.facets = facets;
    }
    public List<FacetQuery> facets() {
    	return facets;
    }
    
    public void setVm(String v) {
    	this.vm = v;
    }
    public void setLq(LocationQuery l) {
    	this.lq = l;
    }
    public void setLocation(LocationQuery l) {
    	setLq(l);
    }
    public void setPr(NumericRange p) {
    	this.pr = p;
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
        return vm != null && vm.equalsIgnoreCase("map");
    }
    public boolean viewList() {
        return vm == null || !viewMap();
    }
    public String viewMode() {
    	return vm;
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
