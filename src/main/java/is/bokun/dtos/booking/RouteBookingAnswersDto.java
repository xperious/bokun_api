package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 14.10.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteBookingAnswersDto {

    public Long bookingId;

    public List<BookingAnswerGroupDto> answerGroups = new ArrayList<BookingAnswerGroupDto>();

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public List<BookingAnswerGroupDto> getAnswerGroups() {
        return answerGroups;
    }

    public void setAnswerGroups(List<BookingAnswerGroupDto> answerGroups) {
        this.answerGroups = answerGroups;
    }
}
