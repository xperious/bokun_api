package is.bokun.dtos.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ogg on 19/1/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargeRequestDto {

    private CardDto card;

    public CardDto getCard() {
        return card;
    }

    public void setCard(CardDto card) {
        this.card = card;
    }
}
