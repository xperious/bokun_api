package is.bokun.utils;

/**
 * @author Sindri Traustason
 */
public class NumberUtils {

    public static boolean notNullAndPositive(Number number) {
        return number != null && number.doubleValue() > 0;
    }

    public static boolean nullOrNegative(Number startTimeId) {
        return startTimeId == null || startTimeId.doubleValue() <= 0;
    }

    private NumberUtils(){}
}
