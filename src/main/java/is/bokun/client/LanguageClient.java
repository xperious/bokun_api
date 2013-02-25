package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.TranslationLanguageDto;
import org.codehaus.jackson.type.TypeReference;

import java.util.List;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class LanguageClient extends AbstractClient {

    private static final String BASE = "/language.json";

    public LanguageClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

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
