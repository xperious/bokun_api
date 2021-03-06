package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import is.bokun.dtos.ItemDto;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.dtos.carrental.CarTypeDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "carBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarBookingDetailsDto {

	@XmlElement(name="id")
	public Long bookingId;
	@XmlTransient
	public String title;
	public CarTypeDto carType;
	
	public int unitCount;
    public int dayCount;

	@XmlElementWrapper
	@XmlElement(name="answer")
	public List<BookingAnswerDto> answers = new ArrayList<>();
	
	@XmlElementWrapper(name = "extraBookings")
	@XmlElement(name="extraBooking")
	public List<ExtraBookingDetailsDto> extras = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="field")
    public List<BookingFieldDto> bookingFields = new ArrayList<>();

    @JsonIgnore
    public BookingAnswerDto getAnswer(String type) {
        for (BookingAnswerDto a : answers) {
            if( a.getType().equals(type) ) {
                return a;
            }
        }
        return null;
    }

    @JsonIgnore
    public Map<String,BookingAnswerDto> getAnswerInGroup(String group) {
        Map<String,BookingAnswerDto> map = new HashMap<>();
        for (BookingAnswerDto a : answers) {
            if ( a.getGroup().equals(group) ) {
                map.put(a.getType(), a);
            }
        }
        return map;
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

    public CarTypeDto getCarType() {
        return carType;
    }

    public void setCarType(CarTypeDto carType) {
        this.carType = carType;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public List<BookingAnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<BookingAnswerDto> answers) {
        this.answers = answers;
    }

    public List<ExtraBookingDetailsDto> getExtras() {
        return extras;
    }

    public void setExtras(List<ExtraBookingDetailsDto> extras) {
        this.extras = extras;
    }

    public List<BookingFieldDto> getBookingFields() {
        return bookingFields;
    }

    public void setBookingFields(List<BookingFieldDto> bookingFields) {
        this.bookingFields = bookingFields;
    }
}
