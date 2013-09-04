package is.bokun.integrate;

import java.util.*;

public class AvailabilityDescription {

	private Date date;
	private Double price;
	
    private int availabilityCount;
    private boolean unlimitedAvailability;
    private boolean closed;
    
    private Map<String,String> fields = new HashMap<>();
    
    private List<PriceDescription> prices = new ArrayList<>();
    
    public AvailabilityDescription() {}
    
    public AvailabilityDescription(Date date, int availabilityCount, boolean unlimitedAvailability, boolean closed) {
    	this.date = date;
    	this.availabilityCount = availabilityCount;
    	this.unlimitedAvailability = unlimitedAvailability;
    	this.closed = closed;
    }
    
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getAvailabilityCount() {
		return availabilityCount;
	}
	public void setAvailabilityCount(int availabilityCount) {
		this.availabilityCount = availabilityCount;
	}
	public boolean isUnlimitedAvailability() {
		return unlimitedAvailability;
	}
	public void setUnlimitedAvailability(boolean unlimitedAvailability) {
		this.unlimitedAvailability = unlimitedAvailability;
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	public Map<String, String> getFields() {
		return fields;
	}
	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}
	public void setField(String name, String value) {
		this.fields.put(name, value);
	}

	public List<PriceDescription> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceDescription> prices) {
		this.prices = prices;
	}
	public void addPrice(PriceDescription pdesc) {
		this.prices.add(pdesc);
	}

}
