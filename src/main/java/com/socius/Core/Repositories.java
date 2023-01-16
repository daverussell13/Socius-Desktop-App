package com.socius.Core;

import java.sql.*;

public class Repositories {
    protected Connection conn;
    protected PreparedStatement stmt;
    protected ResultSet rs;

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

    public void closeConnection() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closeAll() {
        this.closeStatement();
        this.closeResultSet();
    }
}
