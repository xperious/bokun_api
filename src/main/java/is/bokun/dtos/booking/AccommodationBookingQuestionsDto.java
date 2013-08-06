package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccommodationBookingQuestionsDto {

	public BookingItemInfoDto accommodation;
	public Long bookingId;
	public Date startDate, endDate;
	
	public List<BookingQuestionGroupDto> questionGroups = new ArrayList<>();
	
	public List<RoomBookingQuestionsDto> roomBookings = new ArrayList<>();

    @JsonIgnore
    public boolean hasQuestions() {
        for (BookingQuestionGroupDto g : questionGroups) {
            if ( !g.questions.isEmpty() ) {
                return true;
            }
        }

        for (RoomBookingQuestionsDto r : roomBookings) {
            if ( r.hasQuestions() ) {
                return true;
            }
        }

        return false;
    }
}
