package com.socius.Views;

import com.socius.Utils.ViewUtils;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AuthView {
    public static Scene scene = null;
    public static void setSignUpScene(Stage stage) {
       scene = ViewUtils.createScene("/Fxml/Pages/signUp.fxml") ;
       stage.setTitle("Sign Up");
       stage.setScene(scene);
       stage.setResizable(false);
       stage.show();
    }

    public static void setSignInScene(Stage stage) {
        scene = ViewUtils.createScene("/Fxml/Pages/signIn.fxml") ;
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
