package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AvailabilityInfoDto {

	public String day;
	public int availableCount;
	public Double price;

    public Double getPrice() {
        return price;
    }
}
