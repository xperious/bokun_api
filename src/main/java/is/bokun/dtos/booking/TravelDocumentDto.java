package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "TravelDocument")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TravelDocumentDto {

    public String name;
    public String html;
    public String base64Html;

    public TravelDocumentDto() {}

    public TravelDocumentDto(String name, String html, String base64Html) {
        this.name = name;
        this.html = html;
        this.base64Html = base64Html;
    }
}
