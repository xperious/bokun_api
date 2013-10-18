package is.bokun.dtos;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "photo")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhotoDto {

	public Long id;
    public String originalUrl;
    
	public String description;
	public String alternateText;
	
	public List<String> flags = new ArrayList<>();

	public List<DerivedPhotoDto> derived = new ArrayList<>();
	
	public PhotoDto() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAlternateText() {
		return alternateText;
	}
	public void setAlternateText(String alternateText) {
		this.alternateText = alternateText;
	}
	public List<String> getFlags() {
		return flags;
	}
	public void setFlags(List<String> flags) {
		this.flags = flags;
	}
	public List<DerivedPhotoDto> getDerived() {
		return derived;
	}
	public void setDerived(List<DerivedPhotoDto> derived) {
		this.derived = derived;
	}
	@JsonIgnore
	public DerivedPhotoDto findDerived(String name) {
		for (DerivedPhotoDto d : derived) {
			if ( d.name.equals(name) ) {
				return d;
			}
		}
		return null;
	}
}
