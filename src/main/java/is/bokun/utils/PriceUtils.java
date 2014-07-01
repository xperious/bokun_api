package is.bokun.utils;

/**
 * Created by ogg on 1/7/14.
 */
public class PriceUtils {

    public static Double calculatePriceWithDiscount(double total, Double discountPercentage, Double discountAmount) {
        if ( discountPercentage != null && discountPercentage > 0 ) {
            double perc = 100d - discountPercentage;
            return percentage(total, perc);
        } else if ( discountAmount != null && discountAmount > 0 ) {
            Double amount = total - discountAmount;
            if ( amount.doubleValue() < 0 ) {
                return 0d;
            } else {
                return amount;
            }
        } else {
            return total;
        }
    }

    public static double percentage(double base, double perc) {
        return (int)Math.floor(base * (((double)perc) / 100d) + 0.5d);
    }
}
