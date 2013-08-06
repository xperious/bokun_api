package is.bokun.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AvailabilityInfoDto {

	public String day;
	public int availableCount;
	public int price;
}
