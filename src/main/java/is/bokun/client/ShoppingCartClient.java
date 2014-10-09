package is.bokun.client;

import is.bokun.dtos.booking.*;

import com.google.inject.Inject;

import java.util.List;

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
     * @param config
     */
    @Inject
    public ShoppingCartClient(ClientConfiguration config) {
        super(config);
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
     * Get the customer's shopping cart. Customer carts are directly linked to the account of the customer logged in.
     * They are stored forever (or as long as the Customer exists).
     *
     * @param securityToken the token received by the customer on authentication
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the customer's shopping cart
     */
    public ShoppingCartDto getCustomerCart(String securityToken, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken, lang, currency);
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
     * Remove a car rental booking from a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param carRentalBookingId the ID of the car rental booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeCarRentalFromSessionCart(String sessionId, Long carRentalBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/remove-car-rental/" + carRentalBookingId, lang, currency);
        return getCart(uri);
    }

    public ShoppingCartDto removeRouteFromSessionCart(String sessionId, Long routeBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/remove-route/" + routeBookingId, lang, currency);
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
     * Remove an accommodation booking from a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param accommodationBookingId the ID of the accommodation booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeAccommodationFromCustomerCart(String securityToken, Long accommodationBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/remove-accommodation/" + accommodationBookingId, lang, currency);
        return getCart(uri);
    }
    
    /**
     * Remove a car rental booking from a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param carRentalBookingId the ID of the car rental booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeCarRentalFromCustomerCart(String securityToken, Long carRentalBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/remove-car-rental/" + carRentalBookingId, lang, currency);
        return getCart(uri);
    }

    /**
     * Remove an activity booking from a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param activityBookingId the ID of the activity booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeActivityFromCustomerCart(String securityToken, Long activityBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/remove-activity/" + activityBookingId, lang, currency);
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
     * Remove an accommodation room booking from a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param roomBookingId the ID of the room booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeRoomFromCustomerCart(String securityToken, Long roomBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/remove-room/" + roomBookingId, lang, currency);
        return getCart(uri);
    }
    
    /**
     * Remove a car booking from a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param carBookingId the ID of the room booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeCarFromSessionCart(String sessionId, Long carBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/remove-car/" + carBookingId, lang, currency);
        return getCart(uri);
    }
    
    /**
     * Remove a car booking from a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param carBookingId the ID of the room booking to be removed
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeCarFromCustomerCart(String securityToken, Long carBookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/remove-car/" + carBookingId, lang, currency);
        return getCart(uri);
    }

    /**
     * Merge a session shopping cart with a customer's cart.
     * Usually called after creating a customer account (and the customer had been adding to the session cart before creating
     * the account).
     * @param securityToken
     * @param sessionId
     * @param lang
     * @param currency
     * @return the merged shopping cart
     */
    public ShoppingCartDto mergeSession(String securityToken, String sessionId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/merge-session", lang, currency, new NVP("sessionId",sessionId));
        return getCart(uri);
    }

    private ShoppingCartDto getCart(String uri) {
        return getAndValidate(uri, ShoppingCartDto.class);
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

    public ShoppingCartDto addAccommodationToSessionCart(String sessionId, List<AccommodationBookingRequestDto> bookingRequests, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/accommodation", lang, currency);
        return postAndGetCart(uri, bookingRequests);
    }

    /**
     * Add an accommodation booking to a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @param trackingCode Affiliate tracking code.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addAccommodationToSessionCart(String sessionId, AccommodationBookingRequestDto bookingRequest, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/accommodation", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addAccommodationToSessionCart(String sessionId, List<AccommodationBookingRequestDto> bookingRequests, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/accommodation", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequests);
    }
    
    /**
     * Add a car rental booking to a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addCarRentalToSessionCart(String sessionId, CarRentalBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/car-rental", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addCarRentalToSessionCart(String sessionId, List<CarRentalBookingRequestDto> bookingRequests, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/car-rental", lang, currency);
        return postAndGetCart(uri, bookingRequests);
    }

    /**
     * Add a car rental booking to a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @param trackingCode Affiliate tracking code.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addCarRentalToSessionCart(String sessionId, CarRentalBookingRequestDto bookingRequest, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/car-rental", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addCarRentalToSessionCart(String sessionId, List<CarRentalBookingRequestDto> bookingRequests, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/car-rental", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequests);
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

    public ShoppingCartDto addActivityToSessionCart(String sessionId, List<ActivityBookingRequestDto> bookingRequests, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/activity", lang, currency);
        return postAndGetCart(uri, bookingRequests);
    }

    /**
     * Add an activity booking to a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @param trackingCode Affiliate tracking code.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addActivityToSessionCart(String sessionId, ActivityBookingRequestDto bookingRequest, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/activity", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addActivityToSessionCart(String sessionId, List<ActivityBookingRequestDto> bookingRequests, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/activity", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequests);
    }

    /**
     * Add an accommodation booking to a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addAccommodationToCustomerCart(String securityToken, AccommodationBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/accommodation", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addAccommodationToCustomerCart(String securityToken, List<AccommodationBookingRequestDto> bookingRequests, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/accommodation", lang, currency);
        return postAndGetCart(uri, bookingRequests);
    }

    /**
     * Add an accommodation booking to a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @param trackingCode Affiliate tracking code.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addAccommodationToCustomerCart(String securityToken, AccommodationBookingRequestDto bookingRequest, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/accommodation", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addAccommodationToCustomerCart(String securityToken, List<AccommodationBookingRequestDto> bookingRequests, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/accommodation", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequests);
    }
    
    /**
     * Add a car rental booking to a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addCarRentalToCustomerCart(String securityToken, CarRentalBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/car-rental", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addCarRentalToCustomerCart(String securityToken, List<CarRentalBookingRequestDto> bookingRequests, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/car-rental", lang, currency);
        return postAndGetCart(uri, bookingRequests);
    }

    /**
     * Add a car rental booking to a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @param trackingCode Affiliate tracking code.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addCarRentalToCustomerCart(String securityToken, CarRentalBookingRequestDto bookingRequest, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/car-rental", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addCarRentalToCustomerCart(String securityToken, List<CarRentalBookingRequestDto> bookingRequests, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/car-rental", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequests);
    }

    /**
     * Add an activity booking to a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addActivityToCustomerCart(String securityToken, ActivityBookingRequestDto bookingRequest, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/activity", lang, currency);
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addActivityToCustomerCart(String securityToken, List<ActivityBookingRequestDto> bookingRequests, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/activity", lang, currency);
        return postAndGetCart(uri, bookingRequests);
    }

    /**
     * Add an activity booking to a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @param trackingCode Affiliate tracking code.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addActivityToCustomerCart(String securityToken, ActivityBookingRequestDto bookingRequest, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/activity", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequest);
    }

    public ShoppingCartDto addActivityToCustomerCart(String securityToken, List<ActivityBookingRequestDto> bookingRequests, String lang, String currency, String trackingCode) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/activity", lang, currency, new NVP("trackingCode",trackingCode));
        return postAndGetCart(uri, bookingRequests);
    }

    /**
     * Add or update an extra booking in a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param bookingType the type of the parent booking (room booking / car booking / activity booking / etc.)
     * @param bookingId the ID of the parent booking
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addOrUpdateExtraBookingInGuestCart(String sessionId, BookingTypeWithExtraEnum bookingType, Long bookingId, ExtraBookingRequestDto bookingRequest, String lang, String currency) {
    	String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/add-or-update-extra/" + bookingType.name().toLowerCase() + "/" + bookingId, lang, currency);
    	return postAndGetCart(uri, bookingRequest);
    }
    
    /**
     * Add or update an extra booking in a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param bookingType the type of the parent booking (room booking / car booking / activity booking / etc.)
     * @param bookingId the ID of the parent booking
     * @param bookingRequest the request describing the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto addOrUpdateExtraBookingInCustomerCart(String securityToken, BookingTypeWithExtraEnum bookingType, Long bookingId, ExtraBookingRequestDto bookingRequest, String lang, String currency) {
    	String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/add-or-update-extra/" + bookingType.name().toLowerCase() + "/" + bookingId, lang, currency);
    	return postAndGetCart(uri, bookingRequest);
    }

    /**
     * Remove an extra booking from a guest's session cart.
     *
     * @param sessionId the guest's session ID
     * @param bookingType the type of the parent booking (room booking / car booking / activity booking / etc.)
     * @param bookingId the ID of the parent booking
     * @param extraId the ID of the bookable extra (NOTE: NOT the extra booking)
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeExtraBookingFromGuestCart(String sessionId, BookingTypeWithExtraEnum bookingType, Long bookingId, Long extraId, String lang, String currency) {
    	String uri = appendLangAndCurrency(BASE + "/session/" + sessionId + "/remove-extra/" + bookingType.name().toLowerCase() + "/" + bookingId + "/" + extraId, lang, currency);
    	return getCart(uri);
    }
    
    /**
     * Remove an extra booking from a customer's shopping cart.
     *
     * @param securityToken the token received by the customer on authentication
     * @param bookingType the type of the parent booking (room booking / car booking / activity booking / etc.)
     * @param bookingId the ID of the parent booking
     * @param extraId the ID of the bookable extra (NOTE: NOT the extra booking)
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto removeExtraBookingFromCustomerCart(String securityToken, BookingTypeWithExtraEnum bookingType, Long bookingId, Long extraId, String lang, String currency) {
    	String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/remove-extra/" + bookingType.name().toLowerCase() + "/" + bookingId + "/" + extraId, lang, currency);
    	return getCart(uri);
    }
    
    private ShoppingCartDto postAndGetCart(String uri, Object body) {
        return postAndValidate(uri, body, ShoppingCartDto.class);
    }
}
