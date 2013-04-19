package is.bokun.client;

import is.bokun.dtos.TagGroupDto;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;

import com.google.inject.Inject;
import com.ning.http.client.Response;

/**
 * Client for the Tag resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class TagClient extends AbstractClient {

    private static final String BASE = "/tag.json";

    /**
     * @see AbstractClient#()
     *
     * @param config
     */
    @Inject
    public TagClient(ClientConfiguration config) {
        super(config);
    }

    /**
     * Get all the available groups.
     * @param lang The language in which to serve the groups.
     * @return List of all the tag groups.
     */
    public List<TagGroupDto> getGroups(String lang) {
        try {
            String uri = BASE + "/groups?lang=" + lang;
            Response r = prepareGet(uri).execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<TagGroupDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
