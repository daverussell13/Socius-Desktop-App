package com.socius.Repositories;

import com.socius.Core.Repositories;
import com.socius.Models.Account;
import com.socius.Models.Admin;
import com.socius.Models.User;
import com.socius.Request.SignUpRequest;
import com.socius.Utils.HashUtils;
import com.socius.Utils.ViewUtils;

import java.sql.SQLException;

public class AccountRepository extends Repositories {
    public AccountRepository() {
        super();
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
            this.closeStatementResult();
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
            this.closeStatementResult();
        }
        return false;
    }

    public boolean isExist(String email, String username) throws SQLException {
        return isEmailExist(email) || isUsernameExist(username);
    }

    public boolean insertAccount(SignUpRequest request) throws SQLException {
        String query = """
                INSERT INTO
                users (username, name, email, password)
                VALUES (?, ? ,?, ?);
                """;
        String hashedPass = HashUtils.hashString(request.getPassword());
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, request.getUsername());
            stmt.setString(2, request.getName());
            stmt.setString(3, request.getEmail());
            stmt.setString(4, hashedPass);
            return stmt.executeUpdate() != 0;
        } finally {
            this.closeStatementResult();
        }
    }

    private Account getAccount(String param, String query) throws SQLException {
        stmt = conn.prepareStatement(query);
        stmt.setString(1, param);
        rs = stmt.executeQuery();
        if (rs.next()) {
            Account account;
            if (rs.getInt("is_admin") == 1) {
                account = new Admin(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("deleted_at")
                );
            } else {
                account = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("deleted_at")
                );
            }
            return account;
        }
        return null;
    }

    public Account getAccountByUsername(String username) throws SQLException {
        String query = """
                SELECT *
                FROM users
                WHERE username = ?
                """;
        try {
            Account account = getAccount(username, query);
            if (account != null) return account;
        } finally {
            this.closeStatementResult();
        }
        return null;
    }

    public Account getAccountByEmail(String email) throws SQLException {
        String query = """
                SELECT *
                FROM users
                WHERE email = ?
                """;
        try {
            Account account = getAccount(email, query);
            if (account != null) return account;
        } finally {
            this.closeStatementResult();
        }
        return null;
    }
}
