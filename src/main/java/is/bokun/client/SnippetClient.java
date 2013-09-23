package is.bokun.client;

import is.bokun.queries.*;

import com.google.inject.Inject;

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

    public String getActivityBookingOptions(Long id, String lang, String currency, boolean showCalendar, boolean showUpcoming,
    		boolean showActivityList, boolean hideExtras, boolean showWarningIfFewLeft, int warningThreshold,
    		String displayOrder, int maxUpcoming, boolean includeSoldOut, boolean defaultCategoryMandatory, int year, int month, String containerId) {
        NVP[] params = new NVP[]{
                new NVP("showCalendar", showCalendar),
                new NVP("showUpcoming", showUpcoming),
                new NVP("showActivityList", showActivityList),
                new NVP("hideExtras", hideExtras),
                new NVP("displayOrder", displayOrder),
                new NVP("maxUpcoming", maxUpcoming),
                new NVP("includeSoldOut", includeSoldOut),
                new NVP("showWarningIfFewLeft", showWarningIfFewLeft),
                new NVP("warningThreshold", warningThreshold),
                new NVP("year", year),
                new NVP("month", month),
                new NVP("containerId", containerId),
                new NVP("defaultCategoryMandatory", defaultCategoryMandatory)
        };
        String uri = appendLangAndCurrency("/snippets/activity/" + id + "/booking-options", lang, currency, params);
        return getAndValidateStr(uri);
    }

    public String getAccommodationBookingOptions(Long id, AccommodationQuery query, String lang, String currency, boolean cart) {
        String uri = appendLangAndCurrency("/snippets/accommodation/" + id + "/room-list", lang, currency, new NVP("cart", cart));
        return postAndValidateStr(uri, query);
    }

    public String getActivityCalendar(Long id, int year, int month, String lang, String currency, boolean includeSoldOut) {
        String uri = appendLangAndCurrency("/snippets/activity/" + id + "/calendar/" + year + "/" + month, lang, currency, new NVP("includeSoldOut", includeSoldOut));
        return getAndValidateStr(uri);
    }

    public String getUpcomingActivityAvailabilities(Long id, int max, boolean includeSoldOut, String lang, String currency) {
        String uri = appendLangAndCurrency("/snippets/activity/" + id + "/upcoming/" + max + "/" + includeSoldOut, lang, currency);
        return getAndValidateStr(uri);
    }
    
    public String getCarList(CarQuery query, boolean showFacets, String lang, String currency) {
    	String uri = appendLangAndCurrency("/snippets/car-rental/car-list", lang, currency, new NVP("withFacets", showFacets));
    	return postAndValidateStr(uri, query);
    }
    
    public String getCarAvailabilityForm(Long carRentalId, CarQuery query, String lang, String currency) {
    	String uri = appendLangAndCurrency("/snippets/car-rental/car-availability-form/" + carRentalId, lang, currency);
    	return postAndValidateStr(uri, query);
    }
    
    public String getCarBookingOptions(Long id, CarQuery query, String lang, String currency, boolean showUnitsForIncludedExtras) {
    	String uri = appendLangAndCurrency("/snippets/car-rental/car-details/" + id, lang, currency, new NVP("showUnitsForIncludedExtras", showUnitsForIncludedExtras));
    	return postAndValidateStr(uri, query);
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
