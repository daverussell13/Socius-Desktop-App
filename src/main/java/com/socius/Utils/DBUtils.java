package com.socius.Utils;

public class DBUtils {
    public static int usnLenConstraint = 20;
    public static int nameLenConstraint = 20;
    public static int emailLenConstraint = 30;
    public static int passLenConstraint = 20;

    public static void notNullOrEmpty(String string) throws Exception {
        if (string == null || StringUtils.emptyString(string))
            throw new Exception("All field should not be empty");
    }

    public static void validateUsername(String username) throws Exception {
        notNullOrEmpty(username);
        if (username.length() >= usnLenConstraint)
            throw new Exception("Username must not exceed " + usnLenConstraint + " characters");
    }

    public static void validateName(String name) throws Exception {
        notNullOrEmpty(name);
        if (name.length() >= nameLenConstraint)
            throw new Exception("Name must not exceed " + nameLenConstraint + " characters");
    }

    public static void validateEmail(String email) throws Exception {
        notNullOrEmpty(email);
        if (email.length() >= emailLenConstraint)
            throw new Exception("Email must not exceed " + emailLenConstraint + " characters");
    }

    public static void validatePassword(String pass) throws Exception {
        notNullOrEmpty(pass);
        if (pass.length() >= passLenConstraint)
            throw new Exception("Password must not exceed " + passLenConstraint + " characters");
    }
}
