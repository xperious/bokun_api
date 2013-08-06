package is.bokun.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import is.bokun.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto {

	public String address;
	public String city;
	public String countryCode;
	public String postCode;

	public double latitude = 64.923542;
	public double longitude = -19.511719;
	
	public int zoomLevel = 6;
	
	public LocationDto() {}
	
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
