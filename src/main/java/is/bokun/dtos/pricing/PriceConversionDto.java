package is.bokun.dtos.pricing;

/**
 * @author Sindri Traustason
 */
public class PriceConversionDto {

    public Double percentage;
    public String type;
    public String parentCurrency;

    @SuppressWarnings("UnusedDeclaration")
    public PriceConversionDto() {}

    public PriceConversionDto(String type, Double percentage, String parentCurrency) {
        this.type = type;
        this.percentage = percentage;
        this.parentCurrency = parentCurrency;
    }
}
