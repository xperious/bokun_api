package queries;

import java.util.ArrayList;
import java.util.List;

import utils.StringUtils;

public class ActivityQuery extends AbstractQuery { 

    public int adl = 1;
    public String chl;

    public ActivityQuery() {
    }

    public int adults() {
        return adl;
    }

    public List<Integer> children() {
        return new ArrayList<Integer>(StringUtils.commaSeparatedToInts(chl));
    }

    public int totalPassengerCount() {
        return adults() + children().size();
    }
}
