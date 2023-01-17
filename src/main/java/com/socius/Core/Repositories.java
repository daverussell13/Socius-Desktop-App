package com.socius.Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Repositories {
    protected PreparedStatement stmt;
    protected ResultSet rs;

    protected Repositories() {
        this.stmt = null;
        this.rs = null;
    }

    protected void closeStatement() {
        if (this.stmt != null) {
            try {
                this.stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closeResultSet() {
        if (this.rs != null) {
            try {
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closeAll() {
        closeResultSet();
        closeStatement();
    }

    protected Connection getConnection() {
        return Database.getInstance().getConnection();
    }
}
