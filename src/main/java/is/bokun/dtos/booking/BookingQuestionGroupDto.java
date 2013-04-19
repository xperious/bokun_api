package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingQuestionGroupDto {

	public String name;
	public int answersNeeded;
	public List<BookingQuestionDto> questions = new ArrayList<>();

}
