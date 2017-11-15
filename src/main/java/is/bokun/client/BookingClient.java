package is.bokun.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.inject.Inject;
import com.ning.http.client.Response;
import is.bokun.dtos.ApiResponse;
import is.bokun.dtos.ErrorDto;
import is.bokun.dtos.booking.*;
import is.bokun.dtos.payments.ChargeDto;
import is.bokun.dtos.payments.ChargeRequestDto;
import is.bokun.dtos.payments.ChargeResponseDto;
import is.bokun.queries.BookingQuery;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Client for the Booking resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
@SuppressWarnings("UnusedDeclaration")
public class BookingClient extends AbstractClient {

    private static final String BASE = "/booking.json";

    /**
     * @see AbstractClient#AbstractClient(ClientConfiguration)
     *
     * @param config for this instance.
     */
    @Inject
    public BookingClient(ClientConfiguration config) {
        super(config);
    }

    /**
     * Get a list of questions for the guest. This provides a list of all questions the guest
     * must answer in order to reserve the booking before payment.
     *
     * @param sessionId the guest's session ID
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return questions derived from the guest's session cart
     */
    public BookingQuestionsDto getGuestBookingQuestions(String sessionId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/guest/" + sessionId + "/questions", lang, currency);
        return getQuestions(uri);
    }

    /**
     * Get a list of questions for the customer. This provides a list of all questions the customer
     * must answer in order to reserve the booking before payment.
     *
     * @param securityToken the token received by the customer on authentication
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return questions derived from the customer's shopping cart
     */
    public BookingQuestionsDto getCustomerBookingQuestions(String securityToken, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/customer/" + securityToken + "/questions", lang, currency);
        return getQuestions(uri);
    }

    private BookingQuestionsDto getQuestions(String uri) {
        return getAndValidate(uri, BookingQuestionsDto.class);
    }

    /**
     * Reserve a booking for a guest, reserving availability for all products. Normally called before accepting payment.
     * Creates a Booking with the status RESERVED from the items
     * in the guest's session shopping cart, applying the answers supplied.
     *
     * @param sessionId the guest's session ID
     * @param reservationInfo all the info for reserving the booking, such as payment info and answers to the questions required for booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @param paymentProviderParams optional map of parameters directed at the payment provider (successURL, cancelURL, etc.).
     *                              Refer to the relevant payment provider documentation for more info.
     * @return details for the reserved booking
     */
    public BookingDetailsDto reserveBookingForGuest(String sessionId, BookingReservationRequestDto reservationInfo, String lang, String currency, Map<String,String> paymentProviderParams) {
        String uri = appendQueryParams(BASE + "/guest/" + sessionId + "/reserve", gatherParams(lang, currency, paymentProviderParams));
        return postBooking(uri, reservationInfo);
    }

    /**
     * Reserve a booking for a guest, reserving availability for all products.
     * Then try charging a card to pay for the booking.
     * Finally confirm the booking.
     *
     * If it fails, the booking will be moved back to the shopping cart.
     *
     * @param sessionId the guest's session ID
     * @param requestDto the reservation and charge requests
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the charge results, along with the booking details
     */
    public ChargeResponseDto reserveAndChargeAndConfirmBookingForGuest(String sessionId, BookingReservationRequestDto requestDto, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/guest/" + sessionId + "/reserve-pay-confirm", lang, currency);
        return postAndValidate(uri, requestDto, ChargeResponseDto.class);
    }

    /**
     * Reserve a booking for a customer, reserving availability for all products. Normally called before accepting payment.
     * Creates a Booking with the status RESERVED from the items
     * in the customer's shopping cart, applying the answers supplied.
     *
     * @param securityToken the token received by the customer on authentication
     * @param reservationInfo all the info for reserving the booking, such as payment info and answers to the questions required for booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @param paymentProviderParams optional map of parameters directed at the payment provider (successURL, cancelURL, etc.).
     *                              Refer to the relevant payment provider documentation for more info.
     * @return details for the reserved booking
     */
    public BookingDetailsDto reserveBookingForCustomer(String securityToken, BookingReservationRequestDto reservationInfo, String lang, String currency, Map<String,String> paymentProviderParams) {
        String uri = appendQueryParams(BASE + "/customer/" + securityToken + "/reserve", gatherParams(lang, currency, paymentProviderParams));
        return postBooking(uri, reservationInfo);
    }

    private NVP[] gatherParams(String lang, String currency, Map<String,String> paymentProviderParams) {
        List<NVP> params = new ArrayList<>();
        params.add(new NVP("lang", lang));
        params.add(new NVP("currency", currency));
        if ( paymentProviderParams != null ) {
            for (Map.Entry<String,String> entry : paymentProviderParams.entrySet()) {
                params.add(new NVP(entry.getKey(), entry.getValue()));
            }
        }
        return params.toArray(new NVP[params.size()]);
    }

    private BookingDetailsDto postBooking(String uri, Object body) {
        return postAndValidate(uri, body, BookingDetailsDto.class);
    }

    /**
     * Charge a card to pay for a booking. The organization must have a
     * valid payment gateway configured, or else this will return an error.
     *
     * @param bookingId The ID of the booking to pay for.
     * @param chargeRequestDto Information about the card to be charged for the booking amount.
     * @return Information about the charge that was authorized.
     */
    public ChargeDto chargeCardForBooking(Long bookingId, ChargeRequestDto chargeRequestDto) {
        String uri = BASE + "/" + bookingId + "/charge-card";
        return postAndValidate(uri, chargeRequestDto, ChargeDto.class);
    }

    /**
     * Confirm a RESERVED booking. Normally called after processing payment.
     *
     * @param bookingId the ID of the Booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return Booking details for the confirmed booking.
     */
    public BookingDetailsDto confirmBooking(Long bookingId, String lang, String currency) {
        return confirmBooking(bookingId, new CustomerPaymentDto(), lang, currency, false);
    }

    /**
     * Confirm a RESERVED booking. Normally called after processing payment.
     *
     * @param bookingId the ID of the Booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return Booking details for the confirmed booking.
     */
    public BookingDetailsDto confirmBooking(Long bookingId, String lang, String currency, boolean sendCustomerConfirmation) {
    	return confirmBooking(bookingId, new CustomerPaymentDto(), lang, currency, sendCustomerConfirmation);
    }
    
    /**
     * Confirm a RESERVED booking. Normally called after processing payment.
     *
     * @param bookingId the ID of the Booking
     * @param payment a payment info with a list of settlements, each describing how a payment was made for a product booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return Booking details for the confirmed booking.
     */
    public BookingDetailsDto confirmBooking(Long bookingId, CustomerPaymentDto payment, String lang, String currency, boolean sendCustomerConfirmation) {
    	BookingConfirmationDto confirmation = new BookingConfirmationDto();
    	confirmation.payment = payment;
    	return confirmBooking(bookingId, confirmation, lang, currency, sendCustomerConfirmation);
    }
    
    /**
     * Confirm a RESERVED booking. Normally called after processing payment.
     *
     * @param bookingId the ID of the Booking
     * @param confirmation the confirmation object, with data relating to the confirmation
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return Booking details for the confirmed booking.
     */
    public BookingDetailsDto confirmBooking(Long bookingId, BookingConfirmationDto confirmation, String lang, String currency, boolean sendCustomerConfirmation) {
        String uri = appendLangAndCurrency(BASE + "/" + bookingId + "/confirm", lang, currency, new NVP("sendCustomerConfirmation", sendCustomerConfirmation));
        return postBooking(uri, confirmation);
    }

    /**
     * Abort a RESERVED booking. Normally called if the customer aborts the payment, or the payment session times out.
     *
     * @param bookingId the ID of the booking
     * @param timeout specifies whether the booking was aborted due to a timeout, should be "false" if the customer manually aborted
     * @return a simple OK response if things go well
     */
    public ApiResponse abortReservedBooking(Long bookingId, boolean timeout) {
        String uri = BASE + "/" + bookingId + "/abort-reserved?timeout=" + timeout;
        return getAndValidate(uri, ApiResponse.class);
    }
    
    /**
     * Move a RESERVED booking back to a guest's shopping cart. 
     * All reserved availability is rolled back. 
     * 
     * @param sessionId the guest's session ID
     * @param bookingId the ID of the booking to move to the cart
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto moveReservedBookingBackToGuestCart(String sessionId, Long bookingId, String lang, String currency) {
    	String uri = appendLangAndCurrency(BASE + "/" + bookingId + "/move-back-to-cart/session/" + sessionId, lang, currency);
    	return getAndValidate(uri, ShoppingCartDto.class);       
    }
    
    /**
     * Move a RESERVED booking back to a customer's shopping cart. 
     * All reserved availability is rolled back. 
     * 
     * @param securityToken the token received by the customer on authentication
     * @param bookingId the ID of the booking to move to the cart
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the updated shopping cart
     */
    public ShoppingCartDto moveReservedBookingBackToCustomerCart(String securityToken, Long bookingId, String lang, String currency) {
    	String uri = appendLangAndCurrency(BASE + "/" + bookingId + "/move-back-to-cart/customer/" + securityToken, lang, currency);
    	return getAndValidate(uri, ShoppingCartDto.class);
    }

    /**
     * Get the Payment provider details for a particular booking. This will contain all the name/value pairs that the
     * payment provider expects, with secure signatures. The caller can then call the payment gateway using these
     * parameters directly.
     *
     * @param bookingId the ID of the booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return details about the payment provider, along with all the required parameters for the payment gateway
     */
    public PaymentProviderDetailsDto getPaymentProviderDetails(Long bookingId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/" + bookingId + "/payment-provider", lang, currency);
        return getAndValidate(uri, PaymentProviderDetailsDto.class);
    }

    /**
     * Report an error that occurred in payment. This will abort the RESERVED booking, storing the details
     * about the error provided.
     *
     * @param bookingId the ID of the booking
     * @param errorDetails a description of the error that occurred
     * @return a simple OK response if things go well
     */
    public ApiResponse reportPaymentError(Long bookingId, ErrorDto errorDetails) {
        String uri = BASE + "/" + bookingId + "/payment-error";
        return postAndValidate(uri, errorDetails, ApiResponse.class);
    }

    /**
     * Get a list of reserved bookings for the guest (if any exist).
     *
     * @param sessionId the guest's session ID
     * @param currency The currency used for prices.
     * @return a list of any reserved bookings for the guest
     */
    public List<BookingDetailsDto> getReservedBookingsForGuest(String sessionId, String currency) {
        try {
            String uri = appendQueryParams(BASE + "/guest/" + sessionId + "/reserved", new NVP("currency", currency));
            Response r = prepareGet(uri).execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<BookingDetailsDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Get a list of reserved bookings for the customer (if any exist).
     *
     * @param securityToken the token received by the customer on authentication
     * @param currency The currency used for prices.
     * @return a list of any reserved bookings for the customer
     */
    public List<BookingDetailsDto> getReservedBookingsForCustomer(String securityToken, String currency) {
        try {
            String uri = appendQueryParams(BASE + "/customer/" + securityToken + "/reserved", new NVP("currency", currency));
            Response r = prepareGet(uri).execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<BookingDetailsDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public ProductBookingSearchResultsDto productBookingSearch(BookingQuery q) {
        String uri = appendQueryParams(BASE + "/product-booking-search");
        return postAndValidate(uri, q, ProductBookingSearchResultsDto.class);
    }

    public ActivityBookingDetailsDto getActivityBooking(String productConfirmationCode) {
        String uri = appendQueryParams(BASE + "/activity-booking/" + productConfirmationCode);
        return getAndValidate(uri, ActivityBookingDetailsDto.class);
    }

    public RouteBookingDetailsDto getRouteBooking(String productConfirmationCode) {
        String uri = appendQueryParams(BASE + "/route-booking/" + productConfirmationCode);
        return getAndValidate(uri, RouteBookingDetailsDto.class);
    }

    public AccommodationBookingDetailsDto getAccommodationBooking(String productConfirmationCode) {
        String uri = appendQueryParams(BASE + "/accommodation-booking/" + productConfirmationCode);
        return getAndValidate(uri, AccommodationBookingDetailsDto.class);
    }

    public CarRentalBookingDetailsDto getCarRentalBooking(String productConfirmationCode) {
        String uri = appendQueryParams(BASE + "/car-rental-booking/" + productConfirmationCode);
        return getAndValidate(uri, CarRentalBookingDetailsDto.class);
    }

    public ActivityBookingDetailsDto setActivityBookingCustomerStatus(String productConfirmationCode, CustomerStatusEnum customerStatus) {
        String uri = appendQueryParams(BASE + "/activity-booking/" + productConfirmationCode + "/customer-status/" + customerStatus.name());
        return getAndValidate(uri, ActivityBookingDetailsDto.class);
    }

    public AccommodationBookingDetailsDto setAccommodationBookingCustomerStatus(String productConfirmationCode, CustomerStatusEnum customerStatus) {
        String uri = appendQueryParams(BASE + "/accommodation-booking/" + productConfirmationCode + "/customer-status/" + customerStatus.name());
        return getAndValidate(uri, AccommodationBookingDetailsDto.class);
    }

    public CarRentalBookingDetailsDto setCarRentalBookingCustomerStatus(String productConfirmationCode, CustomerStatusEnum customerStatus) {
        String uri = appendQueryParams(BASE + "/car-rental-booking/" + productConfirmationCode + "/customer-status/" + customerStatus.name());
        return getAndValidate(uri, CarRentalBookingDetailsDto.class);
    }

    public RouteBookingDetailsDto setRouteBookingCustomerStatus(String productConfirmationCode, CustomerStatusEnum customerStatus) {
        String uri = appendQueryParams(BASE + "/route-booking/" + productConfirmationCode + "/customer-status/" + customerStatus.name());
        return getAndValidate(uri, RouteBookingDetailsDto.class);
    }

    /**
     * Get PDF ticket for an accommodation booking.
     * @param id of the accommodation booking
     * @return InputStream with PDF contents
     */
    public InputStream getAccommodationTicket(Long id) {
        String uri = appendQueryParams(BASE + "/accommodation-booking/" + id + "/ticket");
        return getPDFBytes(uri);
    }

    /**
     * Get PDF ticket for an activity booking.
     * @param id of the activity booking
     * @return InputStream with PDF contents
     */
    public InputStream getActivityTicket(Long id) {
        String uri = appendQueryParams(BASE + "/activity-booking/" + id + "/ticket");
        return getPDFBytes(uri);
    }

    /**
     * Get PDF ticket for an car rental booking.
     * @param id of the car rental booking
     * @return InputStream with PDF contents
     */
    public InputStream getCarRentalTicket(Long id) {
        String uri = appendQueryParams(BASE + "/car-rental-booking/" + id + "/ticket");
        return getPDFBytes(uri);
    }

    /**
     * Get PDF ticket for an route booking.
     * @param id of the route booking
     * @return InputStream with PDF contents
     */
    public InputStream getRouteTicket(Long id) {
        String uri = appendQueryParams(BASE + "/route-booking/" + id + "/ticket");
        return getPDFBytes(uri);
    }

    /**
     * Get PDF summary of a booking.
     * @param id of the accommodation booking
     * @return InputStream with PDF contents
     */
    public InputStream getBookingSummary(Long id) {
        String uri = appendQueryParams(BASE + id + "/summary");
        return getPDFBytes(uri);
    }

    private InputStream getPDFBytes(String uri) {
        try {
            Response r = prepareGet(uri).execute().get();
            return r.getResponseBodyAsStream();
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
