package utils;

import javax.servlet.http.Cookie;

public final class CookieUtil {
	
	public static String get(Cookie[] cookies, String name) {
		if (cookies == null) {
			return null;
		}
		
		int length = cookies.length;
		
		for (int i=0; i<length; i++) {
			if (cookies[i].getName().equals(name)) {
				return cookies[i].getValue();
			}
		}
		
		return null;
	}
}
