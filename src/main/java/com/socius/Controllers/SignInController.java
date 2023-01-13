package com.socius.Controllers;

import com.socius.Utils.ViewUtils;
import com.socius.Views.AuthView;
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

    private final EventHandler<ActionEvent> signUpHyperHdl = actionEvent -> {
        Stage stage = ViewUtils.getEventStage(actionEvent);
        AuthView.setSignUpScene(stage);
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sign_up_hyperlink.setOnAction(signUpHyperHdl);
    }
}
