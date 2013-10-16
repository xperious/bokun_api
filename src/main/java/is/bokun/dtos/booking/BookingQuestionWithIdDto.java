package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingQuestionWithIdDto extends BookingQuestionDto {

	public Long id;
	
	public List<String> flags = new ArrayList<>();

	@Override
	public Long getId() {
		return id;
	}
	
}
