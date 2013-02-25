package is.bokun.client;

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

    public AccommodationClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    public AccommodationDto findById(Long accommodationId, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/" + accommodationId, lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), AccommodationDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public AccommodationDto findBySlug(String slug, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/slug/" + slug, lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), AccommodationDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public SearchResultsDto search(AccommodationQuery query, String lang, String currency) {
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

    public AccommodationAvailabilityReportDto getAvailabilityReport(Long accommodationId, AccommodationQuery query, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/" + accommodationId + "/check-availability", lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.preparePost(host + uri);
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
