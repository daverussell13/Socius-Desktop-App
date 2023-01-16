package com.socius.Models;

import javafx.beans.property.*;

import java.sql.Timestamp;

public class Event {
    private final IntegerProperty eventId;
    private final IntegerProperty creatorId;
    private final StringProperty eventName;
    private final StringProperty eventDescription;
    private final ObjectProperty<Timestamp> eventDateTime;
    private final StringProperty eventOrganizer;
    private final IntegerProperty totalJoinedUser;
    private final ObjectProperty<Timestamp> createdAt;
    private final ObjectProperty<Timestamp> deletedAt;

    public Event(
            Integer eventId,
            Integer creatorId,
            String eventName,
            String eventDesc,
            Timestamp eventDatetime,
            String eventOrganizer,
            Integer totalJoinedUser,
            Timestamp createdAt,
            Timestamp deletedAt
    ) {
        this.eventId = new SimpleIntegerProperty(this, "Event Id", eventId);
        this.creatorId = new SimpleIntegerProperty(this, "Creator Id", creatorId);
        this.eventName = new SimpleStringProperty(this, "Event Name", eventName);
        this.eventDescription = new SimpleStringProperty(this, "Event Description", eventDesc);
        this.eventDateTime = new SimpleObjectProperty<>(this, "Event Datetime", eventDatetime);
        this.eventOrganizer = new SimpleStringProperty(this, "Event Organizer", eventOrganizer);
        this.totalJoinedUser = new SimpleIntegerProperty(this, "Total Joined User", totalJoinedUser);
        this.createdAt = new SimpleObjectProperty<>(this, "Created At", createdAt);
        this.deletedAt = new SimpleObjectProperty<>(this, "Deleted At", deletedAt);
    }

    public IntegerProperty eventIdProperty() {
        return eventId;
    }

    public IntegerProperty creatorIdProperty() {
        return creatorId;
    }

    public StringProperty eventNameProperty() {
        return eventName;
    }

    public StringProperty eventDescriptionProperty() {
        return eventDescription;
    }

    public ObjectProperty<Timestamp> eventDateTimeProperty() {
        return eventDateTime;
    }

    public StringProperty eventOrganizerProperty() {
        return eventOrganizer;
    }

    public IntegerProperty totalJoinedUserProperty() {
        return totalJoinedUser;
    }

    public ObjectProperty<Timestamp> createdAtProperty() {
        return createdAt;
    }

    public ObjectProperty<Timestamp> deletedAtProperty() {
        return deletedAt;
    }
}
