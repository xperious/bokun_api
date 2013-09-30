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
	
    public boolean dependent;
    public Long masterCategoryId;
    public int maxPerMaster;
    
    public boolean internalUseOnly;
    
    public Double pickupPrice;
    public Double dropoffPrice;

	public List<String> flags = new ArrayList<>();
	
	public boolean defaultCategory;
}
