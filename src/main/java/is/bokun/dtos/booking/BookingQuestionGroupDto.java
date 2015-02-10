package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingQuestionGroupDto {

	public String name;
	public int answersNeeded;
	public List<BookingQuestionDto> questions = new ArrayList<>();

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

	public List<BookingQuestionDto> getQuestions() {
		return questions;
	}

	public void setQuestions(List<BookingQuestionDto> questions) {
		this.questions = questions;
	}
}
