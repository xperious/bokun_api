package is.bokun.dtos.booking;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "bookingAnswerWithId")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingAnswerWithIdDto extends BookingAnswerDto {

	public Long questionId;

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
	
}
