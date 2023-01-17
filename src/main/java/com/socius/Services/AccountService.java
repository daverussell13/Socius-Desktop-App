package com.socius.Services;

import com.socius.Models.Account;
import com.socius.Repositories.AccountRepository;
import com.socius.Request.SignInRequest;
import com.socius.Request.SignUpRequest;
import com.socius.Utils.HashUtils;

import java.sql.SQLException;

public class AccountService {
    private final AccountRepository accRepo;

    public AccountService() {
        this.accRepo = new AccountRepository();
    }

    public boolean signUp(SignUpRequest request) throws SQLException {
        return !accRepo.isExist(request.getEmail(), request.getUsername()) &&
               accRepo.insertAccount(request);
    }

    public Account signIn(SignInRequest request) throws Exception {
        Account acc = accRepo.getAccountByEmail(request.getUsernameOrEmail());
        if (acc == null) acc = accRepo.getAccountByUsername(request.getUsernameOrEmail());
        if (acc == null) throw new Exception("Wrong user credentials");
        if (!HashUtils.verifyHash(request.getPassword(), acc.passwordProperty().get()))
            throw new Exception("Wrong user credentials");
        return acc;
    }
}
