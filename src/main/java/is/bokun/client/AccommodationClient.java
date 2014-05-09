package is.bokun.client;

import is.bokun.dtos.accommodation.*;
import is.bokun.dtos.search.SearchResultsDto;
import is.bokun.queries.AccommodationQuery;
import is.bokun.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

import com.google.inject.Inject;

/**
 * Client for the Accommodation resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class AccommodationClient extends AbstractClient {

    private static final String BASE = "/accommodation.json";

    /**
     * @see AbstractClient#()
     *
     * @param config
     */
    @Inject
    public AccommodationClient(ClientConfiguration config) {
        super(config);
    }

    /**
     * Look up Acommodation by ID.
     *
     * @param accommodationId The ID of the Accommodation.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the Accommodation with the ID supplied
     */
    public AccommodationDto findById(Long accommodationId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/" + accommodationId, lang, currency);
        return getAndValidate(uri, AccommodationDto.class);
    }

    /**
     * Look up Accommodation by slug. Note that slugs are not created automatically, they must
     * be defined per product in the Bokun extranet. Also note that the slugs are language
     * dependent.
     *
     * @param slug The slug to look up by.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the Accommodation matching the slug and language provided
     */
    public AccommodationDto findBySlug(String slug, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/slug/" + slug, lang, currency);
        return getAndValidate(uri, AccommodationDto.class);
    }

    /**
     * Perform a search for Accommodation. The AccommodationQuery object has many ways of
     * constraining and ordering the results.
     *
     * @param query the query to be used
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return search results matching the query
     */
    public SearchResultsDto search(AccommodationQuery query, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/search", lang, currency);
        return postAndValidate(uri, query, SearchResultsDto.class);
    }

    /**
     * Get availability report for a single Acommodation.
     *
     * @param accommodationId The ID of the accommodation.
     * @param query The query to be used. Not all of the query fields are used here, only the start/end dates and the room requirements.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return an availability report for the Accommodation
     */
    public AccommodationAvailabilityReportDto getAvailabilityReport(Long accommodationId, AccommodationQuery query, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/" + accommodationId + "/check-availability", lang, currency);
        return postAndValidate(uri, query, AccommodationAvailabilityReportDto.class);
    }
    
    /**
     * Get availabilities over a date range for an set of Accommodations.
     * Note that both the start and end dates MUST be supplied.
     *
     * @param accommodationIds the IDs of the Accommodations for which to retrieve availabilities
     * @param start the start date of the range
     * @param end the end date of the range
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return
     */
    public AccommodationAvailabilitiesDto getAvailabilitiesOnRange(List<Long> accommodationIds, Date start, Date end, String lang, String currency) {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String uri = appendLangAndCurrency(BASE + "/availabilities", lang, currency,
                new NVP("start", formatter.format(start)), new NVP("end", formatter.format(end)),
                new NVP("ids", StringUtils.idListToCommaSeparated(accommodationIds)));
        
        return getAndValidate(uri, AccommodationAvailabilitiesDto.class);
    }
}
