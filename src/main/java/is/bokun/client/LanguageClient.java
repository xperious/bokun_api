package is.bokun.client;

import com.google.inject.Inject;
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
     * @param config
     */
    @Inject
    public LanguageClient(ClientConfiguration config) {
        super(config);
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
            Response r = prepareGet(uri).execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<TranslationLanguageDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
