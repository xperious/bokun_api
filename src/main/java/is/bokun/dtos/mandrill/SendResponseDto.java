package is.bokun.dtos.mandrill;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SendResponseDto {

	public String status;
	public int code;
	public String name;
	public String message;
	
	public List<MailResultDto> mails = new ArrayList<>();
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<MailResultDto> getMails() {
		return mails;
	}

	public void setMails(List<MailResultDto> mails) {
		this.mails = mails;
	}

    @JsonIgnoreProperties(ignoreUnknown = true)
	public static class MailResultDto {
		
		public String email;
		public String status;
        public String reject_reason;
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

        public String getReject_reason() {
            return reject_reason;
        }

        public void setReject_reason(String reject_reason) {
            this.reject_reason = reject_reason;
        }
    }
}
