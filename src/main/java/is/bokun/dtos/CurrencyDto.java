package is.bokun.dtos;

import com.codiform.moo.annotation.*;

public class CurrencyDto {

	public Long id;
	public boolean base;
    public String code;
    
    @Property(optionality = Optionality.OPTIONAL)
    public Double rate;
    
    @Property(translation = "sign()")
    public String sign;
    
    public CurrencyDto() {}
}
