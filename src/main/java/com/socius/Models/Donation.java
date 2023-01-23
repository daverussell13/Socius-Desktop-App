package com.socius.Models;

import javafx.beans.property.*;

import java.sql.Time;
import java.sql.Timestamp;

public class Donation {
    private final IntegerProperty donationId;
    private final IntegerProperty creatorId;
    private final StringProperty donationName;
    private final StringProperty donationDescription;
    private final ObjectProperty<Timestamp> donationDateTime;
    private final StringProperty donationOrganizer;
    private final IntegerProperty totalFundRaised;
    private final ObjectProperty<Timestamp> createdAt;
    private final ObjectProperty<Timestamp> deletedAt;

    public Donation(
            Integer donationId,
            Integer creatorId,
            String donationName,
            String donationDesc,
            Timestamp donationDatetime,
            String donationOrganizer,
            Integer totalFundRaised,
            Timestamp createdAt,
            Timestamp deletedAt
    ) {
        this.donationId = new SimpleIntegerProperty(this, "Donation Id", donationId);
        this.creatorId = new SimpleIntegerProperty(this, "Creator Id", creatorId);
        this.donationName = new SimpleStringProperty(this, "Donation Name", donationName);
        this.donationDescription = new SimpleStringProperty(this, "Donation Description", donationDesc);
        this.donationDateTime = new SimpleObjectProperty<>(this, "Event Datetime", donationDatetime);
        this.donationOrganizer = new SimpleStringProperty(this, "Donation Organizer", donationOrganizer);
        this.totalFundRaised = new SimpleIntegerProperty(this, "Total Fund Raised", totalFundRaised);
        this.createdAt = new SimpleObjectProperty<>(this, "Created At", createdAt);
        this.deletedAt = new SimpleObjectProperty<>(this, "Deleted At", deletedAt);
    }
    public IntegerProperty donationIdProperty() {
        return donationId;
    }
    public IntegerProperty creatorIdProperty() {
        return creatorId;
    }

    public StringProperty donationNameProperty() {
        return donationName;
    }

    public StringProperty donationDescriptionProperty() {
        return donationDescription;
    }

    public ObjectProperty<Timestamp> donationDateTimeProperty() {
        return donationDateTime;
    }

    public StringProperty donationOrganizerProperty() {
        return donationOrganizer;
    }

    public IntegerProperty totalFundRaisedProperty() {
        return totalFundRaised;
    }

    public ObjectProperty<Timestamp> createdAtProperty() {
        return createdAt;
    }

    public ObjectProperty<Timestamp> deletedAtProperty() {
        return deletedAt;
    }
}
