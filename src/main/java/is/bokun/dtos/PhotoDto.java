package is.bokun.dtos;

import java.util.*;


public class PhotoDto {

	public Long id;
    public String originalUrl;

	public List<DerivedPhotoDto> derived = new ArrayList<>();
	
	public PhotoDto() {}
}
