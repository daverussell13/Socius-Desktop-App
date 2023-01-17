package com.socius.Controllers.User;

import com.socius.Models.Event;
import com.socius.Services.EventService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private HBox cardEventContainer;
    EventService eventService = new EventService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Event> eventList = null;
        try {
            eventList = eventService.getEventObservableList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (eventList != null) {
            eventList.forEach(e -> {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Components/eventCard.fxml"));
                AnchorPane pane = null;
                try {
                    pane = loader.load();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                cardEventContainer.getChildren().add(pane);
            });
        }
    }
}
