package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.*;

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

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public BookingItemInfoDto getExtra() {
        return extra;
    }

    public void setExtra(BookingItemInfoDto extra) {
        this.extra = extra;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }

    public List<BookingQuestionWithIdGroupDto> getQuestionGroups() {
        return questionGroups;
    }

    public void setQuestionGroups(List<BookingQuestionWithIdGroupDto> questionGroups) {
        this.questionGroups = questionGroups;
    }
}
