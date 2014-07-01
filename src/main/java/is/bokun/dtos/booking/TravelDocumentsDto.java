package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.NameValuePairDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "TravelDocuments")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TravelDocumentsDto {

    public TravelDocumentDto orderSummary;
    public List<TravelDocumentDto> tickets = new ArrayList<>();
}
