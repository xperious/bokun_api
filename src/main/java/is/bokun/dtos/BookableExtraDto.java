package is.bokun.dtos;

import java.util.ArrayList;
import java.util.List;

public class BookableExtraDto {

    public Long id;
    public String externalId;
    public String title;
    public boolean included;

    public String pricingType;
    public int price;

    public int maxPerBooking;

    public List<QuestionDto> questions = new ArrayList<>();
}
