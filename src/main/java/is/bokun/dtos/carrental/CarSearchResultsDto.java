package is.bokun.dtos.carrental;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import is.bokun.dtos.search.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarSearchResultsDto extends AbstractSearchResultsDto {

	public List<CarTypeDto> items = new ArrayList<>();
}
