package is.bokun.dtos;

import is.bokun.dtos.QuestionDto;
import is.bokun.dtos.booking.BookingAnswerWithIdDto;

/**
 * Created by kristinfjola on 11.6.2014.
 */
public class QuestionAnswerPairDto {

    public BookingAnswerWithIdDto answer;
    public QuestionDto question;

    public QuestionAnswerPairDto(QuestionDto question, BookingAnswerWithIdDto answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getAnswerAsString() {
        return answer == null ? "" : answer.getAnswer();
    }

    public String getQuestionAsString() { return answer == null? "" : answer.getQuestion(); }

}
