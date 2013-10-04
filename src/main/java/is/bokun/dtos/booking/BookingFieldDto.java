package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "bookingField")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingFieldDto {

	public String name, value;
	
	public BookingFieldDto() {}
	
	public BookingFieldDto(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@JsonIgnore
	public static List<BookingFieldDto> toList(Map<String,String> map) {
		List<BookingFieldDto> list = new ArrayList<>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			list.add(new BookingFieldDto(entry.getKey(), entry.getValue()));
		}
		return list;
	}
}
