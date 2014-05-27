package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "PriceSheetDateRange")
@XmlAccessorType(XmlAccessType.FIELD)
public class PriceSheetDateRangeDto {

    public Long id;
    public Date start;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

/*
    @JsonIgnore
    public boolean matches(Date d) {
        return (getStart() == null || d.getTime() >= getStart().getTime())
                && (getEnd() == null || d.getTime() < getEnd().getTime());
    }
    */
}
