module com.socius {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.socius to javafx.fxml;
    opens com.socius.Controllers to javafx.fxml;
    exports com.socius;
    exports com.socius.Controllers;
    exports com.socius.Controllers.User;
    opens com.socius.Controllers.User to javafx.fxml;
}