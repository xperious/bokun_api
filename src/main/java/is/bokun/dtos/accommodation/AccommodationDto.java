package is.bokun.dtos.accommodation;

import java.util.*;

import is.bokun.dtos.*;


public class AccommodationDto extends ProductDto {

	public int rating;
	
    public int checkInHour = 14;
    public int checkInMinute = 0;
    public int checkOutHour = 12;
    public int checkOutMinute = 0;
	 
	public Set<String> types = new HashSet<>();
	
	public LocationDto location;
	
	public List<RoomTypeDto> roomTypes = new ArrayList<>();
	
	public List<BookableExtraDto> bookableExtras = new ArrayList<>();
	
	public AccommodationDto() {
		super();
	}

	public String checkInTime() {
		return getTimeAsString(checkInHour, checkInMinute);
	}
	
	public String checkOutTime() {
		return getTimeAsString(checkOutHour, checkOutMinute);
	}
	
    private String getTimeAsString(int hour, int minute) {
        StringBuilder s = new StringBuilder();
        s.append(hour);
        s.append(':');
        if ( minute < 10 ) {
            s.append(0);
        }
        s.append(minute);
        return s.toString();
    }
    
    public RoomTypeDto findRoomType(Long id) {
    	for (RoomTypeDto rt : roomTypes) {
    		if ( rt.id.equals(id) ) {
    			return rt;
    		}
    	}
    	return null;
    }
}