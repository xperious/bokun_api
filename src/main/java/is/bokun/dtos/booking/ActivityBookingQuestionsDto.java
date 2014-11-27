package is.bokun.dtos.booking;

import is.bokun.dtos.PickupPlaceDto;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityBookingQuestionsDto {

	public BookingItemInfoDto activity;
	public Long bookingId;
	public Date date;
	public String time;
	
	public boolean askWhereToPickup;
	public List<PickupPlaceDto> pickupPlaces = new ArrayList<>();
    public boolean customPickupAllowed;
	public boolean askWhereToDropoff;
	public List<PickupPlaceDto> dropoffPlaces = new ArrayList<>();
    public boolean customDropoffAllowed;

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
