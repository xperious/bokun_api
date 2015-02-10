package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.*;

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

    public BookingItemInfoDto getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(BookingItemInfoDto accommodation) {
        this.accommodation = accommodation;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<BookingQuestionGroupDto> getQuestionGroups() {
        return questionGroups;
    }

    public void setQuestionGroups(List<BookingQuestionGroupDto> questionGroups) {
        this.questionGroups = questionGroups;
    }

    public List<RoomBookingQuestionsDto> getRoomBookings() {
        return roomBookings;
    }

    public void setRoomBookings(List<RoomBookingQuestionsDto> roomBookings) {
        this.roomBookings = roomBookings;
    }
}
