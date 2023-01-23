package com.socius.Services;

import com.socius.Models.Donation;
import com.socius.Repositories.DonationRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;


public class DonationService {
    private final DonationRepository donationRepo;

    public DonationService() {
        this.donationRepo = new DonationRepository();
    }

    public ObservableList<Donation> getDonationObservableList() throws SQLException {
        ArrayList<Donation> donationList = donationRepo.getAllDonations();
        return donationList.isEmpty() ? null : FXCollections.observableArrayList(donationList);
    }
}
