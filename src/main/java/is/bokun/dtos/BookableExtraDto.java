package is.bokun.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "BookableExtra")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookableExtraDto {

    public Long id;
    public String externalId;
    public String title;
    public String information;
    public boolean included;

    public String pricingType;
    public String pricingTypeLabel;
    public Integer price;

    public int maxPerBooking;

    @XmlElementWrapper
    @XmlElement(name="flag")
    public List<String> flags = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="question")
    public List<QuestionDto> questions = new ArrayList<>();

    public BookableExtraDto(){}

    public BookableExtraDto(Long id, String title, String externalId) {
        this.id = id;
        this.title = title;
        this.externalId = externalId;
        this.flags = null;
    }

    public BookableExtraDto(Long id, String title, String externalId, List<String> flags) {
        this.id = id;
        this.title = title;
        this.externalId = externalId;
        this.flags = flags;
    }

    public BookableExtraDto(Long id, String title, List<String> flags) {
        this.id = id;
        this.title = title;
        this.flags = flags;
    }

    @JsonIgnore
    public int price() {
        return price != null ? price.intValue() : 0;
    }
    
    @JsonIgnore
    public static List<BookableExtraDto> filterNotHidden(List<BookableExtraDto> list) {
    	List<BookableExtraDto> filtered = new ArrayList<>();
    	for (BookableExtraDto e : list) {
    		if ( !e.flags.contains("widget-hidden") ) {
    			filtered.add(e);
    		}
    	}
    	return filtered;
    }

    @JsonIgnore
    public QuestionDto findQuestion(Long qid) {
        for ( QuestionDto q : questions ) {
            if ( q.id.equals(qid) ) {
                return q;
            }
        }
        return null;
    }


}
