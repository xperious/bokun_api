package is.bokun.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookableExtraDto {

    public Long id;
    public String externalId;
    public String title;
    public String information;
    public boolean included;

    public String pricingType;
    public String pricingTypeLabel;
    public int price;

    public int maxPerBooking;
    
    public List<String> flags = new ArrayList<>();

    public List<QuestionDto> questions = new ArrayList<>();
    
    @JsonIgnore
    public static List<BookableExtraDto> filterNotHidden(List<BookableExtraDto> list) {
    	List<BookableExtraDto> filtered = new ArrayList<>();
    	for (BookableExtraDto e : list) {
    		if ( !e.flags.contains("widget-hidden") ) {
    			filtered.add(e);
    		}
    	}
    	return filtered;
    }
}
