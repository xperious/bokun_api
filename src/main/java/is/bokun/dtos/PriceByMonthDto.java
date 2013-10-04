package is.bokun.dtos;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceByMonthDto {

    public int jan;
    public int feb;
    public int mar;
    public int apr;
    public int may;
    public int jun;
    public int jul;
    public int aug;
    public int sep;
    public int oct;
    public int nov;
    public int dec;
    
    @JsonIgnore
    public String getCommaSeparatedPrices() {
    	StringBuilder b = new StringBuilder();
    	b.append(jan).append(',').append(feb).append(',').append(mar).append(',').append(apr)
    		.append(',').append(may).append(',').append(jun).append(',').append(jul).append(',').append(aug)
    		.append(',').append(sep).append(',').append(oct).append(',').append(nov).append(',').append(dec);
    	return b.toString();
    }
    
    @JsonIgnore
    public int getLowestPrice() {
    	int lowest = jan;
    	lowest = Math.min(lowest, feb);
    	lowest = Math.min(lowest, mar);
    	lowest = Math.min(lowest, apr);
    	lowest = Math.min(lowest, may);
    	lowest = Math.min(lowest, jun);
    	lowest = Math.min(lowest, jul);
    	lowest = Math.min(lowest, aug);
    	lowest = Math.min(lowest, sep);
    	lowest = Math.min(lowest, oct);
    	lowest = Math.min(lowest, nov);
    	lowest = Math.min(lowest, dec);
    	return lowest;
    }

    @JsonIgnore
    public int getPriceForMonth(int month) {
        switch (month) {
            case Calendar.JANUARY:
                return jan;
            case Calendar.FEBRUARY:
                return feb;
            case Calendar.MARCH:
                return mar;
            case Calendar.APRIL:
                return apr;
            case Calendar.MAY:
                return may;
            case Calendar.JUNE:
                return jun;
            case Calendar.JULY:
                return jul;
            case Calendar.AUGUST:
                return aug;
            case Calendar.SEPTEMBER:
                return sep;
            case Calendar.OCTOBER:
                return oct;
            case Calendar.NOVEMBER:
                return nov;
            case Calendar.DECEMBER:
                return dec;
            default:
                throw new RuntimeException("Unknown month!");
        }
    }

    @JsonIgnore
    public int getPriceForDate(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return getPriceForMonth(cal.get(Calendar.MONTH));
    }
}
