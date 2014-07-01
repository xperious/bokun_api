package is.bokun.dtos.search;

/**
 * Created by kristinfjola on 28.5.2014.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TermsStatsFacetEntryDto {

    public String term;
    public long count;
    public double total;
    public double mean;
    public double min, max;

    public TermsStatsFacetEntryDto() {}

    public TermsStatsFacetEntryDto(String term) {
        this.term = term;
    }

    public TermsStatsFacetEntryDto(String term, long count, double total, double mean) {
        this.term = term;
        this.count = count;
        this.total = total;
        this.mean = mean;
    }

}
