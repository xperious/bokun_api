package is.bokun.client;

import is.bokun.dtos.activity.*;
import is.bokun.dtos.booking.ActivityBookingDto;
import is.bokun.dtos.booking.ActivityBookingRequestDto;
import is.bokun.dtos.search.SearchResultsDto;
import is.bokun.queries.ActivityQuery;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import com.google.inject.Inject;
import com.ning.http.client.Response;

/**
 * Client for the Activity resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class ActivityClient extends AbstractClient {

    private static final String BASE = "/activity.json";

    /**
     * @see AbstractClient#()
     *
     * @param config
     */
    @Inject
    public ActivityClient(ClientConfiguration config) {
        super(config);
    }

    /**
     * Look up Activity by ID.
     *
     * @param activityId The ID of the Activity.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the Activity with the ID supplied
     */
    public ActivityDto findById(Long activityId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/" + activityId, lang, currency);
        return getAndValidate(uri, ActivityDto.class);
    }

    /**
     * Look up Activity by slug. Note that slugs are not created automatically, they must
     * be defined per product in the Bokun extranet. Also note that the slugs are language
     * dependent.
     *
     * @param slug The slug to look up by.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the Activity matching the slug and language provided
     */
    public ActivityDto findBySlug(String slug, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/slug/" + slug, lang, currency);
        return getAndValidate(uri, ActivityDto.class);
    }
    
    /**
     * Get the pickup and dropoff places for a particular Activity.
     *
     * @param activityId The ID of the Activity.
     * @param lang The language the content should be in.
     * @return the pickup and dropoff places for the Activity with the ID supplied
     */
    public ActivityPlacesDto getPickupAndDropoffPlaces(Long activityId, String lang) {
    	String uri = appendLangAndCurrency(BASE + "/" + activityId + "/pickup-places", lang, null);
    	return getAndValidate(uri, ActivityPlacesDto.class);
    }

    /**
     * Perform a search for Activity. The ActivityQuery object has many ways of
     * constraining and ordering the results.
     *
     * @param query the query to be used
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return search results matching the query
     */
    public SearchResultsDto search(ActivityQuery query, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/search", lang, currency);
        return postAndValidate(uri, query, SearchResultsDto.class);
    }

    /**
     * Get the next upcoming availabilities (from today) for an Activity.
     *
     * @param activityId the ID of the Activity
     * @param maxResults the maximum number of results to be returned
     * @param includeSoldOut whether to include availabilities that are sold out
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return a list of the upcoming availabilities for the Accommodation
     */
    public List<ActivityAvailabilityDto> getUpcomingAvailabilities(Long activityId, int maxResults, boolean includeSoldOut, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/" + activityId + "/upcoming-availabilities/" + maxResults, lang, currency, new NVP("includeSoldOut", ""+includeSoldOut));
            Response r = prepareGet(uri).execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<ActivityAvailabilityDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Check the price for a number of activity booking requests.
     * @param bookingRequests
     * @param lang
     * @param currency
     * @return
     */
    public List<ActivityBookingDto> checkPrices(List<ActivityBookingRequestDto> bookingRequests, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/check-prices", lang, currency);
            Response r = prepareGet(uri).execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<ActivityBookingDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Get availabilities over a date range for an Activity.
     * Note that both the start and end dates MUST be supplied.
     *
     * @param activityId the ID of the Activity
     * @param start the start date of the range
     * @param end the end date of the range
     * @param includeSoldOut whether to include availabilities that are sold out
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return
     */
    public List<ActivityAvailabilityDto> getAvailabilitiesOnRange(Long activityId, Date start, Date end, boolean includeSoldOut, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/" + activityId + "/availabilities", lang, currency,
                    new NVP("start", Long.toString(start.getTime())), new NVP("end", Long.toString(end.getTime())),
                    new NVP("includeSoldOut", ""+includeSoldOut));

            Response r = prepareGet(uri).execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<ActivityAvailabilityDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
    
    /**
     * Asynchronous version of availabilities retrieval over a date range
     * for an Activity. Note that both the start and end dates MUST be 
     * supplied.
     *
     * @param activityId the ID of the Activity
     * @param start the start date of the range
     * @param end the end date of the range
     * @param includeSoldOut whether to include availabilities that are sold out
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return
     */
    public AsyncResponse<List<ActivityAvailabilityDto>> getAvailabilitiesOnRangeAsync(Long activityId, Date start, Date end, boolean includeSoldOut, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/" + activityId + "/availabilities", lang, currency,
                    new NVP("start", Long.toString(start.getTime())), new NVP("end", Long.toString(end.getTime())),
                    new NVP("includeSoldOut", ""+includeSoldOut));
            return new AsyncResponse<List<ActivityAvailabilityDto>>(prepareGet(uri).execute(), this, json.getTypeFactory().constructCollectionType(List.class, ActivityAvailabilityDto.class));
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
    
}
