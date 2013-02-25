package is.bokun.dtos.booking;


public class ExtraBookingDto {

    public Long id;

    public BookingItemInfoDto extra;
    public String description;

    public boolean included;
    public int unitCount;
    public int bookedPrice;
    public String pricingType;
}
