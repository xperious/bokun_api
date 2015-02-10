package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingQuestionWithIdGroupDto {

	public String name;
	public int answersNeeded;
	public List<BookingQuestionWithIdDto> questions = new ArrayList<BookingQuestionWithIdDto>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAnswersNeeded() {
		return answersNeeded;
	}

	public void setAnswersNeeded(int answersNeeded) {
		this.answersNeeded = answersNeeded;
	}

	public List<BookingQuestionWithIdDto> getQuestions() {
		return questions;
	}

	public void setQuestions(List<BookingQuestionWithIdDto> questions) {
		this.questions = questions;
	}
}
