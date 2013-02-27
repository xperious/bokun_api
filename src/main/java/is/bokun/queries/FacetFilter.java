package is.bokun.queries;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import is.bokun.utils.StringUtils;

/**
 * Applies a filter to a facet.
 * <br/>
 * In the Bokun platform, the "TagGroup" is represented as a facet, and each individual "Tag" within the group
 * is represented as a facet value. This filter allows filtering hits by those entities.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class FacetFilter {

    /**
     * The name of the facet.
     * The facet name be configured for each TagGroup on the Bokun platform.
     */
	public String name;

    /**
     * A list of values that the facet must match.
     * The facet must match ALL values specified.
     */
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
