module Rabano {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.commons;
    requires de.jensd.fx.glyphs.fontawesome;
    requires de.jensd.fx.glyphs.materialdesignicons;
    requires de.jensd.fx.glyphs.materialicons;

    opens de.laurinfrank to javafx.fxml;
    exports de.laurinfrank;

    opens de.laurinfrank.fxml to javafx.fxml;
    exports de.laurinfrank.fxml;

    opens de.laurinfrank.fxml.settings to javafx.fxml;
    exports de.laurinfrank.fxml.settings;
}
