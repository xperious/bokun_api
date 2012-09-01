package dtos.activity;

import java.util.*;

import com.codiform.moo.annotation.Property;

import dtos.QuestionDto;

public class ActivityExtraDto {

    public Long id;
    public String externalId;
    public String title;

    @Property(translation = "pricingType.name()")
    public String pricingType;

    public int price;

    public int childDiscount = 100;
    public int teenagerDiscount = 50;

    public List<QuestionDto> questions = new ArrayList<QuestionDto>();
}
