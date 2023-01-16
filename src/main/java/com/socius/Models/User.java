package com.socius.Models;

import java.sql.Timestamp;

public class User extends Account {
    public User(
            Integer userId,
            String username,
            String name,
            String email,
            String password,
            Timestamp createdAt,
            Timestamp deletedAt
    ) {
        super(userId == null ? -1 : userId, username, name, email, password, false, createdAt, deletedAt);
    }
}
