package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraBookingDto {

    public Long id;

    public BookingItemInfoDto extra;
    public String description;

    public boolean included;
    public int unitCount;
    public int bookedPrice;
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

    public boolean isIncluded() {
        return included;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public int getBookedPrice() {
        return bookedPrice;
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
