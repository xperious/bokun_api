package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Iterables;
import is.bokun.dtos.transport.RouteDto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ogg on 26.9.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "RouteBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class RouteBookingDetailsDto extends ProductBookingDetailsDto {

    public RouteDto route;

    public Date date;
    public boolean flexible;

    @XmlElementWrapper
    @XmlElement(name="legBooking")
    public List<RouteLegBookingDto> legBookings = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="passengerBooking")
    public List<RoutePassengerBookingDto> passengerBookings = new ArrayList<>();

    public RouteBookingDetailsDto returnBooking;

    @XmlElementWrapper
    @XmlElement(name="passengerSpecifications")
    public List<RouteBookingLineItemSpecDto> lineItemSpecs = new ArrayList<>();

    public RouteDto getRoute() {
        return route;
    }

    public void setRoute(RouteDto route) {
        this.route = route;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFlexible(boolean flexible) {
        this.flexible = flexible;
    }

    public List<RouteLegBookingDto> getLegBookings() {
        return legBookings;
    }

    public void setLegBookings(List<RouteLegBookingDto> legBookings) {
        this.legBookings = legBookings;
    }

    public RouteBookingDetailsDto getReturnBooking() {
        return returnBooking;
    }

    public void setReturnBooking(RouteBookingDetailsDto returnBooking) {
        this.returnBooking = returnBooking;
    }

    public List<RoutePassengerBookingDto> getPassengerBookings() {
        return passengerBookings;
    }

    public void setPassengerBookings(List<RoutePassengerBookingDto> passengerBookings) {
        this.passengerBookings = passengerBookings;
    }

    public List<RouteBookingLineItemSpecDto> getLineItemSpecs() {
        return lineItemSpecs;
    }

    public void setLineItemSpecs(List<RouteBookingLineItemSpecDto> lineItemSpecs) {
        this.lineItemSpecs = lineItemSpecs;
    }

    @JsonIgnore
    public boolean hasReturnBooking() {
        return returnBooking != null;
    }

    @JsonIgnore
    public RouteLegBookingDto getFirstLegBooking() {
        return Iterables.getFirst(legBookings, null);
    }

    @JsonIgnore
    public RouteLegBookingDto getLastLegBooking() {
        return Iterables.getLast(legBookings, null);
    }
}
