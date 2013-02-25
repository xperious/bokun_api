package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.ApiResponse;
import is.bokun.dtos.ErrorDto;
import is.bokun.dtos.booking.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class BookingClient extends AbstractClient {

    private static final String BASE = "/booking.json";

    public BookingClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    public BookingQuestionsDto getGuestBookingQuestions(String sessionId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/guest/" + sessionId + "/questions", lang, currency);
        return getQuestions(uri);
    }

    public BookingQuestionsDto getUserBookingQuestions(String securityToken, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/user/" + securityToken + "/questions", lang, currency);
        return getQuestions(uri);
    }

    private BookingQuestionsDto getQuestions(String uri) {
        try {
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), BookingQuestionsDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public BookingDetailsDto reserveBookingForGuest(String sessionId, BookingAnswersDto answers, String lang, String currency, Map<String,String> paymentProviderParams) {
        String uri = appendQueryParams(BASE + "/guest/" + sessionId + "/reserve", gatherParams(lang, currency, paymentProviderParams));
        return postBooking(uri, answers);
    }

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
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.preparePost(host + uri);
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

    public BookingDetailsDto confirmBooking(Long bookingId, PaymentDetailsDto paymentDetails, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/" + bookingId + "/confirm", lang, currency);
        return postBooking(uri, paymentDetails);
    }

    public ApiResponse cancelReservedBooking(Long bookingId, boolean timeout) {
        try {
            String uri = BASE + "/" + bookingId + "/cancel-reserved?timeout=" + timeout;
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), ApiResponse.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public PaymentProviderDetailsDto getPaymentProviderDetails(Long bookingId, String lang, String currency) {
        try {
            String uri = appendLangAndCurrency(BASE + "/" + bookingId + "/payment-provider", lang, currency);
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), PaymentProviderDetailsDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public ApiResponse reportPaymentError(Long bookingId, ErrorDto errorDetails) {
        try {
            String uri = BASE + "/" + bookingId + "/payment-error";
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.preparePost(host + uri);
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
