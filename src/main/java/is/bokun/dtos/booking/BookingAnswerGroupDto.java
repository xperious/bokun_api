package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.dtos.QuestionDto;
import is.bokun.dtos.QuestionAnswerPairDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingAnswerGroupDto {

	public String name;
    public String group;
	public List<BookingAnswerDto> answers = new ArrayList<>();
    private List<QuestionAnswerPairDto> questionsAndAnswers = new ArrayList<>();

    public void addPair(QuestionDto q, BookingAnswerWithIdDto a) {
        questionsAndAnswers.add(new QuestionAnswerPairDto(q, a));
    }

    public List<QuestionAnswerPairDto> getQandA() {
        return questionsAndAnswers;
    }
}
