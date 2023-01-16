package com.socius.Services;

import com.socius.Models.Account;
import com.socius.Repositories.AccountRepo;
import com.socius.Request.SignUpRequest;

import java.sql.SQLException;

public class AccountService {
    private final AccountRepo accRepo;

    public AccountService() {
        this.accRepo = new AccountRepo();
    }

    public boolean signUp(SignUpRequest request) throws SQLException {
        if (accRepo.isExist(request.getEmail(), request.getUsername()) ||
            !accRepo.insertAccount(request)) return false;
        accRepo.closeConnection();
        return true;
    }

    public void signIn(Account account) throws SQLException {
    }
}
