package com.socius.Views;

import com.socius.Utils.ViewUtils;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AuthView {
    private static AuthView instance = null;
    private Scene signUpScene;
    private Scene signInScene;

    private AuthView() {
        signInScene = null;
        signUpScene = null;
    }

    public static AuthView getInstance(){
        if (instance == null)  {
           instance = new AuthView();
        }
        return instance;
    }

    private void loadSignUpScene() {
        signUpScene = ViewUtils.createScene("/Fxml/Pages/signUp.fxml");
    }

    private void loadSignInScene() {
        signInScene = ViewUtils.createScene("/Fxml/Pages/signIn.fxml");
    }

    public Scene getSignUpScene() {
        if (signUpScene == null) loadSignUpScene();
        return signUpScene;
    }

    public Scene getSignInScene() {
        if (signInScene == null) loadSignInScene();
        return signInScene;
    }

    public void setSignUpScene(Stage stage) {
        stage.setScene(getSignUpScene());
        stage.setTitle("Sign Up");
        stage.setResizable(false);
        stage.show();
    }

    public void setSignInScene(Stage stage) {
        stage.setScene(getSignInScene());
        stage.setTitle("Sign In");
        stage.setResizable(false);
        stage.show();
    }
}
