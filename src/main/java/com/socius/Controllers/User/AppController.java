package com.socius.Controllers.User;

import com.socius.Utils.UserPageState;
import com.socius.Views.Factory.UserViewFactory;
import com.socius.Views.UserView;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    public Text logo;
    @FXML
    private HBox userProfile;
    @FXML
    private BorderPane appContainer;

    private final ChangeListener<UserPageState> onPageStateChange = (observableValue, oldVal, newVal) -> {
        switch (newVal) {
            case PROFILE -> appContainer.setCenter(UserViewFactory.getAccountView());
            default -> appContainer.setCenter(UserViewFactory.getHomeView());
        }
    };

    private final EventHandler<MouseEvent> onProfileClicked = mouseEvent -> {
        UserView.setPageState(UserPageState.PROFILE);
    };

    private final EventHandler<MouseEvent> onLogoClicked = mouseEvent -> {
        UserView.setPageState(UserPageState.HOME);
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserView.getPageState().addListener(onPageStateChange);
        userProfile.setOnMouseClicked(onProfileClicked);
        logo.setOnMouseClicked(onLogoClicked);
    }
}
