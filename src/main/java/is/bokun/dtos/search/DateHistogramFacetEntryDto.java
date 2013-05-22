package is.bokun.dtos.search;

import java.util.Date;

public class DateHistogramFacetEntryDto {

	public Date time;
	public long count;
	
	public DateHistogramFacetEntryDto() {}
	
	public DateHistogramFacetEntryDto(Date time, long count) {
		this.time = time;
		this.count = count;
	}
}
