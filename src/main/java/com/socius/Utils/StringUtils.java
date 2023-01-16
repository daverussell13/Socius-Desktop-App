package com.socius.Utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean patternMatches(String string, String regex) {
        return Pattern.compile(regex)
                .matcher(string)
                .matches();
    }

    public static boolean emptyString(String string) {
        return string.trim().length() == 0;
    }

    public static boolean isEmail(String string) {
        String owasp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return patternMatches(string, owasp);
    }

    public static String getFormattedTimestamp(Timestamp timeStamp) {
        return new SimpleDateFormat("dd-MM-yy HH:mm").format(timeStamp);
    }
}
