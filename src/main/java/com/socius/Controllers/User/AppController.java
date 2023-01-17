package com.socius.Controllers.User;

import com.socius.Models.Session;
import com.socius.Utils.Macros.UserPageState;
import com.socius.Utils.ViewUtils;
import com.socius.Views.AuthView;
import com.socius.Views.Factory.UserViewFactory;
import com.socius.Views.UserView;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    public Button logout;
    @FXML
    public Text logo;
    @FXML
    public Text username_text;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    private HBox userProfile;
    @FXML
    private BorderPane appContainer;
    private final Session session = Session.getInstance();

    private final ChangeListener<UserPageState> onPageStateChange = (observableValue, oldVal, newVal) -> {
        switch (newVal) {
            case PROFILE -> appContainer.setCenter(UserViewFactory.getAccountView());
            default -> appContainer.setCenter(UserViewFactory.getHomeView());
        }
    };

    private final ChangeListener<UserPageState> scrollPaneBehaviour = ((observableValue, oldVal, newVal) -> {
        scrollPane.setFitToHeight(newVal == UserPageState.PROFILE);
    });

    private final EventHandler<MouseEvent> onProfileClicked = mouseEvent -> {
        UserView.setPageState(UserPageState.PROFILE);
    };

    private final EventHandler<MouseEvent> onLogoClicked = mouseEvent -> {
        UserView.setPageState(UserPageState.HOME);
    };

    private final EventHandler<ActionEvent> logoutHdl = actionEvent -> {
        ViewUtils.getEventStage(actionEvent).close();
        AuthView.setSignInScene(new Stage());
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserView.getPageState().addListener(onPageStateChange);
        UserView.getPageState().addListener(scrollPaneBehaviour);

        username_text.setText(session.getLoggedAccount().nameProperty().get());
        userProfile.setOnMouseClicked(onProfileClicked);

        logo.setOnMouseClicked(onLogoClicked);
        logout.setOnAction(logoutHdl);
    }
}
