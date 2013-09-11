package is.bokun.queries;

import java.util.*;

import org.codehaus.jackson.annotate.*;

import is.bokun.utils.StringUtils;

/**
 * Applies a filter to a facet.
 * <br/>
 * In the Bokun platform, the "TagGroup" is represented as a facet, and each individual "Tag" within the group
 * is represented as a facet value. This filter allows filtering hits by those entities.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
	
	/**
	 * Specifies whether to negate this filter. 
	 * If set to true, then will exclude all results matching this filter.
	 * If set to false, then will include only results matching this filter.
	 */
	public boolean excluded;
	
	public FacetFilter() {}
	
	public FacetFilter(String name, String value, boolean excluded) {
		this.name = name;
		this.values.add(value);
		this.excluded = excluded;
	}
	
	public FacetFilter(String name, String value) {
		this(name, value, false);
	}

	public FacetFilter(String name, List<String> values, boolean excluded) {
		this.name = name;
		this.values = values;
		this.excluded = excluded;
	}
	
	public FacetFilter(String name, List<String> values) {
		this(name, values, false);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	
	public String getName() {
		return name;
	}

	public List<String> getValues() {
		return values;
	}

	public boolean isExcluded() {
		return excluded;
	}

	public void setExcluded(boolean excluded) {
		this.excluded = excluded;
	}

	@JsonIgnore
	public String getSingleValue() {
		if ( values.isEmpty() ) {
			return "";
		} else {
			return values.iterator().next();
		}
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
