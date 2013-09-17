package is.bokun.dtos;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "derivedPhoto")
@XmlAccessorType(XmlAccessType.FIELD)
public class DerivedPhotoDto {

	public String name;
	public String url;
}
