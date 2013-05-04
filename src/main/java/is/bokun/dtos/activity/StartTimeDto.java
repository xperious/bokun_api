package is.bokun.dtos.activity;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import is.bokun.dtos.PriceByMonthDto;

public class StartTimeDto {

	public Long id;
	
	public int hour = 12;
	public int minute;
	
    public String durationType;
    public int duration = 1;
    
    public PriceByMonthDto prices;
    
    public StartTimeDto() {}
    
    @JsonIgnore
    public int getLowestPrice() {
    	return prices.getLowestPrice();
    }
    
    @JsonIgnore
    public String getTimeAsString() {
        StringBuilder s = new StringBuilder();
        s.append(hour);
        s.append(':');
        if ( minute < 10 ) {
            s.append(0);
        }
        s.append(minute);
        return s.toString();
    }
    
    @JsonIgnore
    public int getAdultPrice(Date d) {
    	return prices.getPriceForDate(d);
    }
    
    @JsonIgnore
    public int getChildPrice(ActivityDto activity, Date d) {
        if ( activity.childDiscount <= 0 ) {
            return prices.getPriceForDate(d);
        }
        return getPercentageOfPrice(prices.getPriceForDate(d), activity.childDiscount);
    }

    @JsonIgnore
    public int getTeenagerPrice(ActivityDto activity, Date d) {
        if ( activity.teenagerDiscount <= 0 ) {
            return prices.getPriceForDate(d);
        }
        return getPercentageOfPrice(prices.getPriceForDate(d), activity.teenagerDiscount);
    }
    
    @JsonIgnore
    public static int getPercentageOfPrice(int price, int discount) {
        int multiplier = 100 - discount;
        double base = price;
        return (int)Math.floor(base * (((double)multiplier) / 100d) + 0.5d);
    }
}
