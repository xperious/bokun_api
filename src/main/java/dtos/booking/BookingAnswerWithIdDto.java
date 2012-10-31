package dtos.booking;

public class BookingAnswerWithIdDto extends BookingAnswerDto {

	public Long questionId;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	
}
