module com.socius {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.socius to javafx.fxml;
    opens com.socius.Controllers to javafx.fxml;
    exports com.socius;
    exports com.socius.Controllers;
}