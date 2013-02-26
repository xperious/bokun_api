package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

import is.bokun.dtos.CountryDto;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.type.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Client for the country resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class CountryClient extends AbstractClient {

    private static final String BASE = "/country.json";

    /**
     * @see AbstractClient#()
     *
     * @param host
     * @param accessKey
     * @param secretKey
     * @param asyncClient
     */
    public CountryClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    /**
     * Get a list of all countries the system knows about.
     * @return a List of country objects, each containing the title and the ISO code for that country.
     */
    public List<CountryDto> findAll() {
        try {
            String uri = BASE + "/findAll";
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);

            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<CountryDto>>(){});

        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
