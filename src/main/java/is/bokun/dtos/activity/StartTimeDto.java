package is.bokun.dtos.activity;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StartTimeDto {

	public Long id;
	
	public int hour = 12;
	public int minute;
	
    public String durationType;
    public int duration = 1;
    
    public StartTimeDto() {}
    
    @JsonIgnore
    public String getTimeAsString() {
        StringBuilder s = new StringBuilder();
        if ( hour < 10 ) {
            s.append(0);
        }
        s.append(hour);
        s.append(':');
        if ( minute < 10 ) {
            s.append(0);
        }
        s.append(minute);
        return s.toString();
    }

}
