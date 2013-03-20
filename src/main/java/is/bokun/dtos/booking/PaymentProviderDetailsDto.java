package is.bokun.dtos.booking;

import java.util.*;

public class PaymentProviderDetailsDto {

	public String url;
	public List<String> supportedMethods = new ArrayList<>();
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
