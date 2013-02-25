package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.booking.AccommodationBookingRequestDto;
import is.bokun.dtos.booking.ActivityBookingRequestDto;
import is.bokun.dtos.booking.ShoppingCartDto;
import is.bokun.dtos.search.SearchResultsDto;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class ShoppingCartClient extends AbstractClient {

    private static final String BASE = "/shopping-cart.json";

    public ShoppingCartClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    public ShoppingCartDto getSessionCart(String sessionId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId, lang, currency);
        return getCart(uri);
    }

    public ShoppingCartDto getUserCart(String securityToken, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken, lang, currency);
        return getCart(uri);
    }

    public ShoppingCartDto removeAccommodationFromSessionCart(String sessionId, Long accommodationBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/remove-accommodation/" + accommodationBookingId, lang, currency);
        return getCart(uri);
    }

    public ShoppingCartDto removeActivityFromSessionCart(String sessionId, Long activityBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/remove-activity/" + activityBookingId, lang, currency);
        return getCart(uri);
    }

    public ShoppingCartDto removeAccommodationFromUserCart(String securityToken, Long accommodationBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/remove-accommodation/" + accommodationBookingId, lang, currency);
        return getCart(uri);
    }

    public ShoppingCartDto removeActivityFromUserCart(String securityToken, Long activityBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/remove-activity/" + activityBookingId, lang, currency);
        return getCart(uri);
    }

    public ShoppingCartDto removeRoomFromSessionCart(String sessionId, Long roomBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/remove-room/" + roomBookingId, lang, currency);
        return getCart(uri);
    }

    public ShoppingCartDto removeRoomFromUserCart(String securityToken, Long roomBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/remove-room/" + roomBookingId, lang, currency);
        return getCart(uri);
    }

    /**
     * Merge a session shopping cart with a user's cart.
     * Usually called after creating a user account (and the user had been adding to the session cart before creating
     * the account).
     * @param securityToken
     * @param sessionId
     * @param lang
     * @param currency
     * @return the merged shopping cart
     */
    public ShoppingCartDto mergeSession(String securityToken, String sessionId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/merge-session", lang, currency, new NVP("sessionId",sessionId));
        return getCart(uri);
    }

    private ShoppingCartDto getCart(String uri) {
        try {
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), ShoppingCartDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public ShoppingCartDto addAccommodationToSessionCart(String sessionId, AccommodationBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/accommodation", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addActivityToSessionCart(String sessionId, ActivityBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/activity", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addAccommodationToUserCart(String securityToken, AccommodationBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/accommodation", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addActivityToUserCart(String sessionId, ActivityBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + sessionId + "/activity", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    private ShoppingCartDto postAndGetCart(String uri, Object body) {
        try {
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.preparePost(host + uri);
            addSecurityHeaders(b, "POST", uri);
            b.setBodyEncoding("UTF-8");
            b.setBody(json.writeValueAsString(body));

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), ShoppingCartDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
