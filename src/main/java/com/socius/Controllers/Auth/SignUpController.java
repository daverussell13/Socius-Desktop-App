package com.socius.Controllers.Auth;

import com.socius.Models.User;
import com.socius.Services.AccountService;
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

    private final AccountService accountService = new AccountService();

    EventHandler<ActionEvent> signInHyperHdl = actionEvent -> {
        Stage stage = ViewUtils.getEventStage(actionEvent);
        AuthView.setSignInScene(stage);
    };

    EventHandler<ActionEvent> signUpHdl = actionEvent -> {
        if (!agreement_checkbox.isSelected()) {
            ViewUtils.showErrorAlert("Please read the user agreements");
            return;
        }
        User user = new User(
                null,
                username_field.getText(),
                name_field.getText(),
                email_field.getText(),
                password_field.getText(),
                null,
                null);
        try {
            if (accountService.register(user)) {
                ViewUtils.showSuccessAlert("User succesfully registered");
                ViewUtils.getEventStage(actionEvent).setScene(AuthView.getSignInScene());
            }
        } catch (Exception e) {
            ViewUtils.showErrorAlert("Failed to register");
            e.printStackTrace();
        } finally {
            clearForm();
        }
    };

    public void clearForm() {
        username_field.clear();
        email_field.clear();
        password_field.clear();
        name_field.clear();
        agreement_checkbox.setSelected(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sign_in_hyperlink.setOnAction(signInHyperHdl);
        signUp_btn.setOnAction(signUpHdl);
    }
}
