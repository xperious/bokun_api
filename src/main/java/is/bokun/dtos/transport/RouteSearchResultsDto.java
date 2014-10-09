package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.dtos.search.AbstractSearchResultsDto;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteSearchResultsDto extends AbstractSearchResultsDto {

    public List<RouteDto> routes = new ArrayList<>();
}
