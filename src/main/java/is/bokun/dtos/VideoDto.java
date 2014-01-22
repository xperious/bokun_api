package is.bokun.dtos;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "video")
@XmlAccessorType(XmlAccessType.FIELD)
public class VideoDto {

	public Long id;
	public String sourceUrl;
	public String thumbnailUrl;
	public String previewUrl;
	public String html;
	public String providerName;
	
	public VideoDto() {}

    public String getCleanThumbnailUrl() {
        return StringUtils.isNullOrEmpty(thumbnailUrl) ? thumbnailUrl : thumbnailUrl.replace("http://", "//");
    }

    public String getCleanPreviewUrl() {
        return StringUtils.isNullOrEmpty(previewUrl) ? previewUrl : previewUrl.replace("http://", "//");
    }
}
