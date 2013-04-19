package is.bokun.dtos;

public class TranslationLanguageDto {

	public Long id;
	public String code;
	
	public TranslationLanguageDto() {}
	
	public TranslationLanguageDto(Long id, String code) {
		this.id = id;
		this.code = code;
	}
}
