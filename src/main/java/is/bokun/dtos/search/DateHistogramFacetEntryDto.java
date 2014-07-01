package is.bokun.dtos.search;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DateHistogramFacetEntryDto {

	public Date time;
	public long count;
    public double max,min,mean,total;

	public DateHistogramFacetEntryDto() {}
	
	public DateHistogramFacetEntryDto(Date time, long count, double max, double min, double mean, double total) {
		this.time = time;
		this.count = count;
        this.max = max;
        this.min = min;
        this.mean = mean;
        this.total = total;
	}
}
