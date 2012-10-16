package dtos.booking;

import java.util.*;

import utils.*;

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
        public int adultCount;
        public int childCount;
        public String childAges;
        public String extraIds;

        public RoomBookingDTO() {}
    }
}
