package com.socius.Services;

import com.socius.Models.Account;
import com.socius.Repositories.AccountRepo;

import java.sql.SQLException;

public class AccountService {
    private final AccountRepo accRepo;

    public AccountService() {
        this.accRepo = new AccountRepo();
    }

    public boolean register(Account account) throws SQLException {
        if (accRepo.isExist(account)) return false;
        accRepo.insertAccount(account);
        accRepo.closeConnection();
        return true;
    }

    public void login() {

    }
}
