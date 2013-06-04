package is.bokun.client;

import is.bokun.dtos.carrental.CarSearchResultsDto;
import is.bokun.queries.CarQuery;

import com.google.inject.Inject;

/**
 * Client for the CarRental resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class CarRentalClient extends AbstractClient {

    private static final String BASE = "/car-rental.json";

    /**
     * @see AbstractClient#()
     *
     * @param config
     */
    @Inject
    public CarRentalClient(ClientConfiguration config) {
        super(config);
    }
    
    /**
     * Perform a search for rental cars. The CarQuery object has many ways of
     * constraining and ordering the results.
     *
     * @param query the query to be used
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return search results matching the query
     */
    public CarSearchResultsDto search(CarQuery query, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/search-cars", lang, currency);
        return postAndValidate(uri, query, CarSearchResultsDto.class);
    }

}
