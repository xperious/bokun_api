package is.bokun.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.inject.Inject;
import com.ning.http.client.Response;
import is.bokun.dtos.ProductListDescriptionDto;
import is.bokun.dtos.ProductListDto;

import java.util.List;

/**
 * Client for the Product Lists.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class ProductListClient extends AbstractClient {

    private static final String BASE = "/product-list.json";

    /**
     * @see AbstractClient#()
     *
     * @param config
     */
    @Inject
    public ProductListClient(ClientConfiguration config) {
        super(config);
    }

    /**
     * Get a list of all car rentals that this booking channel has access to.
     *
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return a list of car rentals
     */
    public List<ProductListDescriptionDto> list(String lang, String currency) {
        try {
            String uri = BASE + "/list";
            Response r = prepareGet(uri).execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), new TypeReference<List<ProductListDescriptionDto>>(){});
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /**
     * Look up Product List by ID.
     *
     * @param listId The ID of the ProductList.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the Product List with the ID supplied
     */
    public ProductListDto findById(Long listId, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/" + listId, lang, currency);
        return getAndValidate(uri, ProductListDto.class);
    }

    /**
     * Look up Product List by slug. Note that slugs are not created automatically, they must
     * be defined per product list in the Bokun extranet. Also note that the slugs are language
     * dependent.
     *
     * @param slug The slug to look up by.
     * @param lang The language the content should be in.
     * @param currency The currency used for prices.
     * @return the Product List matching the slug and language provided
     */
    public ProductListDto findBySlug(String slug, String lang, String currency) {
        String uri = appendLangAndCurrency(BASE + "/slug/" + slug, lang, currency);
        return getAndValidate(uri, ProductListDto.class);
    }
}
