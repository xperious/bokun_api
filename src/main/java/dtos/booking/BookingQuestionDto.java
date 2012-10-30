package dtos.booking;

import java.util.*;

public class BookingQuestionDto {

	public String type;
	
	public String question;
	public boolean selectFromOptions;
	public String defaultAnswer;
	public int answersNeeded = 1;
	
	public List<String> options = new ArrayList<String>();
}
