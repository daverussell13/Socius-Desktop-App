package com.socius.Views.Factory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class UserViewFactory {
    private static AnchorPane homeView = null;
    private static AnchorPane accountView = null;

    public static AnchorPane getHomeView() {
        if (homeView == null) {
           try {
               homeView = new FXMLLoader(UserViewFactory.class.getResource("/Fxml/User/home.fxml")).load();
           } catch (Exception e) {
               e.printStackTrace();
           }
        }
        return homeView;
    }

    public static AnchorPane getAccountView() {
        if (accountView == null) {
            try {
                accountView = new FXMLLoader(UserViewFactory.class.getResource("/Fxml/User/account.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return accountView;
    }
}
