package is.bokun.dtos.mailchimp;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResponse {

	public int total;
	public List<MailchimpListDto> data = new ArrayList<>();
}
