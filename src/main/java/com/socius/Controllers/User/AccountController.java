package com.socius.Controllers.User;

import com.socius.Models.Account;
import com.socius.Models.Admin;
import com.socius.Models.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {
    @FXML
    private Text account_name;
    @FXML
    private Text account_email;
    @FXML
    private Text account_role;
    @FXML
    private TextField input_name;
    @FXML
    private TextField input_username;
    @FXML
    private TextField input_email;
    @FXML
    private TextField input_pass;
    @FXML
    private Button update_btn;
    private final Session session = Session.getInstance();
    private final Account account = session.isAuthenticated() ? session.getLoggedAccount() : null;

    private void setUserData() {
        if (account != null) {
            account_name.setText(account.nameProperty().get());
            account_email.setText(account.emailProperty().get());
            if (account instanceof Admin) account_role.setText("Admin");
            else account_role.setText("User");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUserData();
    }
}
