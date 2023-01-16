package com.socius.Views;

import com.socius.Utils.ViewUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AuthView {
    private static Scene signUpScene = null;
    private static Scene signInScene = null;

    private static void loadSignUpScene() {
        signUpScene = ViewUtils.createScene("/Fxml/Pages/signUp.fxml");
    }

    private static void loadSignInScene() {
        signInScene = ViewUtils.createScene("/Fxml/Pages/signIn.fxml");
    }

    public static Scene getSignUpScene() {
        if (signUpScene == null) loadSignUpScene();
        return signUpScene;
    }

    public static Scene getSignInScene() {
        if (signInScene == null) loadSignInScene();
        return signInScene;
    }

    public static void setSignUpScene(Stage stage) {
        stage.setScene(getSignUpScene());
        stage.setTitle("Sign Up");
        stage.setResizable(false);
        stage.getIcons().add(new Image(String.valueOf(AuthView.class.getResource("/Images/Gopher.png"))));
        stage.show();
    }

    public static void setSignInScene(Stage stage) {
        stage.setScene(getSignInScene());
        stage.setTitle("Sign In");
        stage.getIcons().add(new Image(String.valueOf(AuthView.class.getResource("/Images/Gopher.png"))));
        stage.setResizable(false);
        stage.show();
    }
}
