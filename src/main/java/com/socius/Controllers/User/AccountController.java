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
    public Text account_name;
    @FXML
    public Text account_email;
    @FXML
    public Text account_role;
    @FXML
    public TextField input_name;
    @FXML
    public TextField input_username;
    @FXML
    public TextField input_email;
    @FXML
    public TextField input_pass;
    @FXML
    public Button update_btn;
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
