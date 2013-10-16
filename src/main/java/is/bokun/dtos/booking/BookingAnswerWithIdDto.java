package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "bookingAnswerWithId")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingAnswerWithIdDto extends BookingAnswerDto {

	public Long questionId;
	public List<String> flags = new ArrayList<>();

	public BookingAnswerWithIdDto() {}
	
	public BookingAnswerWithIdDto(String type, String answer) {
		this(null, type, answer);
	}
	
	public BookingAnswerWithIdDto(String group, String type, String answer) {
		this.group = group;
		this.type = type;
		this.answer = answer;
	}
	
	public BookingAnswerWithIdDto(String group, String type, String answer, String question) {
		this(group, type, answer);
		this.question = question;
	}
	
	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}
	
}
