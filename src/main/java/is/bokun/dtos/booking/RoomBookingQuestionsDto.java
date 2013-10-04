package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomBookingQuestionsDto {

	public BookingItemInfoDto roomType;
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
