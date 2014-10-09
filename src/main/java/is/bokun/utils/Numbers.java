package is.bokun.utils;

import com.google.common.base.Function;

/**
 * Created by ogg on 19.8.2014.
 */
public class Numbers {

    public static Function<String, Integer> parseIntegerFunction() {
        return ParseIntegerFunction.INSTANCE;
    }

    private enum ParseIntegerFunction implements Function<String, Integer> {
        INSTANCE;

        public Integer apply(String input) {
            try {
                return Integer.valueOf(input);
            } catch (Throwable ignored) {
                return null;
            }
        }

        @Override public String toString() {
            return "ParseIntegerFunction";
        }
    }

    public static Function<String, Long> parseLongFunction() {
        return ParseLongFunction.INSTANCE;
    }

    private enum ParseLongFunction implements Function<String, Long> {
        INSTANCE;

        public Long apply(String input) {
            try {
                return Long.valueOf(input);
            } catch (Throwable ignored) {
                return null;
            }
        }

        @Override public String toString() {
            return "ParseLongFunction";
        }
    }
}
