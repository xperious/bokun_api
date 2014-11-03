package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Iterables;
import is.bokun.dtos.VendorDto;
import is.bokun.dtos.transport.RouteLegDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ogg on 24.9.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteBookingDto extends ProductBookingDto {

    public Date date;
    public boolean flexible;

    public ProductInfoDto route;
    public List<RouteLegBookingDto> legBookings = new ArrayList<>();

    public RouteBookingDto returnBooking;

    public List<RouteBookingLineItemSpecDto> lineItemSpecs = new ArrayList<>();

    @JsonIgnore
    public RouteLegBookingDto getFirstLegBooking() {
        return Iterables.getFirst(legBookings, null);
    }

    @JsonIgnore
    public RouteLegBookingDto getLastLegBooking() {
        return Iterables.getLast(legBookings, null);
    }

    @JsonIgnore
    public Date getSortDate() {
        return date;
    }

    @Override
    public VendorDto getVendor() {
        return route.vendor;
    }

    @Override
    public String getProductCategory() {
        return "TRANSPORT";
    }

    @JsonIgnore
    public List<RouteLegDto> getBookedLegs() {
        List<RouteLegDto> list = new ArrayList<>();
        for (RouteLegBookingDto legBooking : legBookings) {
            if ( !list.contains(legBooking.leg) ) {
                list.add(legBooking.leg);
            }
        }
        return list;
    }

}
