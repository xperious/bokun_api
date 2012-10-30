package dtos.booking;


public class BookingQuestionGroupDto extends BookingQuestionsDto {

	public String title;
	public String type;
	public Long entityId;
		
	public BookingQuestionGroupDto() {}
	
	public BookingQuestionGroupDto(String type, Long entityId) {
		this.type = type;
		this.entityId = entityId;
	}
	
}
