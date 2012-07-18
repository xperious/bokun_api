package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class DateUtils {

    public static int getNightCount(Date startDate, Date endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        if ( formatter.format(start.getTime()).equals(formatter.format(end.getTime())) ) {
            // same day, add one to end date
            return 1;
        }

        int nightCount = 0;
        while (start.before(end)) {
            nightCount++;
            start.add(Calendar.DATE, 1);
        }
        return nightCount;
    }

    public static void nullifyTime(Calendar c) {
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
    }

    public static Date todayNullified() {
        Calendar cal = Calendar.getInstance();
        nullifyTime(cal);
        return cal.getTime();
    }
}
