package is.bokun.dtos.booking;

import is.bokun.dtos.carrental.CarTypeInfoDto;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class CarBookingQuestionsDto {

	public CarTypeInfoDto carType;
	public Long bookingId;
	public int unitCount;
	
	public List<BookingQuestionGroupDto> questionGroups = new ArrayList<>();
	public List<ExtraBookingQuestionsDto> extraBookings = new ArrayList<>();

    @JsonIgnore
    public boolean hasQuestions() {
        for (BookingQuestionGroupDto g : questionGroups) {
            if ( !g.questions.isEmpty() ) {
                return true;
            }
        }
        for (ExtraBookingQuestionsDto e : extraBookings) {
            if ( e.hasQuestions() ) {
                return true;
            }
        }
        return false;
    }
}
