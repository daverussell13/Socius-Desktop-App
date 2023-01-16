package com.socius.Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Repositories {
    protected Connection conn;
    protected PreparedStatement stmt;
    protected ResultSet rs;

    protected Repositories() {
        this.conn = null;
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

    public void openConnection() {
        if (this.conn == null)
            this.conn = Database.getInstance().getConnection();
    }

    public void closeConnection() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closeStatementResult() {
        this.closeStatement();
        this.closeResultSet();
    }
}
