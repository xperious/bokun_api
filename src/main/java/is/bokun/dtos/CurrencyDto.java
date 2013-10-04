package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto {

	public Long id;
	public boolean base;
    public String code;
    
    public Double rate;
    
    public String sign;
    
    public CurrencyDto() {}
}
