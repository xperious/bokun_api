package dtos.booking;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class BookingQuestionDto {

	public String type;
	
	public String question;
	public boolean selectFromOptions;
	public String defaultAnswer;
	public int answersNeeded = 1;
	
	public List<String> options = new ArrayList<String>();
	
	@JsonIgnore
	public boolean isOfType(String t) {
		return t.equals(type);
	}
	
	@JsonIgnore
	public String getQuestionType() {
		return type;
	}
}
