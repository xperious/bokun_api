package is.bokun.integrate;

public class PriceDescription {

	private String title;
	private boolean ageQualified;
	private Integer minAge;
	private Integer maxAge;
	
	private Double price;
	
	public PriceDescription() {}
	
	public PriceDescription(Integer minAge, Integer maxAge, Double price) {
		this.ageQualified = true;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.price = price;
	}
	
	public PriceDescription(String title, Double price) {
		this.ageQualified = false;
		this.price = price;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
