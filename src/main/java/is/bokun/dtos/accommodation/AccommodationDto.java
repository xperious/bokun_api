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

	public CancellationPolicy cancellationPolicy;
	
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCheckInHour() {
        return checkInHour;
    }

    public void setCheckInHour(int checkInHour) {
        this.checkInHour = checkInHour;
    }

    public int getCheckInMinute() {
        return checkInMinute;
    }

    public void setCheckInMinute(int checkInMinute) {
        this.checkInMinute = checkInMinute;
    }

    public int getCheckOutHour() {
        return checkOutHour;
    }

    public void setCheckOutHour(int checkOutHour) {
        this.checkOutHour = checkOutHour;
    }

    public int getCheckOutMinute() {
        return checkOutMinute;
    }

    public void setCheckOutMinute(int checkOutMinute) {
        this.checkOutMinute = checkOutMinute;
    }

    public Long getBoxedAccommodationId() {
        return boxedAccommodationId;
    }

    public void setBoxedAccommodationId(Long boxedAccommodationId) {
        this.boxedAccommodationId = boxedAccommodationId;
    }

    public Set<String> getTypes() {
        return types;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public List<RoomTypeDto> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypeDto> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public List<BookableExtraDto> getBookableExtras() {
        return bookableExtras;
    }

    public void setBookableExtras(List<BookableExtraDto> bookableExtras) {
        this.bookableExtras = bookableExtras;
    }

    public static class PenaltyRule {
	    public long id;
	    public int cutoffHours;
	    public double charge;
	    public String chargeType;
    }

    public static class Tax {
	    public long id;
	    public boolean included;
	    public double percentage;
	    public String title;
    }

    public static class CancellationPolicy {
	    public long id;
	    public String title;
	    public List<PenaltyRule> penaltyRules;
	    public Tax tax;
    }

}