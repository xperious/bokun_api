package is.bokun.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
}
