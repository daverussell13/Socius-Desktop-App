package com.socius;

import com.socius.Views.AuthView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AuthView.setSignInScene(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
