package com.socius.Views.Factory;

import com.socius.Controllers.Event.EventCardController;
import com.socius.Models.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class EventCardFactory extends ListCell<Event> {
    @Override
    protected void updateItem(Event event, boolean empty) {
        super.updateItem(event, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Components/eventCard.fxml"));
            EventCardController controller = new EventCardController(event);
            loader.setController(controller);
            try {
                setText(null);
                setGraphic(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
