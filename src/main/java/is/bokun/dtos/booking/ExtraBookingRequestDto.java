package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraBookingRequestDto {

	public Long extraId;
	public int unitCount;
	
	public List<BookingAnswerWithIdGroupDto> answers = new ArrayList<>();
	
	public ExtraBookingRequestDto() {}

	public Long getExtraId() {
		return extraId;
	}

	public void setExtraId(Long extraId) {
		this.extraId = extraId;
	}

	public int getUnitCount() {
		return unitCount;
	}

	public void setUnitCount(int unitCount) {
		this.unitCount = unitCount;
	}

	public List<BookingAnswerWithIdGroupDto> getAnswers() {
		return answers;
	}

	public void setAnswers(List<BookingAnswerWithIdGroupDto> answers) {
		this.answers = answers;
	}

}
