package com.socius.Controllers;

import com.socius.Utils.ViewUtils;
import com.socius.Views.AuthView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    public Hyperlink sign_in_hyperlink;
    @FXML
    private CheckBox agreement_checkbox;
    @FXML
    private TextField email_field;
    @FXML
    private TextField name_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Button signUp_btn;
    @FXML
    private TextField username_field;
    private final AuthView authView = AuthView.getInstance();

    EventHandler<ActionEvent> signInHyperHdl = actionEvent ->  {
        Stage stage = ViewUtils.getEventStage(actionEvent);
        authView.setSignInScene(stage);
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sign_in_hyperlink.setOnAction(signInHyperHdl);
    }
}
