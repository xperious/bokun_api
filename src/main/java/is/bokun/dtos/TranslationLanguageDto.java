package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslationLanguageDto {

	public Long id;
	public String code;
	
	public TranslationLanguageDto() {}
	
	public TranslationLanguageDto(Long id, String code) {
		this.id = id;
		this.code = code;
	}
}
