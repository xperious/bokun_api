package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 25.9.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteBookingQuestionsDto {

    public RouteBookingDto booking;

    public List<BookingQuestionGroupDto> questionGroups = new ArrayList<>();

    @JsonIgnore
    public boolean hasQuestions() {
        for (BookingQuestionGroupDto g : questionGroups) {
            if ( !g.questions.isEmpty() ) {
                return true;
            }
        }
        return false;
    }
}
