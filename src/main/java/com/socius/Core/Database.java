package com.socius.Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String host = "localhost";
    private static final String database = "socius";
    private static final String url = "jdbc:mysql://" + host + "/" + database;
    private static final String user = "root";
    private static final String password = "loladmit";
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
