package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.activity.ActivityAvailabilityDto;
import is.bokun.dtos.activity.ActivityDto;
import is.bokun.dtos.search.SearchResultsDto;
import is.bokun.queries.ActivityQuery;
import org.codehaus.jackson.type.TypeReference;

import java.util.Date;
import java.util.List;

/**
 * Client for the Activity resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class ActivityClient extends AbstractClient {

    private static final String BASE = "/activity.json";

    public ActivityClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    public ActivityDto findById(Long activityId, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/" + activityId, lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), ActivityDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public ActivityDto findBySlug(String slug, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/slug/" + slug, lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), ActivityDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public SearchResultsDto search(ActivityQuery query, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/search", lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.preparePost(host + uri);
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

    public List<ActivityAvailabilityDto> getUpcomingAvailabilities(Long activityId, int maxResults, boolean includeSoldOut, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/id/" + activityId + "/upcoming-availabilities/" + maxResults, lang, currency, new NVP("includeSoldOut", ""+includeSoldOut));
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<ActivityAvailabilityDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public List<ActivityAvailabilityDto> getAvailabilitiesOnRange(Long activityId, Date start, Date end, boolean includeSoldOut, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/id/" + activityId + "/availabilities", lang, currency,
                    new NVP("start", Long.toString(start.getTime())), new NVP("end", Long.toString(end.getTime())),
                    new NVP("includeSoldOut", ""+includeSoldOut));

            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<ActivityAvailabilityDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
