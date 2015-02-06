package is.bokun.utils;

/**
 * Created by ogg on 1/7/14.
 */
public class PriceUtils {

    public static double calculatePriceWithDiscount(double total, Double discountPercentage, Double discountAmount) {
        if ( discountPercentage != null && discountPercentage != 0 ) {
            double perc = 100d - discountPercentage;
            return percentage(total, perc);
        } else if ( discountAmount != null && discountAmount != 0 ) {
            return total - discountAmount;
        } else {
            return total;
        }
    }

    public static double percentage(double base, double perc) {
        return (int)Math.floor(base * (perc / 100d) + 0.5d);
    }
}
