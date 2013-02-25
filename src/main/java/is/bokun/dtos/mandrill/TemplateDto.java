package is.bokun.dtos.mandrill;

public class TemplateDto {

	public Long id;
	public String name;
	public String code;
	public String slug;
	
	public String publish_name;
	public String publish_code;
	public String published_at;
	public String created_at;
	public String updated_at;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPublish_name() {
		return publish_name;
	}
	public void setPublish_name(String publish_name) {
		this.publish_name = publish_name;
	}
	public String getPublish_code() {
		return publish_code;
	}
	public void setPublish_code(String publish_code) {
		this.publish_code = publish_code;
	}
	public String getPublished_at() {
		return published_at;
	}
	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
}
