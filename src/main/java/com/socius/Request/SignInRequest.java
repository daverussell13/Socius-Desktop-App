package com.socius.Request;

import com.socius.Core.Request;
import com.socius.Utils.DBUtils;
import com.socius.Utils.StringUtils;

public class SignInRequest implements Request {
    private final String usernameOrEmail;

    private final String password;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public SignInRequest(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

    @Override
    public SignInRequest validate() throws Exception {
        String email = StringUtils.isEmail(usernameOrEmail) ? usernameOrEmail : null;
        if (email == null) DBUtils.validateUsername(usernameOrEmail);
        else DBUtils.validateEmail(usernameOrEmail);
        DBUtils.validatePassword(password);
        return this;
    }
}
