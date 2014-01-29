package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.accommodation.AccommodationDto;
import is.bokun.dtos.activity.ActivityDto;
import is.bokun.dtos.carrental.CarTypeDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ProductListItemDto {

    public ProductCategoryEnum productCategory;

    public ActivityDto activity;
    public AccommodationDto accommodation;
    public CarTypeDto vehicle;

    public ProductListItemDto(){}

    public ProductListItemDto(AccommodationDto a) {
        productCategory = ProductCategoryEnum.ACCOMMODATION;
        accommodation = a;
    }

    public ProductListItemDto(ActivityDto a) {
        productCategory = ProductCategoryEnum.ACTIVITIES;
        activity = a;
    }

    public ProductListItemDto(CarTypeDto c) {
        productCategory = ProductCategoryEnum.CAR_RENTALS;
        vehicle = c;
    }

}
