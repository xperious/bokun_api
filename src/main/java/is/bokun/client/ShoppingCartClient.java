package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.booking.AccommodationBookingRequestDto;
import is.bokun.dtos.booking.ActivityBookingRequestDto;
import is.bokun.dtos.booking.ShoppingCartDto;
import is.bokun.dtos.search.SearchResultsDto;

/**
 * Client for the ShoppingCart resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class ShoppingCartClient extends AbstractClient {

    private static final String BASE = "/shopping-cart.json";

    /**
     * @see AbstractClient#()
     *
     * @param host
     * @param accessKey
     * @param secretKey
     * @param asyncClient
     */
    public ShoppingCartClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    /**
     * Get the guest's session cart. Session carts allow guests to add products without logging in. They are cleared
     * on a defined interval, and therefore don't last forever.
     *
     * @param sessionId the guest's session ID
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the guest's session cart
     */
    public ShoppingCartDto getSessionCart(String sessionId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId, lang, currency);
        return getCart(uri);
    }

    /**
     * Get the user's shopping cart. User carts are directly linked to the account of the user logged in.
     * They are stored forever (or as long as the UserAccount exists).
     *
     * @param securityToken the token received by the user on authentication
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the user's shopping cart
     */
    public ShoppingCartDto getUserCart(String securityToken, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken, lang, currency);
        return getCart(uri);
    }

    /**
     * Remove an accommodation booking from a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param accommodationBookingId the ID of the accommodation booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeAccommodationFromSessionCart(String sessionId, Long accommodationBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/remove-accommodation/" + accommodationBookingId, lang, currency);
        return getCart(uri);
    }

    /**
     * Remove an activity booking from a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param activityBookingId the ID of the activity booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeActivityFromSessionCart(String sessionId, Long activityBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/remove-activity/" + activityBookingId, lang, currency);
        return getCart(uri);
    }

    /**
     * Remove an accommodation booking from a user's shopping cart.
     *
     * @param securityToken the token received by the user on authentication
     * @param accommodationBookingId the ID of the accommodation booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeAccommodationFromUserCart(String securityToken, Long accommodationBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/remove-accommodation/" + accommodationBookingId, lang, currency);
        return getCart(uri);
    }

    /**
     * Remove an activity booking from a user's shopping cart.
     *
     * @param securityToken the token received by the user on authentication
     * @param activityBookingId the ID of the activity booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeActivityFromUserCart(String securityToken, Long activityBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/remove-activity/" + activityBookingId, lang, currency);
        return getCart(uri);
    }

    /**
     * Remove an accommodation room booking from a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param roomBookingId the ID of the room booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeRoomFromSessionCart(String sessionId, Long roomBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/remove-room/" + roomBookingId, lang, currency);
        return getCart(uri);
    }

    /**
     * Remove an accommodation room booking from a user's shopping cart.
     *
     * @param securityToken the token received by the user on authentication
     * @param roomBookingId the ID of the room booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
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

    /**
     * Add an accommodation booking to a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addAccommodationToSessionCart(String sessionId, AccommodationBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/accommodation", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    /**
     * Add an activity booking to a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addActivityToSessionCart(String sessionId, ActivityBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/activity", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    /**
     * Add an accommodation booking from a user's shopping cart.
     *
     * @param securityToken the token received by the user on authentication
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addAccommodationToUserCart(String securityToken, AccommodationBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/accommodation", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    /**
     * Add an activity booking from a user's shopping cart.
     *
     * @param securityToken the token received by the user on authentication
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addActivityToUserCart(String securityToken, ActivityBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/activity", lang, currency);
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
