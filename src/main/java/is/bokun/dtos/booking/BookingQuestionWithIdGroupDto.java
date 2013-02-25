package is.bokun.dtos.booking;

import java.util.*;

public class BookingQuestionWithIdGroupDto {

	public String name;
	public int answersNeeded;
	public List<BookingQuestionWithIdDto> questions = new ArrayList<BookingQuestionWithIdDto>();
}
