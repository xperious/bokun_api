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
    public Double price;
    public boolean free;

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

    public BookableExtraDto(String externalId, List<String> flags) {
        this.externalId = externalId;
        this.flags = flags;
    }

    public BookableExtraDto(Long id, String title, List<String> flags) {
        this.id = id;
        this.title = title;
        this.flags = flags;
    }

    @JsonIgnore
    public double price() {
        return price != null ? price : 0;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public boolean isIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public String getPricingType() {
        return pricingType;
    }

    public void setPricingType(String pricingType) {
        this.pricingType = pricingType;
    }

    public String getPricingTypeLabel() {
        return pricingTypeLabel;
    }

    public void setPricingTypeLabel(String pricingTypeLabel) {
        this.pricingTypeLabel = pricingTypeLabel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getMaxPerBooking() {
        return maxPerBooking;
    }

    public void setMaxPerBooking(int maxPerBooking) {
        this.maxPerBooking = maxPerBooking;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
