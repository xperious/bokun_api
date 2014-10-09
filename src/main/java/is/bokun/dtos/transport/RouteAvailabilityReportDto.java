package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.queries.TransportQuery;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteAvailabilityReportDto {

    public LocalDate departureDate, returnDate;
    public RouteStationDto from, to;

    public TransportQuery query;

    public List<AvailableDepartureReturnPathPairDto> results = new ArrayList<>();

    public static enum RouteResultsType {
        MULTIPLE_ROUTES, SINGLE_ROUTE, SINGLE_ROUTE_FLEX
    }
}
