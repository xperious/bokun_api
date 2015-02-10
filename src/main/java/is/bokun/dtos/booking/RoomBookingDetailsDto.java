package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import is.bokun.dtos.ItemDto;

import java.util.*;
import java.util.function.Function;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "roomBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomBookingDetailsDto {

	@XmlElement(name="id")
	public Long bookingId;
	@XmlTransient
	public String title;
	public ItemDto roomType;
	
    public int nightCount;
	
	@XmlElementWrapper
	@XmlElement(name="answer")
	public List<BookingAnswerDto> answers = new ArrayList<>();
	
	@XmlElementWrapper(name = "extraBookings")
	@XmlElement(name="extraBooking")
	public List<ExtraBookingDetailsDto> extras = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="field")
    public List<BookingFieldDto> bookingFields = new ArrayList<>();

    public List<AccommodationAvailabilityBookingDto> availabilityBookings = new ArrayList<>();

    @JsonIgnore
    public BookingAnswerDto getAnswer(String type) {
        return answers.stream().filter(a -> a.getType().equals(type)).findFirst().orElse(null);
    }

    @JsonIgnore
    public Map<String,BookingAnswerDto> getAnswerInGroup(String group) {
        return answers.stream().filter(a -> a.getGroup().equals(group)).collect(toMap(BookingAnswerDto::getType, Function.<BookingAnswerDto>identity()));
    }

    @JsonIgnore
    public List<BookingAnswerDto> getAnswers(String type){
        return answers.stream().filter(a -> a.getType().equals(type)).collect(toList());
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

    public ItemDto getRoomType() {
        return roomType;
    }

    public void setRoomType(ItemDto roomType) {
        this.roomType = roomType;
    }

    public int getNightCount() {
        return nightCount;
    }

    public void setNightCount(int nightCount) {
        this.nightCount = nightCount;
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

    public List<AccommodationAvailabilityBookingDto> getAvailabilityBookings() {
        return availabilityBookings;
    }

    public void setAvailabilityBookings(List<AccommodationAvailabilityBookingDto> availabilityBookings) {
        this.availabilityBookings = availabilityBookings;
    }

}
