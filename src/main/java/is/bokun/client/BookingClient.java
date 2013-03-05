package is.bokun.client;

import com.google.inject.Inject;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
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
     * Get a list of questions for the user. This provides a list of all questions the user
     * must answer in order to reserve the booking before payment.
     *
     * @param securityToken the token received by the user on authentication
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return questions derived from the user's shopping cart
     */
    public BookingQuestionsDto getUserBookingQuestions(String securityToken, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/questions", lang, currency);
        return getQuestions(uri);
    }

    private BookingQuestionsDto getQuestions(String uri) {
        try {
            AsyncHttpClient.BoundRequestBuilder b = config.getAsyncClient().prepareGet(config.getHost() + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), BookingQuestionsDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Reserve a booking for a guest, reserving availability for all products. Normally called before accepting payment.
     * Creates a Booking with the status RESERVED from the items
     * in the guest's session shopping cart, applying the answers supplied.
     *
     * @param sessionId the guest's session ID
     * @param answers answers to the questions required for booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @param paymentProviderParams optional map of parameters directed at the payment provider (successURL, cancelURL, etc.).
     *                              Refer to the relevant payment provider documentation for more info.
     * @return details for the reserved booking
     */
    public BookingDetailsDto reserveBookingForGuest(String sessionId, BookingAnswersDto answers, String lang, String currency, Map<String,String> paymentProviderParams) {
        String uri = appendQueryParams(BASE + "/guest/" + sessionId + "/reserve", gatherParams(lang, currency, paymentProviderParams));
        return postBooking(uri, answers);
    }

    /**
     * Reserve a booking for a user, reserving availability for all products. Normally called before accepting payment.
     * Creates a Booking with the status RESERVED from the items
     * in the users's shopping cart, applying the answers supplied.
     *
     * @param securityToken the token received by the user on authentication
     * @param answers answers to the questions required for booking
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @param paymentProviderParams optional map of parameters directed at the payment provider (successURL, cancelURL, etc.).
     *                              Refer to the relevant payment provider documentation for more info.
     * @return details for the reserved booking
     */
    public BookingDetailsDto reserveBookingForUser(String securityToken, BookingAnswersDto answers, String lang, String currency, Map<String,String> paymentProviderParams) {
        String uri = appendQueryParams(BASE + "/user/" + securityToken + "/reserve", gatherParams(lang, currency, paymentProviderParams));
        return postBooking(uri, answers);
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
        try {
            AsyncHttpClient.BoundRequestBuilder b = config.getAsyncClient().preparePost(config.getHost() + uri);
            addSecurityHeaders(b, "POST", uri);
            b.setBodyEncoding("UTF-8");
            b.setBody(json.writeValueAsString(body));

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), BookingDetailsDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Confirm a RESERVED booking. Normally called after processing payment.
     *
     * @param bookingId the ID of the Booking
     * @param paymentDetails details of the payment
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return
     */
    public BookingDetailsDto confirmBooking(Long bookingId, PaymentDetailsDto paymentDetails, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/" + bookingId + "/confirm", lang, currency);
        return postBooking(uri, paymentDetails);
    }

    /**
     * Cancel a RESERVED booking. Normally called if the user cancels the payment, or the payment session times out.
     *
     * @param bookingId the ID of the booking
     * @param timeout specifies whether the booking was cancelled due to a timeout, should be "false" if the user manually cancelled
     * @return a simple OK response if things go well
     */
    public ApiResponse cancelReservedBooking(Long bookingId, boolean timeout) {
        try {
            String uri = BASE + "/" + bookingId + "/cancel-reserved?timeout=" + timeout;
            AsyncHttpClient.BoundRequestBuilder b = config.getAsyncClient().prepareGet(config.getHost() + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), ApiResponse.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
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
        try {
            String uri = appendLangAndCurrency(BASE + "/" + bookingId + "/payment-provider", lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = config.getAsyncClient().prepareGet(config.getHost() + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), PaymentProviderDetailsDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Report an error that occurred in payment. This will cancel the RESERVED booking, storing the details
     * about the error provided.
     *
     * @param bookingId the ID of the booking
     * @param errorDetails a description of the error that occurred
     * @return a simple OK response if things go well
     */
    public ApiResponse reportPaymentError(Long bookingId, ErrorDto errorDetails) {
        try {
            String uri = BASE + "/" + bookingId + "/payment-error";
            AsyncHttpClient.BoundRequestBuilder b = config.getAsyncClient().preparePost(config.getHost() + uri);
            addSecurityHeaders(b, "POST", uri);
            b.setBodyEncoding("UTF-8");
            b.setBody(json.writeValueAsString(errorDetails));

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), ApiResponse.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
