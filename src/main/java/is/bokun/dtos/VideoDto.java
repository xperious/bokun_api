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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getPreviewUrl() {
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
}
