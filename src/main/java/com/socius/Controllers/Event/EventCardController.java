package com.socius.Controllers.Event;

import com.socius.Models.Event;
import com.socius.Utils.StringUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class EventCardController implements Initializable {
    @FXML
    private Text event_datetime;
    @FXML
    private Label event_description;
    @FXML
    private Text event_joined_user;
    @FXML
    private Text event_name;
    @FXML
    private Text event_organizer;
    private final Event event;

    public EventCardController(Event event) {
        this.event = event;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        event_datetime.setText(StringUtils.getFormattedTimestamp(this.event.eventDateTimeProperty().get()));
        event_description.setText(this.event.eventDescriptionProperty().get());
        event_joined_user.setText(String.valueOf(this.event.totalJoinedUserProperty().get()));
        event_name.setText(this.event.eventNameProperty().get());
        event_organizer.setText(this.event.eventOrganizerProperty().get());
    }
}