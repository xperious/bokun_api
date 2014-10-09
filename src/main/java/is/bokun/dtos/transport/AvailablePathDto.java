package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Iterables;
import org.joda.time.Duration;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ogg on 17/7/14.
 */
public class AvailablePathDto {

    public List<AvailableLegDto> legs = new ArrayList<>();

    @JsonIgnore
    public AvailableLegDto getFirst() {
        return Iterables.getFirst(legs, null);
    }

    @JsonIgnore
    public AvailableLegDto getLast() {
        return Iterables.getLast(legs, null);
    }

    @JsonIgnore
    public RouteStationDto getSourceStation() {
        AvailableLegDto leg = Iterables.getFirst(legs, null);
        return leg != null ? leg.leg.from : null;
    }

    @JsonIgnore
    public RouteStationDto getDestinationStation() {
        AvailableLegDto leg = Iterables.getLast(legs, null);
        return leg != null ? leg.leg.to : null;
    }

    @JsonIgnore
    public List<RouteDto> getRoutes() {
        List<RouteDto> routes = new ArrayList<>();
        for (AvailableLegDto avLeg : legs) {
            if ( !routes.contains(avLeg.route) ) {
                routes.add(avLeg.route);
            }
        }
        return routes;
    }

    @JsonIgnore
    public long getDuration(TimeUnit timeUnit) {
        Duration d = new Duration(0);
        for (int i = 0; i < legs.size(); i++) {
            RouteScheduleDto current = legs.get(i).departure.getSchedule();
            d = d.plus(getDifference(current.getDepartureTime(), current.getArrivalTime()));
            if ( i < legs.size()-1 ) {
                RouteScheduleDto next = legs.get(i+1).departure.getSchedule();
                d = d.plus(getDifference(current.getArrivalTime(), next.getDepartureTime()));
            }
        }
        return timeUnit.convert(d.getMillis(), TimeUnit.MILLISECONDS);
    }

    @JsonIgnore
    public static Duration getDifference(LocalTime departure, LocalTime arrival) {
        if ( departure.isAfter(arrival) ) {
            return Minutes.minutesBetween(departure, new LocalTime(23, 59)).plus(1).plus(Minutes.minutesBetween(LocalTime.MIDNIGHT, arrival)).toStandardDuration();
        } else {
            return Minutes.minutesBetween(departure, arrival).toStandardDuration();
        }
    }

    @JsonIgnore
    public int getStops() {
        return legs.size() - 1;
    }
}
