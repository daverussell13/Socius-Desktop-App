package com.socius.Request;

import com.socius.Core.Request;
import com.socius.Utils.DBUtils;
import com.socius.Utils.StringUtils;

public class SignUpRequest implements Request {
    private final String username;
    private final String name;
    private final String email;
    private final String password;

    public SignUpRequest(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public SignUpRequest validate() throws Exception {
        DBUtils.validateUsername(username);
        DBUtils.validateEmail(email);
        DBUtils.validatePassword(password);
        DBUtils.validateName(name);
        if (!StringUtils.isEmail(email)) throw new Exception("Please enter valid email address");
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
