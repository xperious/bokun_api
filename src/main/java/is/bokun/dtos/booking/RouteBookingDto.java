package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Iterables;
import is.bokun.dtos.VendorDto;
import is.bokun.dtos.transport.RouteLegDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ogg on 24.9.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "RouteBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class RouteBookingDto extends ProductBookingDto {

    public Date date;
    public boolean flexible;

    public ProductInfoDto route;
    public List<RouteLegBookingDto> legBookings = new ArrayList<>();
    public List<RoutePassengerBookingDto> passengerBookings = new ArrayList<>();

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
