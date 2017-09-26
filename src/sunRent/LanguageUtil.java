package sunRent;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class LanguageUtil {

	private static final String MESSAGES = "config/messages";

    private LanguageUtil() {

    }
    
    public static final String getGreet(){
    	return "Hello";
    }
    
    /**
     * Gets the current locale.
     *
     * @return the current locale
     */
    public static final Locale getCurrentLocale() {
        HttpServletRequest request =
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (request != null) {
            Object oLang = request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
            Locale curlang;
            if (null == oLang) {
                curlang = request.getLocale();
            } else {
                curlang = (Locale) oLang;
            }
            return curlang;
        }
        return null;
    }

    /**
     * Gets the string.
     *
     * @param key the key
     * @return the string
     */
    public static final String getString(final String key) {
//        HttpServletRequest request =
//            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        if (request != null) {
//            Object oLang = request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
//            Locale curlang;
//            if (null == oLang) {
//                curlang = request.getLocale();
//            } else {
//                curlang = (Locale) oLang;
//            }
//            return ResourceBundle.getBundle(MESSAGES, curlang).getString(key);
//        }
//        return StringUtils.EMPTY;
    	ResourceBundle resourceBundle = ResourceBundle.getBundle(MESSAGES, Locale.TAIWAN);
        return resourceBundle.getString(key);

    }
}
