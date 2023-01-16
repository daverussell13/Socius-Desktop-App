package com.socius.Views;

import com.socius.Utils.Macros.UserPageState;
import com.socius.Utils.ViewUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class UserView {
    private static final ObjectProperty<UserPageState> pageState = new SimpleObjectProperty<>();
    private static Scene appLayout = null;

    private static void loadAppLayout() {
        appLayout = ViewUtils.createScene("/Fxml/User/appLayout.fxml");
    }

    public static Scene getAppLayout() {
        if (appLayout == null) loadAppLayout();
        return appLayout;
    }

    public static void setAppScene(Stage stage) {
        stage.setTitle("Socius App");
        stage.setScene(getAppLayout());
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.setMinWidth(1300);
        stage.setMinHeight(600);
        stage.show();
    }

    public static ObjectProperty<UserPageState> getPageState() {
        return pageState;
    }

    public static void setPageState(UserPageState state) {
        pageState.set(state);
    }
}

