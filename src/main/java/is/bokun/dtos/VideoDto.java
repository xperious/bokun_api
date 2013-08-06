package is.bokun.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoDto {

	public Long id;
	public String sourceUrl;
	public String thumbnailUrl;
	public String previewUrl;
	public String html;
	public String providerName;
	
	public VideoDto() {}
}
