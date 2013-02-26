package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.CurrencyDto;
import is.bokun.dtos.TranslationLanguageDto;
import org.codehaus.jackson.type.TypeReference;

import java.util.List;

/**
 * Client for the Currency resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class CurrencyClient extends AbstractClient {

    private static final String BASE = "/currency.json";

    /**
     * @see AbstractClient#()
     *
     * @param host
     * @param accessKey
     * @param secretKey
     * @param asyncClient
     */
    public CurrencyClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    /**
     * Get a list of all the currencies that the system knows how to convert to. The "currency" parameter,
     * which many of the client methods accept, must be a valid value from this list.
     *
     * @return a list of all the currencies the system knows how to handle
     */
    public List<CurrencyDto> findAll() {
        try {
            String uri = BASE + "/findAll";
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<CurrencyDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
