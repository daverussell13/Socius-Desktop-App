package com.socius.Models;

import java.sql.Timestamp;

public class Admin extends Account {
    public Admin(
            int userId,
            String username,
            String name,
            String email,
            String password,
            Timestamp createdAt,
            Timestamp deletedAt
    ) {
        super(userId, username, name, email, password, true, createdAt, deletedAt);
    }
}
