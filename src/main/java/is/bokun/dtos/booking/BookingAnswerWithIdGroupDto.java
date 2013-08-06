package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingAnswerWithIdGroupDto {

	public String name;
	public List<BookingAnswerWithIdDto> answers = new ArrayList<BookingAnswerWithIdDto>();
}
