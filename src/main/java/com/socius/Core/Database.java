package com.socius.Core;

import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final Dotenv ENV = Dotenv.load();
    private static final String host = ENV.get("DB_HOST");
    private static final String database = ENV.get("DB_NAME");
    private static final String url = "jdbc:mysql://" + host + "/" + database;
    private static final String user = ENV.get("DB_USER");
    private static final String password = ENV.get("DB_PASS");
    private static final int timeout = 5;
    private HikariDataSource dataSource;

    private Database() {
    }

    private static class InstanceHolder {
        private static final Database instance = new Database();
    }

    public static Database getInstance() {
        return InstanceHolder.instance;
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = dataSource.getConnection();
            if (conn.isValid(timeout)) return conn;
            throw new SQLException();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initDatabaseConnectionPool() {
        dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
    }

    public void closeDatabaseConnectionPool() {
        dataSource.close();
    }
}
