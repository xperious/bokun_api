package is.bokun.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto {

    public Long id;

    public boolean active = true;
    public String label;

    public String type;

    public String options;
    
    public boolean answerRequired;
}
