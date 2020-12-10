package aoc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidationUtils {
	
	private ValidationUtils() {}
	
	public static boolean matchRegexp(String field, String regexp) {
		Pattern pattern = Pattern.compile(regexp);
	    Matcher matcher = pattern.matcher(field);
	    return matcher.matches();
	}
	
	public static boolean validHeight(String heightField, String unit, int digits, int min, int max) {
		boolean result = false;

	    if(matchRegexp(heightField, "^\\d{" + digits + "}" + unit + "$")) {
	    	int height = Integer.parseInt(heightField.substring(0, heightField.length() - 2));
	    	result = height >= min && height <= max;
	    }

	    return result;
	}
	
	public static boolean validYear(String yearField, int minYear, int maxYear) {
		boolean result = false;
		
	    if(ValidationUtils.matchRegexp(yearField, "^\\d{4}$")) {
	    	int birthYear = Integer.parseInt(yearField);
	    	result = birthYear >= minYear && birthYear <= maxYear;
	    }
	    
	    return result;
	}
}
