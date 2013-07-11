package is.bokun.client;

import is.bokun.dtos.carrental.*;
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
     * Get a list of all car rentals that this booking channel has access to.
     * 
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return a list of car rentals
     */
    public CarRentalSearchResultsDto listCarRentals(String lang, String currency) {
    	String uri = appendLangAndCurrency(BASE + "/list", lang, currency);
    	return getAndValidate(uri, CarRentalSearchResultsDto.class);
    }
    
    /**
     * Look up Car Rental by ID.
     *
     * @param carRentalId The ID of the Activity.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the Car Rental with the ID supplied
     */
    public CarRentalDto findById(Long carRentalId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/" + carRentalId, lang, currency);
        return getAndValidate(uri, CarRentalDto.class);
    }

    /**
     * Look up Car Rental by slug. Note that slugs are not created automatically, they must
     * be defined per product in the Bokun extranet. Also note that the slugs are language
     * dependent.
     *
     * @param slug The slug to look up by.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the Car Rental matching the slug and language provided
     */
    public CarRentalDto findBySlug(String slug, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/slug/" + slug, lang, currency);
        return getAndValidate(uri, CarRentalDto.class);
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
