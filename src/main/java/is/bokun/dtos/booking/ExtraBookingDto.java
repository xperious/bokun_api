package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraBookingDto {

    public Long id;

    public BookingItemInfoDto extra;
    public String description;

    public boolean included;
    public int unitCount;
    public String pricingType;
    public String pricingTypeLabel;
    
    public List<BookingAnswerWithIdDto> answers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public BookingItemInfoDto getExtra() {
        return extra;
    }

    public String getDescription() {
        return description;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public String getPricingType() {
        return pricingType;
    }

    public List<BookingAnswerWithIdDto> getAnswers() {
        return answers;
    }

    public String getPricingTypeLabel() {
        return pricingTypeLabel;
    }
}
