package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingAnswerGroupDto {

	public String name;
	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
}
