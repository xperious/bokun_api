package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "pricingCategory")
@XmlAccessorType(XmlAccessType.FIELD)
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

    public boolean sumDependentCategories;
    public int maxDependentSum;
    
    public boolean internalUseOnly;

	public List<String> flags = new ArrayList<>();
	
	public boolean defaultCategory;
}
