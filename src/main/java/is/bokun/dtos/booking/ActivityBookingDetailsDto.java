package is.bokun.dtos.booking;

import is.bokun.dtos.activity.StartTimeDto;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityBookingDetailsDto extends ProductBookingDetailsDto {

	public int price;
	public int childDiscount;
	public int teenDiscount;
	
	public int adults;
	public int teens;
	public int children;
	
	public Date date;
    public List<ExtraBookingDetailsDto> extras = new ArrayList<>();
    public Map<String,String> fields = new HashMap<>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ExtraBookingDetailsDto> getExtras() {
        return extras;
    }

    public void setExtras(List<ExtraBookingDetailsDto> extras) {
        this.extras = extras;
    }

	public Map<String, String> getFields() {
		return fields;
	}

	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}
	
    public int getTeenPrice() {
    	return StartTimeDto.getPercentageOfPrice(price, teenDiscount);
    }
    
    public int getChildPrice() {
    	return StartTimeDto.getPercentageOfPrice(price, childDiscount);
    }
}
