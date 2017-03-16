package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "locationCode")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationCodeDto {
    public String coordinates;
    public String country;
    public Integer date;
    public String function;
    public String iata;
    public Long id;
    public String location;
    public String name;
    public String nameWoDiacritics;
    public String recentChange;
    public String remarks;
    public String status;
    public String subdivision;
}
