package is.bokun.queries;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import is.bokun.utils.StringUtils;

public class FacetFilter {

	public String name;
	public List<String> values = new ArrayList<>();
	
	public FacetFilter() {}
	
	public FacetFilter(String name, String value) {
		this.name = name;
		this.values.add(value);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	
	@JsonIgnore
	public Set<Long> getValuesAsSetOfLong() {
		Set<Long> set = new HashSet<>();
		for (String v : values) {
			if ( !StringUtils.isNullOrEmpty(v) ) {
				try {
					set.add(Long.parseLong(v));
				} catch (Throwable ignored) {}
			}
		}
		return set;
	}
	
}
