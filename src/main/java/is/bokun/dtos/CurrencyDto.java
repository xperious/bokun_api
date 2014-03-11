package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto {

	public boolean payment;
    public String code;
    
    public Double rate;
    
    public CurrencyDto() {}
}
