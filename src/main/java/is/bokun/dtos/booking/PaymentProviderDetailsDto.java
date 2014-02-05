package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PaymentProviderDetailsDto {

	public String url;
	
	@XmlElementWrapper
	@XmlElement(name="supportedMethod")
	public List<String> supportedMethods = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="paymentProviderParam")
	public List<PaymentProviderParam> parameters = new ArrayList<>();
	
	public PaymentProviderDetailsDto addParam(String name, String value) {
		parameters.add(new PaymentProviderParam(name, value));
		return this;
	}
	
	public PaymentProviderDetailsDto addParam(String name, int value) {
		parameters.add(new PaymentProviderParam(name, Integer.toString(value)));
		return this;
	}

    public PaymentProviderDetailsDto addParam(String name, double value) {
        parameters.add(new PaymentProviderParam(name, Double.toString(value)));
        return this;
    }
	
	public PaymentProviderDetailsDto addParam(String name, long value) {
		parameters.add(new PaymentProviderParam(name, Long.toString(value)));
		return this;
	}
	
	public static class PaymentProviderParam {
		
		public String name, value;
		
		public PaymentProviderParam() {}
		
		public PaymentProviderParam(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
}
