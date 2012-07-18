package queries;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import utils.StringUtils;

/**
 * @author Olafur Gauti Gudmundsson
 */
public abstract class AbstractQuery {

    public String cin;
    public String cout;

    public String v; // view mode

    public LocationQuery l;

    public NumericRange p; // price range

    public int pg = 1;
    public int ps = 20;

    public Map<String,String[]> rawQueryString = new HashMap<String, String[]>();

    public boolean hasNonEmptyParam(String name) {
        return rawQueryString.containsKey(name) && !rawQueryString.get(name)[0].trim().isEmpty();
    }

    /*
    public void validateAndFix(CurrencyConverter converter, String selectedCurrency) {
        if ( startDate() != null ) {
            // validate the check-in and check-out dates
            Calendar now = Calendar.getInstance();
            DateUtils.nullifyTime(now);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate());
            DateUtils.nullifyTime(startCal);

            if ( startCal.before(now) ) {
                cin = new SimpleDateFormat("dd.MM.yyyy").format(now.getTime());
            }

            if ( endDate() != null ) {
                Calendar endCal = Calendar.getInstance();
                endCal.setTime(endDate());
                DateUtils.nullifyTime(endCal);

                if ( endCal.before(startCal) ) {
                    String temp = new String(cin);
                    cin = cout;
                    cout = temp;
                }
            }
        }

        if ( filterByPrice() ) {
            // convert to the base currency
            if ( p.f != null ) {
                p.f = converter.toBaseInt(selectedCurrency, p.f);
            }
            if ( p.t != null ) {
                p.t = converter.toBaseInt(selectedCurrency, p.t);
            }
        }
    }*/

    public Date startDate() {
        return StringUtils.parseDate(cin);
    }
    public Date endDate() {
        return StringUtils.parseDate(cout);
    }

    public boolean viewMap() {
        return v != null && v.equalsIgnoreCase("map");
    }
    public boolean viewList() {
        return v == null || !viewMap();
    }

    public boolean hasLocation() {
        return l != null && !(l.lat == 0 && l.lng == 0);
    }

    public LocationQuery location() {
        return l;
    }

    public boolean filterByPrice() {
        return p != null && p.filter("test") != null;
    }

    public int page() {
        if ( pg <= 0 ) {
            return 1;
        }
        return pg;
    }

    public int pageSize() {
        if ( ps <= 0 ) {
            return 20;
        }
        return ps;
    }
}
