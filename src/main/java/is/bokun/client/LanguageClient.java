package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.TranslationLanguageDto;
import org.codehaus.jackson.type.TypeReference;

import java.util.List;

/**
 * Client for the Language resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class LanguageClient extends AbstractClient {

    private static final String BASE = "/language.json";

    /**
     * @see AbstractClient#()
     *
     * @param host
     * @param accessKey
     * @param secretKey
     * @param asyncClient
     */
    public LanguageClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    /**
     * Get a list of all the languages the system supports. The "lang" parameter,
     * which many of the client methods accept, must be a valid value from this list.
     *
     * @return a list of all the languages supported
     */
    public List<TranslationLanguageDto> findAll() {
        try {
            String uri = BASE + "/findAll";
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<TranslationLanguageDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
