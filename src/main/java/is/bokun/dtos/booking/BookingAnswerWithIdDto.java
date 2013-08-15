package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
	
	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	
}
