package com.socius.Repositories;

import com.socius.Core.Repositories;
import com.socius.Models.Event;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventRepository extends Repositories {
    public EventRepository() {
        super();
    }

    public ArrayList<Event> getAllEvents() throws SQLException {
        try (Connection conn = this.getConnection()) {
            String query = """
                    SELECT * FROM events
                    """;
            ArrayList<Event> eventList = new ArrayList<>();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                eventList.add(new Event(
                        rs.getInt("event_id"),
                        rs.getInt("creator_id"),
                        rs.getString("event_name"),
                        rs.getString("event_description"),
                        rs.getTimestamp("event_datetime"),
                        rs.getString("event_organizer"),
                        rs.getInt("total_joined_user"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("deleted_at")
                ));
            }
            return eventList;
        } finally {
            this.closeAll();
        }
    }
}
