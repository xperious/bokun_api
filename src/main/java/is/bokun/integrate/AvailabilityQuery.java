package is.bokun.integrate;

import is.bokun.dtos.ProductCategoryEnum;

import java.util.Date;

public class AvailabilityQuery {

	private Date start, end;
	private Date lastRetrieved;
	private String productId;
	private ProductCategoryEnum category;
	private String currency;
	
	public AvailabilityQuery() {}
	
	public AvailabilityQuery(String productId, ProductCategoryEnum category, Date start, Date end, String currency, Date lastRetrieved) {
		this.productId = productId;
		this.category = category;
		this.start = start;
		this.end = end;
		this.currency = currency;
		this.lastRetrieved = lastRetrieved;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public ProductCategoryEnum getCategory() {
		return category;
	}

	public void setCategory(ProductCategoryEnum category) {
		this.category = category;
	}

	public Date getLastRetrieved() {
		return lastRetrieved;
	}

	public void setLastRetrieved(Date lastRetrieved) {
		this.lastRetrieved = lastRetrieved;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
