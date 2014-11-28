package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.VendorDto;
import is.bokun.utils.DateUtils;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class AccommodationBookingDto extends ProductBookingDto {

    public Date startDate;
    public Date endDate;
    
    public ProductInfoDto accommodation;
    
    public List<RoomBookingDto> roomBookings = new ArrayList<>();

    @JsonIgnore
    public int getNightCount() {
        return DateUtils.getNightCount(startDate, endDate);
    }
    
    @JsonIgnore
    public Date getSortDate() {
    	return startDate;
    }

    @Override
    public VendorDto getVendor() {
        return accommodation.vendor;
    }

	@Override
	public String getProductCategory() {
		return "ACCOMMODATION";
	}
}
