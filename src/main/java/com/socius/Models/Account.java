package com.socius.Models;

import javafx.beans.property.*;

import java.util.Date;

public class Account {
    private final IntegerProperty userId;
    private final StringProperty username;
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty password;
    private final BooleanProperty isAdmin;
    private final ObjectProperty<Date> createdAt;
    private final ObjectProperty<Date> deletedAt;

    public Account(
            Integer userId,
            String username,
            String name,
            String email,
            String password,
            Boolean isAdmin,
            Date createdAt,
            Date deletedAt
    ) {
        this.userId = new SimpleIntegerProperty(this, "Id", userId);
        this.username = new SimpleStringProperty(this, "Username", username);
        this.name = new SimpleStringProperty(this, "name", name);
        this.email = new SimpleStringProperty(this, "email", email);
        this.password = new SimpleStringProperty(this, "password", password);
        this.isAdmin = new SimpleBooleanProperty(this, "Is Admin", isAdmin);
        this.createdAt = new SimpleObjectProperty<Date>(this, "Created At", createdAt);
        this.deletedAt = new SimpleObjectProperty<Date>(this, "Deleted At", deletedAt);
    }

    public IntegerProperty userIdProperty() {
        return userId;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public BooleanProperty isAdminProperty() {
        return isAdmin;
    }

    public ObjectProperty<Date> createdAtProperty() {
        return createdAt;
    }

    public ObjectProperty<Date> deletedAtProperty() {
        return deletedAt;
    }
}
