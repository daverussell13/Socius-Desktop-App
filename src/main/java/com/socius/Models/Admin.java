package com.socius.Models;

import java.util.Date;

public class Admin extends Account {
    public Admin(
            int userId,
            String username,
            String name,
            String email,
            String password,
            Date createdAt,
            Date deletedAt
    ) {
        super(userId, username, name, email, password, true, createdAt, deletedAt);
    }
}
