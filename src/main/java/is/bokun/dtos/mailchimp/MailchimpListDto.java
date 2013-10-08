package is.bokun.dtos.mailchimp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailchimpListDto {

	public String id;
	public String name;
}
