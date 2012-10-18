package dtos.booking;

import java.util.*;

import utils.DateUtils;
import utils.StringUtils;

public class AccommodationBookingRequestDto {

    public Long accommodationId;
    public String checkinDate, checkoutDate;
    public List<RoomBookingDTO> rooms = new ArrayList<RoomBookingDTO>();

    public AccommodationBookingRequestDto() {}

    public Date getStartDate() {
        return StringUtils.parseDate(checkinDate);
    }
    public Date getEndDate() {
        return StringUtils.parseDate(checkoutDate);
    }

    public int getNightCount() {
        return DateUtils.getNightCount(getStartDate(), getEndDate());
    }


    public static class RoomBookingDTO {

        public Long roomTypeId;
        public int unitCount;
        public List<ExtraBookingDTO> extras = new ArrayList<ExtraBookingDTO>();

        public RoomBookingDTO() {}
    }
    
    public static class ExtraBookingDTO {
    	
    	public Long extraId;
    	public int unitCount;
    	
    	public ExtraBookingDTO() {}
    }
}
