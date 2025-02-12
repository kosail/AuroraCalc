module JavaFX {
    requires kotlin.stdlib;  // Required for Kotlin-based JavaFX projects
    requires javafx.base;    // Base module (core JavaFX functionalities)
    requires javafx.controls; // UI elements (buttons, labels, etc.)
    requires javafx.fxml;
    requires exp4j;

    opens com.korealm to javafx.fxml; // Allows JavaFX to reflectively access FXML controllers
    exports com.korealm;
}
