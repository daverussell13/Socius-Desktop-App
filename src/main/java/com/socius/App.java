package com.socius;

import com.socius.Views.AuthView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    AuthView authView = AuthView.getInstance();

    @Override
    public void start(Stage mainStage) {
        authView.setSignUpScene(mainStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
