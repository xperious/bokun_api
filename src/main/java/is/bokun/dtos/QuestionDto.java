package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto {

    public Long id;

    public boolean active = true;
    public String label;

    public String type;

    public String options;
    
    public boolean answerRequired;
    
    public List<String> flags = new ArrayList<>();
}
