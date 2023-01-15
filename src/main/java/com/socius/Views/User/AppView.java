package com.socius.Views.User;

import com.socius.Utils.ViewUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class AppView {
    private static AppView instance = null;
    private final Scene appLayout;
    private final StringProperty pageState;
    private AnchorPane homeView;
    private AnchorPane accountView;

    private AppView() {
        homeView = null;
        accountView = null;
        appLayout = ViewUtils.createScene("/Fxml/User/appLayout.fxml");
        pageState = new SimpleStringProperty("");
    }

    public static AppView getInstance(){
        if (instance == null)  {
            instance = new AppView();
        }
        return instance;
    }

    private void loadHomeView() {
        homeView = ViewUtils.createAnchorPane("/Fxml/User/home.fxml");
    }

    private void loadAccountView() {
        accountView = ViewUtils.createAnchorPane("/Fxml/User/account.fxml");
    }

    public AnchorPane getHomeView() {
        if (homeView == null) loadHomeView();
        return homeView;
    }

    public AnchorPane getAccountView() {
        if (accountView == null) loadAccountView();
        return accountView;
    }

    public void setAppScene(Stage stage) {
        stage.setTitle("App");
        stage.setScene(appLayout);
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.setMinWidth(1300);
        stage.setMinHeight(600);
        stage.show();
    }

    public StringProperty getPageState() {
        return pageState;
    }
}

