package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import is.bokun.dtos.BookableExtraDto;
import is.bokun.dtos.ItemDto;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "extraBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtraBookingDetailsDto {

	@XmlElement(name="id")
	public Long bookingId;
	@XmlTransient
	public String title;

    public BookableExtraDto extra;
	
	public int unitCount;

	@XmlElementWrapper
	@XmlElement(name="answer")
	public List<BookingAnswerWithIdDto> answers = new ArrayList<>();
	
	public ExtraBookingDetailsDto() {}

    public BookableExtraDto getBookableExtra() {
        return extra;
    }

    public ExtraBookingDetailsDto(Long bookingId, int unitCount, BookableExtraDto extra) {
		this.bookingId = bookingId;
		this.unitCount = unitCount;
		this.extra = extra;
		if ( extra != null ) {
			this.title = extra.title;
		}
	}

    @JsonIgnore
    public List<BookingAnswerGroupDto> getGroupedAnswers() {
        Map<String,BookingAnswerGroupDto> map = new TreeMap<>();
        for (BookingAnswerWithIdDto ba : answers) {
            BookingAnswerGroupDto grp = !StringUtils.isNullOrEmpty(ba.getGroup()) ? map.get(ba.getGroup()) : null;
            if ( grp == null ) {
                grp = new BookingAnswerGroupDto();
                grp.group = ba.getGroup();
                map.put(ba.getGroup(), grp);
            }

            grp.addPair(getBookableExtra().findQuestion(ba.getQuestionId()), ba);
        }
        return new ArrayList<>(map.values());
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookableExtraDto getExtra() {
        return extra;
    }

    public void setExtra(BookableExtraDto extra) {
        this.extra = extra;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }

    public List<BookingAnswerWithIdDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<BookingAnswerWithIdDto> answers) {
        this.answers = answers;
    }
}
