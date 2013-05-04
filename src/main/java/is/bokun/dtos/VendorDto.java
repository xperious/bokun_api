package is.bokun.dtos;

public class VendorDto {

	public Long id;
	
	public String title;
	
	public String currencyCode;

    public VendorDto() {}

    public VendorDto(Long id, String title, String currencyCode) {
        this.id = id;
        this.title = title;
        this.currencyCode = currencyCode;
    }

}
