package is.bokun.dtos.accommodation;

import java.text.Collator;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "accommodation")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccommodationDto extends ProductDto {

	public int rating;
	
    public int checkInHour = 14;
    public int checkInMinute = 0;
    public int checkOutHour = 12;
    public int checkOutMinute = 0;

    public Long boxedAccommodationId;
	 
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

    @JsonIgnore
    public List<RoomTypeDto> getPublicRoomTypes() {
        List<RoomTypeDto> list = new ArrayList<>();
        for (RoomTypeDto r : roomTypes) {
            if ( !r.internalUseOnly ) {
                list.add(r);
            }
        }

        final Collator collator = Collator.getInstance(new Locale("is"));
        Collections.sort(list, new Comparator<RoomTypeDto>() {
            @Override
            public int compare(RoomTypeDto o1, RoomTypeDto o2) {
                return collator.compare(o1.title, o2.title);
            }
        });
        return list;
    }
}