package is.bokun.dtos.booking;

public class BookingItemInfoDto {

	public Long id;
	public String title;
    public Integer price;
	
	public BookingItemInfoDto() {}
	
	public BookingItemInfoDto(Long id, String title) {
		this.id = id;
		this.title = title;
	}
}
