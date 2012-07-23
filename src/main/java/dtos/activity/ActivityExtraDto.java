package dtos.activity;

import java.util.List;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;

import dtos.QuestionDto;

public class ActivityExtraDto {

    public Long id;
    public String description;

    public boolean active = true;

    @Property(translation = "pricingType.name()")
    public String pricingType;

    public int price;

    public int childDiscount = 100;
    public int teenagerDiscount = 50;

    @CollectionProperty(itemTranslation = QuestionDto.class)
    public List<QuestionDto> questions;
}
