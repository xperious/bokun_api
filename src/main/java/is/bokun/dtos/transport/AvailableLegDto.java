package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by ogg on 16/8/14.
 */
public class AvailableLegDto {

    public RouteDto route;
    public RouteLegDto leg;
    public AvailableScheduleDto departure;

    @JsonIgnore
    public long getDuration(TimeUnit timeUnit) {
        Duration d = new Duration(0);
        d = d.plus(AvailablePathDto.getDifference(departure.schedule.getDepartureTime(), departure.schedule.getArrivalTime()));
        return timeUnit.convert(d.getMillis(), TimeUnit.MILLISECONDS);
    }
}
