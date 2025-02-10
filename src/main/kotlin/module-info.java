module JavaFX {
    requires kotlin.stdlib;  // Required for Kotlin-based JavaFX projects
    requires javafx.base;    // Base module (core JavaFX functionalities)
    requires javafx.controls; // UI elements (buttons, labels, etc.)
    requires javafx.fxml;    // FXML support (loading UI from XML files)

    opens com.korealm to javafx.fxml; // Allows JavaFX to reflectively access FXML controllers
    exports com.korealm; // Makes the package available for external use.
                        // In this case, it exports the com.korealm package,
                        // so other modules (if any) can use its public classes.
}
