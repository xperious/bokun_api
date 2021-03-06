package is.bokun.utils;

import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

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

    public static boolean noe(String... s) {
        return isNullOrEmpty(s);
    }

    public static boolean isNullOrEmpty(String... s) {
        for (String str : s) {
            if ( Strings.nullToEmpty(str).trim().isEmpty() ) {
                return true;
            }
        }
        return false;
    }

    public static boolean allNullOrEmpty(String... s) {
        boolean allEmpty = true;
        for (String str : s) {
            allEmpty = allEmpty && isNullOrEmpty(str);
        }
        return allEmpty;
    }

    public static boolean containsIgnoreCase(Collection<String> collection, String value) {
        for (String s : collection) {
            if ( s.equalsIgnoreCase(value) ) {
                return true;
            }
        }
        return false;
    }

    public static List<String> lineBrSeparatedToList(String s) {
        return Splitter.on('\n')
                .trimResults()
                .omitEmptyStrings()
                .splitToList(Strings.nullToEmpty(s));
    }
    
    public static Set<String> commaSeparatedToSet(String s) {
        return new HashSet<>(commaSeparatedToList(s));
    }

    public static List<String> commaSeparatedToList(String s) {
        return Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .splitToList(Strings.nullToEmpty(s));
    }

    public static Set<Long> arrayToIds(String[] arr) {
        Set<Long> ids = new HashSet<>();
        if ( arr == null || arr.length == 0 ) {
            return ids;
        }
        for (String s : arr) {
            try {
                ids.add(Long.parseLong(s));
            } catch ( Throwable ignored ) {}
        }
        return ids;
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
	
	public static List<Long> commaSeparatedStringToIdList( String s ) {
        List<String> strings = commaSeparatedToList(s);
        return new ArrayList<Long>(Collections2.filter(Lists.transform(strings, Numbers.parseLongFunction()), Predicates.notNull()));
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
    
    public static List<Integer> commaSeparatedToIntLists(String s) {
    	List<Integer> ints = new ArrayList<>();
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
    
    public static List<Long> commaSeparatedToLongList(String s) {
    	List<Long> ints = new ArrayList<>();
        if ( s == null || s.trim().isEmpty() ) return ints;
        for ( String i : s.trim().split(",") ) {
            if ( !i.trim().isEmpty() ) {
                try {
                    ints.add(Long.parseLong(i.trim()));
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
    
    public static String idListToCommaSeparated(List<Long> set) {
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

    public static String listToCommaSeparated(List<String> list) {
    	StringBuilder s = new StringBuilder();
        if (list != null) {
            for ( String l : list ) {
                if ( s.length() > 0 ) { s.append(','); }
                s.append(l);
            }
        }
        return s.toString();
    }
    
    public static String setToCommaSeparated(Set<String> set) {
    	StringBuilder s = new StringBuilder();
        if (set != null) {
            for ( String l : set ) {
                if ( s.length() > 0 ) { s.append(','); }
                s.append(l);
            }
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
