package com.socius;

import com.socius.Core.Database;
import com.socius.Views.AuthView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private static final Database db = Database.getInstance();

    @Override
    public void start(Stage mainStage) {
        AuthView.setSignInScene(mainStage);
    }

    public static void main(String[] args) {
        try {
            db.openConnection();
            launch(args);
        } finally {
            db.closeConnection();
        }
    }
}
