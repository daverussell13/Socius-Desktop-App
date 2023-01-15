package com.socius.Core;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Dotenv ENV = Dotenv.load();
    private static final String host = ENV.get("DB_HOST");
    private static final String database = ENV.get("DB_NAME");
    private static final String url = "jdbc:mysql://" + host + "/" + database;
    private static final String user = ENV.get("DB_USER");
    private static final String password = ENV.get("DB_PASS");
    private static final int timeout = 5;
    private Connection connection =  null;

    private Database() {}

    private static class InstanceHolder { private static final Database instance = new Database(); }

    public static Database getInstance() {
        return InstanceHolder.instance;
    }

    public Connection getConnection() {
        try {
            if (connection.isValid(timeout)) return connection;
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void openConnection() {
        System.out.println("Connecting to database...");
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection valid: " + connection.isValid(timeout));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        System.out.println("Closing database connection...");
        try {
            connection.close();
            System.out.println("Connection valid: " + connection.isValid(timeout));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
