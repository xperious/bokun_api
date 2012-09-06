package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class StringUtils {

    private static final String[] DATE_FORMATS = {"dd.MM.yyyy", "dd.MM.yy", "yyyy-MM-dd"};

    public static Date parseDate(String s) {
        if ( s == null || s.trim().isEmpty() ) {
            return null;
        }
        for ( String format : DATE_FORMATS ) {
            try {
                return new SimpleDateFormat(format).parse(s.trim());
            } catch (ParseException ignored) {}
        }
        return null;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
    
    public static Set<String> commaSeparatedToSet(String s) {
    	Set<String> set = new HashSet<String>();
		if ( s == null || s.trim().isEmpty() ) return set;
		for ( String id : s.trim().split(",") ) {
			if ( !id.trim().isEmpty() ) {
				set.add(id);
			}
		}
    	return set;
    }

	public static Set<Long> commaSeparatedStringToIds( String s ) {
		Set<Long> ids = new HashSet<Long>();
		if ( s == null || s.trim().isEmpty() ) return ids;
		for ( String id : s.trim().split(",") ) {
			if ( !id.trim().isEmpty() ) {
				try {
					ids.add(Long.parseLong(id));
				} catch ( Throwable ignored ) {}
			}
		}
		return ids;
	}

    public static Set<Integer> commaSeparatedToInts(String s) {
        Set<Integer> ints = new HashSet<Integer>();
        if ( s == null || s.trim().isEmpty() ) return ints;
        for ( String i : s.trim().split(",") ) {
            if ( !i.trim().isEmpty() ) {
                try {
                    ints.add(Integer.parseInt(i));
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
