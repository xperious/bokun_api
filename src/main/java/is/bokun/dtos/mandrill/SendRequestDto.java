package is.bokun.dtos.mandrill;

import java.util.*;

public class SendRequestDto {

	public String key;
	public String template_name;
	public boolean async = false;
	
	public List<Variable> template_content = new ArrayList<>();
	
	public Message message;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTemplate_name() {
		return template_name;
	}

	public void setTemplate_name(String template_name) {
		this.template_name = template_name;
	}

	public List<Variable> getTemplate_content() {
		return template_content;
	}

	public void setTemplate_content(List<Variable> template_content) {
		this.template_content = template_content;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public boolean isAsync() {
		return async;
	}

	public void setAsync(boolean async) {
		this.async = async;
	}

	public static class Message {
		
		public String subject;
		public String from_email;
		public String from_name;
		public String bcc_address;
		public List<Recipient> to = new ArrayList<>();
		public List<Variable> global_merge_vars = new ArrayList<>();
		
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getFrom_email() {
			return from_email;
		}
		public void setFrom_email(String from_email) {
			this.from_email = from_email;
		}
		public String getFrom_name() {
			return from_name;
		}
		public void setFrom_name(String from_name) {
			this.from_name = from_name;
		}
		public String getBcc_address() {
			return bcc_address;
		}
		public void setBcc_address(String bcc_address) {
			this.bcc_address = bcc_address;
		}
		public List<Recipient> getTo() {
			return to;
		}
		public void setTo(List<Recipient> to) {
			this.to = to;
		}
		public List<Variable> getGlobal_merge_vars() {
			return global_merge_vars;
		}
		public void setGlobal_merge_vars(List<Variable> global_merge_vars) {
			this.global_merge_vars = global_merge_vars;
		}
	}
	
	public static class Recipient {
		
		public String email;
		
		public Recipient() {}
		
		public Recipient(String email) {
			this.email = email;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

	}
	
	public static class Variable {
		
		public String name;
		public String content;
		
		public Variable() {}
		
		public Variable(String name, String content) {
			this.name = name;
			this.content = content;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
	}
}
