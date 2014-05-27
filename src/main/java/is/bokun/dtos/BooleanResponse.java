package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BooleanResponse {

	public boolean result;
	
	public BooleanResponse() {}
	
	public BooleanResponse(boolean result) {
		this.result = result;
	}

    public void setResult(boolean result) {
        this.result = result;
    }
}
