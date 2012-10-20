package dtos.activity;

import java.text.SimpleDateFormat;
import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;

import dtos.ProductDto;

public class ActivityDto extends ProductDto {

    public String included;
    public String requirements; 
    public String attention;
    
    @Property(translation = "durationType.name()")
    public String durationType;
    public int duration;

    @Property(translation = "pricingType.name()")
    public String pricingType;
    
    public int minAge;
    public int maxChildrenPerAdult = 4;

    public int childMaxAge = 11;
    public int teenagerMaxAge = 17;
    
    public int childDiscount = 100;
    public int teenagerDiscount = 50;

    public boolean seasonAllYear;

    public int seasonStartDate;
    public int seasonStartMonth;

    public int seasonEndDate;
    public int seasonEndMonth;
    
    @Property(translation = "difficultyLevel.name()")
    public String difficultyLevel;
    
    @CollectionProperty(itemTranslation = AgendaItemDto.class)
    public List<AgendaItemDto> agendaItems = new ArrayList<AgendaItemDto>();

    @CollectionProperty(itemTranslation = StartTimeDto.class)
    public List<StartTimeDto> startTimes = new ArrayList<StartTimeDto>();

    @CollectionProperty(itemTranslation = ActivityExtraDto.class)
    public List<ActivityExtraDto> bookableExtras = new ArrayList<ActivityExtraDto>();
	
	public ActivityDto() {
		super();
	}
	
	@JsonIgnore
	public Date getSeasonStart() throws Exception {
		SimpleDateFormat parser = new SimpleDateFormat("dd.MM");
		return parser.parse("" + seasonStartDate + "." + seasonStartMonth);
	}
	
	@JsonIgnore
	public Date getSeasonEnd() throws Exception {
		SimpleDateFormat parser = new SimpleDateFormat("dd.MM");
		return parser.parse("" + seasonEndDate + "." + seasonEndMonth);
	}
	
    @JsonIgnore
    public int getLowestChildPrice() {
    	return getPercentageOfPrice(findLowestPrice(), childDiscount);
    }
    
    @JsonIgnore
    public int getLowestTeenagerPrice() {
    	return getPercentageOfPrice(findLowestPrice(), teenagerDiscount);
    }
    
    @JsonIgnore
    private int getPercentageOfPrice(int price, int discount) {
        int multiplier = 100 - discount;
        double base = price;
        return (int)Math.floor(base * (((double)multiplier) / 100d) + 0.5d);
    }
	
	@JsonIgnore
	public int findLowestPrice() {
		int lowestPrice = -1;
		for (StartTimeDto st : startTimes) {
			int startTimeLowest = st.prices.getLowestPrice();
			if ( lowestPrice == -1 || startTimeLowest < lowestPrice ) {
				lowestPrice = startTimeLowest;
			}
		}
		return lowestPrice;
	}

}
