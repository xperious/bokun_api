package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingAnswerGroupDto {

	public String name;
	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
}
