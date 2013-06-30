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
}
