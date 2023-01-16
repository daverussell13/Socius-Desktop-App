package com.socius;

import com.socius.Core.Database;
import com.socius.Views.AuthView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class App extends Application {
    private static final Database db = Database.getInstance();

    @Override
    public void start(Stage mainStage) throws SQLException {
        AuthView.setSignInScene(mainStage);
    }

    public static void main(String[] args) {
        try {
            db.initDatabaseConnectionPool();
            launch(args);
        } finally {
            db.closeDatabaseConnectionPool();
        }
    }
}
