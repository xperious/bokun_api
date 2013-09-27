package is.bokun.dtos;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.*;

import is.bokun.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "location")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationDto {

	public String address;
	public String city;
	public String countryCode;
	public String postCode;

	public double latitude = 64.923542;
	public double longitude = -19.511719;
	
	public int zoomLevel = 6;
	
	public LocationDto() {}
	
	
	
	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountryCode() {
		return countryCode;
	}



	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}



	public String getPostCode() {
		return postCode;
	}



	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}



	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public int getZoomLevel() {
		return zoomLevel;
	}



	public void setZoomLevel(int zoomLevel) {
		this.zoomLevel = zoomLevel;
	}



	@JsonIgnore
	public String wholeAddress() {
		StringBuilder s = new StringBuilder();
		if ( !StringUtils.isNullOrEmpty(address) ) {
			s.append(address);
		}
		if ( !StringUtils.isNullOrEmpty(postCode) ) {
			if ( s.length() > 0 ) {
				s.append(", ");
			}
			s.append(postCode);
			if ( !StringUtils.isNullOrEmpty(city) ) {
				s.append(" ");
				s.append(city);
			}
		} else {
			if ( !StringUtils.isNullOrEmpty(city) ) {
				if ( s.length() > 0 ) {
					s.append(", ");
				}
				s.append(city);
			}
		}
		return s.toString();
	}
}
