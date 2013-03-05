package is.bokun.client;

import com.google.inject.Inject;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.accommodation.AccommodationAvailabilityReportDto;
import is.bokun.dtos.accommodation.AccommodationDto;
import is.bokun.dtos.search.SearchResultsDto;
import is.bokun.queries.AccommodationQuery;

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
        try {
            String uri = appendLangAndCurrency(BASE + "/" + accommodationId, lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = config.getAsyncClient().prepareGet(config.getHost() + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), AccommodationDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
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
        try {
            String uri = appendLangAndCurrency(BASE + "/slug/" + slug, lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = config.getAsyncClient().prepareGet(config.getHost() + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), AccommodationDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
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
        try {
            String uri = appendLangAndCurrency(BASE + "/search", lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = config.getAsyncClient().preparePost(config.getHost() + uri);
            addSecurityHeaders(b, "POST", uri);
            b.setBodyEncoding("UTF-8");
            b.setBody(json.writeValueAsString(query));

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), SearchResultsDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
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
        try {
            String uri = appendLangAndCurrency(BASE + "/" + accommodationId + "/check-availability", lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = config.getAsyncClient().preparePost(config.getHost() + uri);
            addSecurityHeaders(b, "POST", uri);
            b.setBodyEncoding("UTF-8");
            b.setBody(json.writeValueAsString(query));

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), AccommodationAvailabilityReportDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
