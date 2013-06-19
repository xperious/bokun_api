package is.bokun.dtos.booking;

public class BookingAnswerDto {

	public String type;
	public String question;
	public String answer;
	public String group;
	
	public BookingAnswerDto() {}
	
	public BookingAnswerDto(String type, String answer) {
		this(null, type, answer);
	}
	
	public BookingAnswerDto(String group, String type, String answer) {
		this.group = group;
		this.type = type;
		this.answer = answer;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
