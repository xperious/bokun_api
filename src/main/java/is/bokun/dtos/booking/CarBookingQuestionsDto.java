package is.bokun.dtos.booking;

import is.bokun.dtos.carrental.CarTypeInfoDto;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    public CarTypeInfoDto getCarType() {
        return carType;
    }

    public void setCarType(CarTypeInfoDto carType) {
        this.carType = carType;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
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
