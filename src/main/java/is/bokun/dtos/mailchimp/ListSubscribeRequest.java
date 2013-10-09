package is.bokun.dtos.mailchimp;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListSubscribeRequest {

	public String apikey;
	public String id;
	public EmailStruct email;
	public Map<String,Object> merge_vars = new HashMap<String,Object>();
	

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EmailStruct getEmail() {
		return email;
	}

	public void setEmail(EmailStruct email) {
		this.email = email;
	}

	public Map<String, Object> getMerge_vars() {
		return merge_vars;
	}

	public void setMerge_vars(Map<String, Object> merge_vars) {
		this.merge_vars = merge_vars;
	}

	public static class EmailStruct {
		
		public String email;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
	}
}
