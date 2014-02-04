package is.bokun.dtos.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by ogg on 19/1/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ChargeRequestDto {

    private CardDto card;
    private boolean confirmBookingOnSuccess;

    public CardDto getCard() {
        return card;
    }

    public void setCard(CardDto card) {
        this.card = card;
    }

    public boolean isConfirmBookingOnSuccess() {
        return confirmBookingOnSuccess;
    }

    public void setConfirmBookingOnSuccess(boolean confirmBookingOnSuccess) {
        this.confirmBookingOnSuccess = confirmBookingOnSuccess;
    }
}
