package com.socius.Models;

import java.util.Date;

public class User extends Account {
    public User(
            Integer userId,
            String username,
            String name,
            String email,
            String password,
            Date createdAt,
            Date deletedAt
    ) {
        super(userId == null ? -1 : userId, username, name, email, password, false, createdAt, deletedAt);
    }
}
