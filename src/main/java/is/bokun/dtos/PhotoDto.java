package is.bokun.dtos;

import java.util.*;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoDto {

	public Long id;
    public String originalUrl;

	public List<DerivedPhotoDto> derived = new ArrayList<>();
	
	public PhotoDto() {}
	
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
