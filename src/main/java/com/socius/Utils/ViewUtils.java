package com.socius.Utils;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
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
        return (Stage) ((Node)event.getSource()).getScene().getWindow();
    }
}
