package is.bokun.dtos.booking;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import is.bokun.dtos.NameValuePairDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingQuestionDto {

	public String type;
	
	public String question;
	public boolean selectFromOptions;
	public String defaultAnswer;
	public boolean answerRequired;
	
	public List<String> options = new ArrayList<String>();
	
	@JsonIgnore
	public boolean isOfType(String t) {
		return t.equals(type);
	}
	
	@JsonIgnore
	public String getQuestionType() {
		return type;
	}

    @JsonIgnore
    public List<NameValuePairDto> getOptionsAsNameValuePairs() {
        List<NameValuePairDto> list = new ArrayList<>();
        for (String o : options) {
            if ( o.contains(";") ) {
                String[] pair = o.split(";");
                list.add(new NameValuePairDto(pair[1], pair[0]));
            } else {
                list.add(new NameValuePairDto(o, o));
            }
        }
        return list;
    }
	
	public Long getId() {
		return null;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isSelectFromOptions() {
		return selectFromOptions;
	}

	public void setSelectFromOptions(boolean selectFromOptions) {
		this.selectFromOptions = selectFromOptions;
	}

	public String getDefaultAnswer() {
		return defaultAnswer;
	}

	public void setDefaultAnswer(String defaultAnswer) {
		this.defaultAnswer = defaultAnswer;
	}

	public boolean isAnswerRequired() {
		return answerRequired;
	}

	public void setAnswerRequired(boolean answerRequired) {
		this.answerRequired = answerRequired;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}
}
