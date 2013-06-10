package is.bokun.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class StringUtils {

    private static final String[] DATE_FORMATS = {"dd.MM.yy", "dd.MM.yyyy", "yyyy-MM-dd"};

    public static Date parseDate(String s) {
    	return parseDate(s, DATE_FORMATS);
    }
    public static Date parseDate(String s, String[] dateFormats) {
        if ( s == null || s.trim().isEmpty() ) {
            return null;
        }
        for ( String format : dateFormats ) {
            try {
                return new SimpleDateFormat(format).parse(s.trim());
            } catch (ParseException ignored) {}
        }
        return null;
    }
    
    public static String formatTime(int hour, int minute) {
        StringBuilder s = new StringBuilder();
        if ( hour < 10 ) {
            s.append(0);
        }
        s.append(hour);
        s.append(':');
        if ( minute < 10 ) {
            s.append(0);
        }
        s.append(minute);
        return s.toString();
    }

    public static boolean isNullOrEmpty(String... s) {
        for (String str : s) {
            if ( str == null || str.trim().isEmpty() ) {
                return true;
            }
        }
        return false;
    }
    
    public static Set<String> commaSeparatedToSet(String s) {
    	Set<String> set = new HashSet<>();
		if ( s == null || s.trim().isEmpty() ) return set;
		for ( String id : s.trim().split(",") ) {
			if ( !id.trim().isEmpty() ) {
				set.add(id.trim());
			}
		}
    	return set;
    }

	public static Set<Long> commaSeparatedStringToIds( String s ) {
		Set<Long> ids = new HashSet<>();
		if ( s == null || s.trim().isEmpty() ) return ids;
		for ( String id : s.trim().split(",") ) {
			if ( !id.trim().isEmpty() ) {
				try {
					ids.add(Long.parseLong(id.trim()));
				} catch ( Throwable ignored ) {}
			}
		}
		return ids;
	}

    public static Set<Integer> commaSeparatedToInts(String s) {
        Set<Integer> ints = new HashSet<>();
        if ( s == null || s.trim().isEmpty() ) return ints;
        for ( String i : s.trim().split(",") ) {
            if ( !i.trim().isEmpty() ) {
                try {
                    ints.add(Integer.parseInt(i.trim()));
                } catch ( Throwable ignored ) {}
            }
        }
        return ints;
    }
    
    public static String idSetToCommaSeparated(Set<Long> set) {
    	StringBuilder s = new StringBuilder();
    	for ( Long l : set ) {
    		if ( s.length() > 0 ) { s.append(','); }
    		s.append(l);
    	}
    	return s.toString();
    }
    
    public static String intSetToCommaSeparated(Set<Integer> set) {
    	StringBuilder s = new StringBuilder();
    	for ( Integer l : set ) {
    		if ( s.length() > 0 ) { s.append(','); }
    		s.append(l);
    	}
    	return s.toString();
    }
    
    public static String setToCommaSeparated(Set<String> set) {
    	StringBuilder s = new StringBuilder();
    	for ( String l : set ) {
    		if ( s.length() > 0 ) { s.append(','); }
    		s.append(l);
    	}
    	return s.toString();
    }
    
	public static String formatLocalDate(String lang, Date date, String format) {
		if ( date == null ) {
			return "";
		}
		return new SimpleDateFormat(format, new Locale(lang.toLowerCase())).format(date);
	}
    
	public static String formatLocalDateRange(String lang, Date start, Date end) {
		return formatLocalDateRange(lang, start, end, true, true);
	}
	
	public static String formatLocalDateRange(String lang, Date start, Date end, boolean displayYear, boolean displayWeekdays) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(start);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(end);
		
		Locale locale = new Locale(lang.toLowerCase());
		
		String dayPrefix = displayWeekdays ? "EEE " : "";
		
		// if same month and year, then we can write a shorthand notion
		if ( startCal.get(Calendar.YEAR) == endCal.get(Calendar.YEAR) && startCal.get(Calendar.MONTH) == endCal.get(Calendar.MONTH) ) {
			StringBuilder buffer = new StringBuilder();
			buffer.append(new SimpleDateFormat(dayPrefix + "d.", locale).format(start));
			buffer.append(" - ");
			buffer.append(new SimpleDateFormat(dayPrefix + "d.MMM" + (displayYear ? " ''yy" : ""), locale).format(end));
			return buffer.toString();
		} else if ( startCal.get(Calendar.YEAR) == endCal.get(Calendar.YEAR) ) {
			StringBuilder buffer = new StringBuilder();
			buffer.append(new SimpleDateFormat(dayPrefix + "d.MMM", locale).format(start));
			buffer.append(" - ");
			buffer.append(new SimpleDateFormat(dayPrefix + "d.MMM" + (displayYear ? " ''yy" : ""), locale).format(end));
			return buffer.toString();
		} else {
			StringBuilder buffer = new StringBuilder();
			buffer.append(new SimpleDateFormat(dayPrefix + "d.MMM" + (displayYear ? " ''yy" : ""), locale).format(start));
			buffer.append(" - ");
			buffer.append(new SimpleDateFormat(dayPrefix + "d.MMM" + (displayYear ? " ''yy" : ""), locale).format(end));
			return buffer.toString();
		}
	}
}
