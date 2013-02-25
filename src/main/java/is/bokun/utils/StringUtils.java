package is.bokun.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
}
