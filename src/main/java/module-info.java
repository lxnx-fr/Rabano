module de.laurinfrank {
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
}
