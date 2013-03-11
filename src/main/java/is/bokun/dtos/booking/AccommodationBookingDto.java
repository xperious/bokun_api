package is.bokun.dtos.booking;

import java.util.*;

import is.bokun.utils.DateUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

public class AccommodationBookingDto extends ProductBookingDto {

    public Date startDate;
    public Date endDate;
    
    public ProductInfoDto accommodation;
    
    public List<RoomBookingDto> roomBookings = new ArrayList<RoomBookingDto>();

    @JsonIgnore
    public int getNightCount() {
        return DateUtils.getNightCount(startDate, endDate);
    }
    
    @JsonIgnore
    public Date getSortDate() {
    	return startDate;
    }
}
