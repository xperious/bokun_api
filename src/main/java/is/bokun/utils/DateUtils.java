package is.bokun.utils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class DateUtils {
	
	public static double getHourDiff(Date startDate, Date endDate) {
		return (endDate.getTime() - startDate.getTime()) / TimeUnit.HOURS.toMillis(1);
	}

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

	public static int getRentalDayCount(Date startDate, Date endDate) {
		if ( startDate == null ) {
			return 0;
		}
		if ( endDate == null ) {
			return 1;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		int counter = 0;
		while (start.before(end)) {
			counter++;

			// jump to the next date
			start.add(Calendar.DATE, 1);
		}
		return counter;
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
