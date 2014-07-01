package is.bokun.dtos;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "derivedPhoto")
@XmlAccessorType(XmlAccessType.FIELD)
public class DerivedPhotoDto {

	public String name;
	public String url;

    public String getCleanUrl() {
        return StringUtils.isNullOrEmpty(url) ? url :  url.replace("http://", "//");
    }

    public String getUrl() {
        return url;
    }
}
