package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.dtos.search.ProductBookingSearchResultItem;
import is.bokun.queries.BookingQuery;
import is.bokun.queries.ProductBookingQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 18.8.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductBookingSearchResultsDto {

    public Long tookInMillis;
    public Long totalHits;

    public ProductBookingQuery query;

    public List<ProductBookingSearchResultItem> results = new ArrayList<>();

    public Long getTookInMillis() {
        return tookInMillis;
    }

    public void setTookInMillis(Long tookInMillis) {
        this.tookInMillis = tookInMillis;
    }

    public Long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Long totalHits) {
        this.totalHits = totalHits;
    }

    public ProductBookingQuery getQuery() {
        return query;
    }

    public void setQuery(ProductBookingQuery query) {
        this.query = query;
    }

    public List<ProductBookingSearchResultItem> getResults() {
        return results;
    }

    public void setResults(List<ProductBookingSearchResultItem> results) {
        this.results = results;
    }
}
