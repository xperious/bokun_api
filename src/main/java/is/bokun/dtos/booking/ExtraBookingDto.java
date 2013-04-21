package is.bokun.dtos.booking;

import java.util.*;


public class ExtraBookingDto {

    public Long id;

    public BookingItemInfoDto extra;
    public String description;

    public boolean included;
    public int unitCount;
    public int bookedPrice;
    public String pricingType;
    
    public List<BookingAnswerWithIdDto> answers = new ArrayList<>();
}
