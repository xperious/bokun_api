package is.bokun.dtos.transport;

/**
 * Created by ogg on 18.9.2014.
 */
public class PricingCategoryPassengerSpecificationDto {

    public Long categoryId;
    public int passengers;

    public PricingCategoryPassengerSpecificationDto() {}

    public PricingCategoryPassengerSpecificationDto(Long categoryId, int passengers) {
        this.categoryId = categoryId;
        this.passengers = passengers;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
