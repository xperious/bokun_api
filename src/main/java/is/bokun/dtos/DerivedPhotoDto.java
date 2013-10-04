package is.bokun.dtos;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "derivedPhoto")
@XmlAccessorType(XmlAccessType.FIELD)
public class DerivedPhotoDto {

	public String name;
	public String url;
}
