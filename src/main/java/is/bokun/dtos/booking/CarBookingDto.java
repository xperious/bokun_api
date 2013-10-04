package is.bokun.dtos.booking;

import is.bokun.dtos.carrental.CarTypeInfoDto;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarBookingDto {

	public Long id;
	
	public CarTypeInfoDto carType;

    public Date startDate;
    public Date endDate;
	
    public int unitCount;
	
	public boolean unavailable;
	public int availabilityCount;
	public int carPrice;
	public int extrasPrice;
	public int locationPrice;
	
	public List<ExtraBookingDto> extraBookings = new ArrayList<>();
	
	public List<CarTypeAvailabilityBookingDto> availabilityBookings = new ArrayList<>();
	
	@JsonIgnore
    public List<ExtraBookingDto> getExtraBookings(boolean included) {
        List<ExtraBookingDto> list = new ArrayList<>();
        for ( ExtraBookingDto ae : extraBookings ) {
            if ( (ae.included && included) || (!ae.included && !included) ) {
                list.add(ae);
            }
        }
        return list;
    }

    public List<ExtraBookingDto> getExtraBookings() {
        return extraBookings;
    }
}
