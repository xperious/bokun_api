package is.bokun.dtos;

import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;

public class PhotoDto {

	public Long id;
	
	@Property(optionality=Optionality.OPTIONAL)
	public String sourceUrl;
	
	@Property(optionality=Optionality.OPTIONAL)
	public String thumbnailUrl;
	
	@Property(optionality=Optionality.OPTIONAL)
	public String previewUrl;
	
	public PhotoDto() {}
}
