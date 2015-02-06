package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingPaymentInfoDto extends PaymentDto {

    public List<SettlementDto> settlements = new ArrayList<>();

    public List<SettlementDto> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<SettlementDto> settlements) {
        this.settlements = settlements;
    }
}
