package com.socius.Repositories;

import com.socius.Core.Database;
import com.socius.Core.Repositories;
import com.socius.Models.Account;
import com.socius.Utils.ViewUtils;

import java.sql.SQLException;

public class AccountRepo extends Repositories {
    public AccountRepo() {
        this.conn = Database.getInstance().getConnection();
    }

    public boolean isEmailExist(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ?;";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                ViewUtils.showErrorAlert("Email already exists");
                return true;
            }
        } finally {
            this.closeAll();
        }
        return false;
    }

    public boolean isUsernameExist(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?;";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                ViewUtils.showErrorAlert("Username already exists");
                return true;
            }
        } finally {
            this.closeAll();
        }
        return false;
    }

    public boolean isExist(Account account) throws SQLException {
        return isEmailExist(account.emailProperty().get()) || isUsernameExist(account.usernameProperty().get());
    }

    public int insertAccount(Account account) throws SQLException {
        String query = """
                INSERT INTO
                users (username, name, email, password, is_admin)
                VALUES (?, ? ,?, ?, ?);
                """;
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, account.usernameProperty().get());
            stmt.setString(2, account.nameProperty().get());
            stmt.setString(3, account.emailProperty().get());
            stmt.setString(4, account.passwordProperty().get());
            stmt.setInt(5, account.isAdminProperty().get() ? 1 : 0);
            return stmt.executeUpdate();
        } finally {
            this.closeAll();
        }
    }
}
