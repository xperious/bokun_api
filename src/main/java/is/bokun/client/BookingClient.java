package is.bokun.client;

import com.google.inject.Inject;
import is.bokun.dtos.ApiResponse;
import is.bokun.dtos.ErrorDto;
import is.bokun.dtos.booking.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Client for the Booking resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class BookingClient extends AbstractClient {

    private static final String BASE = "/booking.json";

    /**
     * @see AbstractClient#()
     *
     * @param config
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
     * Confirm a RESERVED booking. Normally called after processing payment.
     *
     * @param bookingId the ID of the Booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return
     */
    public BookingDetailsDto confirmBooking(Long bookingId, String lang, String currency) {
    	return confirmBooking(bookingId, new ArrayList<BookingPaymentInfoDto>(), lang, currency);
    }
    
    /**
     * Confirm a RESERVED booking. Normally called after processing payment.
     *
     * @param bookingId the ID of the Booking
     * @param payments a list of payment infos, each describing how a payment was made for a product booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return
     */
    public BookingDetailsDto confirmBooking(Long bookingId, List<BookingPaymentInfoDto> payments, String lang, String currency) {
    	BookingPaymentsDto paymentsDto = new BookingPaymentsDto();
    	paymentsDto.payments = payments;
        String uri = appendLangAndCurrency(BASE + "/" + bookingId + "/confirm", lang, currency);
        return postBooking(uri, paymentsDto);
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
}
