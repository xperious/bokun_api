package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "Question")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionDto {

    public Long id;

    public boolean active = true;
    public String label;

    public String type;

    public String options;
    
    public boolean answerRequired;

    public QuestionDto() {}

    public QuestionDto(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    @XmlElementWrapper
    @XmlElement(name="flag")
    public List<String> flags = new ArrayList<>();
}
