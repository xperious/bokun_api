package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "unLocode")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnLocode {
    public String country;
    public String city;
}
