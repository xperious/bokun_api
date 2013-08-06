package is.bokun.dtos.search;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DateHistogramFacetDto extends AbstractFacet {

	public List<DateHistogramFacetEntryDto> entries = new ArrayList<>();
	
	public DateHistogramFacetDto() {}
	
	public DateHistogramFacetDto(String name) {
		super(name);
	}
}
