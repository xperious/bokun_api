package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import is.bokun.utils.DateUtils;
import is.bokun.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccommodationBookingRequestDto {

    public Long accommodationId;
    public String checkinDate, checkoutDate;
    public List<RoomBookingDTO> rooms = new ArrayList<RoomBookingDTO>();

    public AccommodationBookingRequestDto() {}
    
    public Long getAccommodationId() {
		return accommodationId;
	}
	public void setAccommodationId(Long accommodationId) {
		this.accommodationId = accommodationId;
	}

	public String getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public List<RoomBookingDTO> getRooms() {
		return rooms;
	}
	public void setRooms(List<RoomBookingDTO> rooms) {
		this.rooms = rooms;
	}


	@JsonIgnore
    public Date getStartDate() {
        return StringUtils.parseDate(checkinDate);
    }
    @JsonIgnore
    public Date getEndDate() {
        return StringUtils.parseDate(checkoutDate);
    }
    @JsonIgnore
    public int getNightCount() {
        return DateUtils.getNightCount(getStartDate(), getEndDate());
    }


    public static class RoomBookingDTO {

        public Long roomTypeId;
        public int unitCount;
        public List<ExtraBookingRequestDto> extras = new ArrayList<ExtraBookingRequestDto>();

        public RoomBookingDTO() {}

		public Long getRoomTypeId() {
			return roomTypeId;
		}

		public void setRoomTypeId(Long roomTypeId) {
			this.roomTypeId = roomTypeId;
		}

		public int getUnitCount() {
			return unitCount;
		}

		public void setUnitCount(int unitCount) {
			this.unitCount = unitCount;
		}

		public List<ExtraBookingRequestDto> getExtras() {
			return extras;
		}

		public void setExtras(List<ExtraBookingRequestDto> extras) {
			this.extras = extras;
		}
        
    }

}
