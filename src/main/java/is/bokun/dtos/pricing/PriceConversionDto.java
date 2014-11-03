package is.bokun.dtos.pricing;

/**
 * @author Sindri Traustason
 */
public class PriceConversionDto {

    public Double percentage;
    public String type;

    @SuppressWarnings("UnusedDeclaration")
    public PriceConversionDto() {}

    public PriceConversionDto(String name, Double percentage) {
        this.type = name;
        this.percentage = percentage;
    }
}
