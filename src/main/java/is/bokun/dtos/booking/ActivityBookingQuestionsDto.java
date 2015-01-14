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

    public BookingItemInfoDto getActivity() {
        return activity;
    }

    public void setActivity(BookingItemInfoDto activity) {
        this.activity = activity;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isAskWhereToPickup() {
        return askWhereToPickup;
    }

    public void setAskWhereToPickup(boolean askWhereToPickup) {
        this.askWhereToPickup = askWhereToPickup;
    }

    public List<PickupPlaceDto> getPickupPlaces() {
        return pickupPlaces;
    }

    public void setPickupPlaces(List<PickupPlaceDto> pickupPlaces) {
        this.pickupPlaces = pickupPlaces;
    }

    public boolean isCustomPickupAllowed() {
        return customPickupAllowed;
    }

    public void setCustomPickupAllowed(boolean customPickupAllowed) {
        this.customPickupAllowed = customPickupAllowed;
    }

    public boolean isAskWhereToDropoff() {
        return askWhereToDropoff;
    }

    public void setAskWhereToDropoff(boolean askWhereToDropoff) {
        this.askWhereToDropoff = askWhereToDropoff;
    }

    public List<PickupPlaceDto> getDropoffPlaces() {
        return dropoffPlaces;
    }

    public void setDropoffPlaces(List<PickupPlaceDto> dropoffPlaces) {
        this.dropoffPlaces = dropoffPlaces;
    }

    public boolean isCustomDropoffAllowed() {
        return customDropoffAllowed;
    }

    public void setCustomDropoffAllowed(boolean customDropoffAllowed) {
        this.customDropoffAllowed = customDropoffAllowed;
    }

    public List<BookingQuestionGroupDto> getQuestionGroups() {
        return questionGroups;
    }

    public void setQuestionGroups(List<BookingQuestionGroupDto> questionGroups) {
        this.questionGroups = questionGroups;
    }

    public List<ExtraBookingQuestionsDto> getExtraBookings() {
        return extraBookings;
    }

    public void setExtraBookings(List<ExtraBookingQuestionsDto> extraBookings) {
        this.extraBookings = extraBookings;
    }
}
