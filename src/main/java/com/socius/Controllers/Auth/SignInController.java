package com.socius.Controllers.Auth;

import com.socius.Models.Account;
import com.socius.Models.Session;
import com.socius.Request.SignInRequest;
import com.socius.Services.AccountService;
import com.socius.Utils.ViewUtils;
import com.socius.Views.AuthView;
import com.socius.Views.UserView;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    @FXML
    private TextField username_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Button signIn_btn;
    @FXML
    private Hyperlink sign_up_hyperlink;
    private final Session session = Session.getInstance();

    private final EventHandler<ActionEvent> signUpHyperHdl = actionEvent -> {
        Stage stage = ViewUtils.getEventStage(actionEvent);
        AuthView.setSignUpScene(stage);
    };

    private final EventHandler<ActionEvent> signInHdl = actionEvent -> {
        AccountService accService = new AccountService();
        try {
            SignInRequest request = new SignInRequest(
                    username_field.getText(),
                    password_field.getText()
            ).validate();
            Account acc = accService.signIn(request);
            if (acc != null) {
                session.setLoggedAccount(acc);
                ViewUtils.getEventStage(actionEvent).close();
                UserView.setAppScene(new Stage());
            }
        } catch (SQLException e) {
            ViewUtils.showErrorAlert("DB Error : Failed to login");
        } catch (Exception e) {
            ViewUtils.showErrorAlert(e.getMessage());
        } finally {
            clearForm();
        }
    };

    private void clearForm() {
        username_field.clear();
        password_field.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sign_up_hyperlink.setOnAction(signUpHyperHdl);
        signIn_btn.setOnAction(signInHdl);
    }
}
