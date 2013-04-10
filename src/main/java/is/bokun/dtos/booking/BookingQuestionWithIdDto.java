package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingQuestionWithIdDto extends BookingQuestionDto {

	public Long id;

	@Override
	public Long getId() {
		return id;
	}
	
}
