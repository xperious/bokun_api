package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "bookingItemInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingItemInfoDto {

	public Long id;
	public String title;
    public Double price;

    @XmlElementWrapper
    @XmlElement(name="flag")
    public List<String> flags = new ArrayList<>();
	
	public BookingItemInfoDto() {}
	
	public BookingItemInfoDto(Long id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public BookingItemInfoDto(Long id, String title, List<String> flags) {
		this.id = id;
		this.title = title;
        this.flags = flags;
	}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

	public List<String> getFlags() {
		return flags;
	}
}
