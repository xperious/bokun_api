package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingQuestionWithIdDto extends BookingQuestionDto {

	public Long id;

	@Override
	public Long getId() {
		return id;
	}
	
}
