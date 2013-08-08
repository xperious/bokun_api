package is.bokun.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BooleanResponse {

	public boolean result;
	
	public BooleanResponse() {}
	
	public BooleanResponse(boolean result) {
		this.result = result;
	}

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
