package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    public String getFullTitle() {
        StringBuilder s = new StringBuilder();
        s.append(title);
        if ( ageQualified ) {
            s.append(" ");
            s.append(getAgeIntervalStr());
        }
        return s.toString();
    }

    @JsonIgnore
    public String getAgeIntervalStr() {
        if ( ageQualified ) {
            return "(" + (minAge != null ? minAge.toString() : "0") + (maxAge != null && maxAge > 0 ?  " - " + maxAge.toString() : "+") + ")";
        } else {
            return "";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAgeQualified() {
        return ageQualified;
    }

    public void setAgeQualified(boolean ageQualified) {
        this.ageQualified = ageQualified;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public boolean isDependent() {
        return dependent;
    }

    public void setDependent(boolean dependent) {
        this.dependent = dependent;
    }

    public Long getMasterCategoryId() {
        return masterCategoryId;
    }

    public void setMasterCategoryId(Long masterCategoryId) {
        this.masterCategoryId = masterCategoryId;
    }

    public int getMaxPerMaster() {
        return maxPerMaster;
    }

    public void setMaxPerMaster(int maxPerMaster) {
        this.maxPerMaster = maxPerMaster;
    }

    public boolean isSumDependentCategories() {
        return sumDependentCategories;
    }

    public void setSumDependentCategories(boolean sumDependentCategories) {
        this.sumDependentCategories = sumDependentCategories;
    }

    public int getMaxDependentSum() {
        return maxDependentSum;
    }

    public void setMaxDependentSum(int maxDependentSum) {
        this.maxDependentSum = maxDependentSum;
    }

    public boolean isInternalUseOnly() {
        return internalUseOnly;
    }

    public void setInternalUseOnly(boolean internalUseOnly) {
        this.internalUseOnly = internalUseOnly;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public boolean isDefaultCategory() {
        return defaultCategory;
    }

    public void setDefaultCategory(boolean defaultCategory) {
        this.defaultCategory = defaultCategory;
    }

}
