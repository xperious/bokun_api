package is.bokun.client;

import com.google.inject.Inject;
import is.bokun.queries.AccommodationQuery;

/**
 * This client retrieves the HTML snippets available.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class SnippetClient extends AbstractClient {

    /**
     * @see AbstractClient#()
     *
     * @param config
     */
    @Inject
    public SnippetClient(ClientConfiguration config) {
        super(config);
    }

    public String getAccommodationDisplay(Long id, boolean fluidLayout, String lang, String currency) {
        String uri = appendLangAndCurrency("/snippets/accommodation/" + id + "/display", lang, currency, new NVP("fluidLayout", ""+fluidLayout));
        return getAndValidateStr(uri);
    }

    public String getActivityDisplay(Long id, boolean fluidLayout, String lang, String currency) {
        String uri = appendLangAndCurrency("/snippets/activity/" + id + "/display", lang, currency, new NVP("fluidLayout", ""+fluidLayout));
        return getAndValidateStr(uri);
    }

    public String getActivityBookingOptions(Long id, String lang, String currency, boolean showCalendar, boolean showUpcoming, String displayOrder, int maxUpcoming, boolean includeSoldOut, int year, int month, String containerId) {
        NVP[] params = new NVP[]{
                new NVP("showCalendar", showCalendar),
                new NVP("showUpcoming", showUpcoming),
                new NVP("displayOrder", displayOrder),
                new NVP("maxUpcoming", maxUpcoming),
                new NVP("includeSoldOut", includeSoldOut),
                new NVP("year", year),
                new NVP("month", month),
                new NVP("containerId", containerId)
        };
        String uri = appendLangAndCurrency("/snippets/activity/" + id + "/booking-options", lang, currency, params);
        return getAndValidateStr(uri);
    }

    public String getAccommodationBookingOptions(Long id, AccommodationQuery query, String lang, String currency, boolean cart) {
        String uri = appendLangAndCurrency("/snippets/accommodation/" + id + "/room-list", lang, currency, new NVP("cart", cart));
        return postAndValidateStr(uri, query);
    }

    public String getActivityCalendar(Long id, int year, int month, String lang, String currency) {
        String uri = appendLangAndCurrency("/snippets/activity/" + id + "/calendar/" + year + "/" + month, lang, currency);
        return getAndValidateStr(uri);
    }

    public String getUpcomingActivityAvailabilities(Long id, int max, boolean includeSoldOut, String lang, String currency) {
        String uri = appendLangAndCurrency("/snippets/activity/" + id + "/upcoming/" + max + "/" + includeSoldOut, lang, currency);
        return getAndValidateStr(uri);
    }

    public String getBookingQuestionsForGuest(String sessionId, String lang, String currency) {
        String uri = appendLangAndCurrency("/snippets/booking-questions/guest/" + sessionId, lang, currency);
        return getAndValidateStr(uri);
    }

    public String getBookingQuestionsForCustomer(String securityToken, String lang, String currency) {
        String uri = appendLangAndCurrency("/snippets/booking-questions/customer/" + securityToken, lang, currency);
        return getAndValidateStr(uri);
    }

    public String getShoppingCartForGuest(String sessionId, String lang, String currency, boolean allowRemoval, boolean showIncludedExtras, boolean fluidLayout) {
        String uri = appendLangAndCurrency("/snippets/shopping-cart/session/" + sessionId, lang, currency,
                new NVP("allowRemoval", allowRemoval), new NVP("showIncludedExtras", showIncludedExtras), new NVP("fluidLayout", fluidLayout));
        return getAndValidateStr(uri);
    }

    public String getShoppingCartForCustomer(String securityToken, String lang, String currency, boolean allowRemoval, boolean showIncludedExtras, boolean fluidLayout) {
        String uri = appendLangAndCurrency("/snippets/shopping-cart/customer/" + securityToken, lang, currency,
                new NVP("allowRemoval", allowRemoval), new NVP("showIncludedExtras", showIncludedExtras), new NVP("fluidLayout", fluidLayout));
        return getAndValidateStr(uri);
    }
}
