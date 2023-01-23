package com.socius.Views.Donation;

import com.socius.Controllers.Donation.DonationCardController;
import com.socius.Models.Donation;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class DonationCardFactory extends ListCell<Donation> {
    @Override
    protected void updateItem(Donation donation, boolean empty) {
        super.updateItem(donation, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            // TODO: donationCard.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Components/donationCard.fxml"));
            DonationCardController controller = new DonationCardController();
            loader.setController(controller);
            setText("test");
            setGraphic(null);
        }
    }
}
