package com.socius.Utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class HashUtils {
    public static BCrypt.Version version = BCrypt.Version.VERSION_2Y;

    public static String hashString(String password) {
        return BCrypt.with(version).hashToString(12, password.toCharArray());
    }

    public static boolean verifyHash(String string, String hashedString) {
        BCrypt.Result result = BCrypt.verifyer(version).verify(string.toCharArray(), hashedString);
        return result.verified;
    }
}
