package queries;

import java.util.ArrayList;
import java.util.List;

import utils.StringUtils;

public class ActivityQuery extends AbstractQuery { 

	public String sd, ed;
    public int adl = 1;
    public String chl;

    public ActivityQuery() {
    }
    
    public void setSd(String sd) {
    	this.sd = sd;
    }
    public void setStartDate(String sd) {
    	this.sd = sd;
    }
    public void setEd(String ed) {
    	this.ed = ed;
    }
    public void setEndDate(String ed) {
    	this.ed = ed;
    }
    public void setAdults(int adl) {
    	this.adl = adl;
    }
    public void setAdl(int adl) {
    	this.adl = adl;
    }
    public void setChildren(String chl) {
    	this.chl = chl;
    }
    public void setChl(String chl) {
    	this.chl = chl;
    }

    @Override
	protected String getStartDateParam() {
		return sd;
	}

	@Override
	protected String getEndDateParam() {
		return ed;
	}
	
	@Override
	public void setStartDateStr(String s) {
		sd = s;
	}

	@Override
	public void setEndDateStr(String s) {
		ed = s;
	}

	public int adults() {
        return adl;
    }

    public List<Integer> children() {
        return new ArrayList<Integer>(StringUtils.commaSeparatedToInts(chl));
    }

    public int totalPassengerCount() {
        return adults() + children().size();
    }
}
