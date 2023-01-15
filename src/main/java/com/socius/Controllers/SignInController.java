package com.socius.Controllers;

import com.socius.Utils.ViewUtils;
import com.socius.Views.AuthView;
import com.socius.Views.User.AppView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    @FXML
    public TextField username_field;
    @FXML
    public PasswordField password_field;
    @FXML
    public Button signIn_btn;
    @FXML
    public Hyperlink sign_up_hyperlink;
    private final AuthView authView = AuthView.getInstance();
    private final AppView userView = com.socius.Views.User.AppView.getInstance();

    private final EventHandler<ActionEvent> signUpHyperHdl = actionEvent -> {
        Stage stage = ViewUtils.getEventStage(actionEvent);
        authView.setSignUpScene(stage);
    };

    private final EventHandler<ActionEvent> signInHdl = actionEvent -> {
        Stage stage = ViewUtils.getEventStage(actionEvent);
        userView.setAppScene(stage);
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sign_up_hyperlink.setOnAction(signUpHyperHdl);
        signIn_btn.setOnAction(signInHdl);
    }
}
