package com.socius.Services;

import com.socius.Models.Event;
import com.socius.Repositories.EventRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class EventService {
    private final EventRepository eventRepo;

    public EventService() {
        this.eventRepo = new EventRepository();
    }

    public ObservableList<Event> getEventObservableList() throws SQLException {
        ArrayList<Event> eventList = eventRepo.getAllEvents();
        return eventList.isEmpty() ? null : FXCollections.observableArrayList(eventList);
    }
}
