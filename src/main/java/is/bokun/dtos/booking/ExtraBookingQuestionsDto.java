package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraBookingQuestionsDto {

	public Long bookingId;
	public BookingItemInfoDto extra;
	public int unitCount;
	
	public List<BookingQuestionWithIdGroupDto> questionGroups = new ArrayList<>();

    @JsonIgnore
    public boolean hasQuestions() {
        for (BookingQuestionWithIdGroupDto g : questionGroups) {
            if ( !g.questions.isEmpty() ) {
                return true;
            }
        }
        return false;
    }
	
}
