package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDto {
    public String id;
    public String addressLine1;
    public String addressLine2;
    public String addressLine3;
    public String city;
    public String state;
    public String postalCode;
    public String countryCode;
    public GeoPointDto geoPoint;
    public UnLocode unLocode;
}
