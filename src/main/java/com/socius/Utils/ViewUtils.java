package com.socius.Utils;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewUtils {
    public static Scene createScene(String fxmlPath) {
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader(ViewUtils.class.getResource(fxmlPath));
            scene = new Scene(loader.load());
        } catch (IOException err) {
            err.printStackTrace();
        }
        return scene;
    }

    public static Stage getEventStage(Event event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    public static void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }

    public static void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.setContentText(message);
        alert.show();
    }
}
