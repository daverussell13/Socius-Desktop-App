module com.socius {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires io.github.cdimascio.dotenv.java;
    requires com.zaxxer.hikari;
    requires org.slf4j;
    requires bcrypt;

    opens com.socius to javafx.fxml;
    exports com.socius;
    exports com.socius.Controllers.User;
    opens com.socius.Controllers.User to javafx.fxml;
    exports com.socius.Controllers.Auth;
    opens com.socius.Controllers.Auth to javafx.fxml;
}