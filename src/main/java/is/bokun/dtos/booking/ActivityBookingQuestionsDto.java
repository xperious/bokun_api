package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.*;

public class ActivityBookingQuestionsDto {

	public BookingItemInfoDto activity;
	public Long bookingId;
	public Date date;
	public String time;
	
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
