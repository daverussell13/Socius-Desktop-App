package com.socius.Repositories;

import com.socius.Core.Repositories;
import com.socius.Models.Donation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class DonationRepository extends Repositories {
    public DonationRepository() {
        super();
    }

    public ArrayList<Donation> getAllDonations() throws SQLException {
        try (Connection conn = this.getConnection()) {
            String query = """
                    SELECT * FROM donations
                    """;
            ArrayList<Donation> donationList = new ArrayList<>();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                donationList.add(new Donation(
                        rs.getInt("donation_id"),
                        rs.getInt("creator_id"),
                        rs.getString("donation_name"),
                        rs.getString("donation_description"),
                        rs.getTimestamp("donation_datetime"),
                        rs.getString("donation_organizer"),
                        rs.getInt("total_fund_raised"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("deleted_at")
                ));
            }
            return donationList;
        } finally {
            this.closeAll();
        }
    }
}
