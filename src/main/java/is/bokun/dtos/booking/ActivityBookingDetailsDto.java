package is.bokun.dtos.booking;

import java.util.*;

public class ActivityBookingDetailsDto extends ProductBookingDetailsDto {

	public Date date;
    public List<ExtraBookingDetailsDto> extras = new ArrayList<>();

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
}
