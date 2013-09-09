package is.bokun.dtos;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PricingCategoryDto {

	public Long id;
	public String title;

	public int index;
	
	public boolean ageQualified;
	public Integer minAge;
	public Integer maxAge;

	public List<String> flags = new ArrayList<>();
	
	public boolean defaultCategory;
}
