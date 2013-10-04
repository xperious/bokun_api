package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingQuestionWithIdGroupDto {

	public String name;
	public int answersNeeded;
	public List<BookingQuestionWithIdDto> questions = new ArrayList<BookingQuestionWithIdDto>();
}
