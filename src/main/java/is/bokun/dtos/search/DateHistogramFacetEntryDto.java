package is.bokun.dtos.search;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DateHistogramFacetEntryDto {

	public Date time;
	public long count;
	
	public DateHistogramFacetEntryDto() {}
	
	public DateHistogramFacetEntryDto(Date time, long count) {
		this.time = time;
		this.count = count;
	}
}
