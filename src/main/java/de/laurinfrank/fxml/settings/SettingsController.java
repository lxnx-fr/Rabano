package de.laurinfrank.fxml.settings;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.laurinfrank.Rabano;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    public Pane activeTab;
    @FXML
    public Pane tabBar;

    @FXML
    public Pane pane;
    @FXML
    public MaterialDesignIconView minimizeBtnLine;
    @FXML
    public MaterialDesignIconView minimizeBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void onClose(MouseEvent event) throws IOException {
        if (event.getButton() == MouseButton.PRIMARY)
            Platform.exit();
    }

    @FXML
    private void onMinimize(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY)
            ((Stage) Rabano.getScene().getWindow()).setIconified(true);
    }

    @FXML
    private void onHome(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            pane.getChildren().removeAll();
            try {
                pane.getChildren().setAll(Rabano.loadFXML("main"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            FadeTransition ft = new FadeTransition(Duration.millis(350), pane);
            ft.setFromValue(0.0);
            ft.setToValue(1);
            ft.play();
        }
    }

    @FXML
    private void onServices(MouseEvent event) {
        changeTab("settings/services");
    }

    @FXML
    private void onExport(MouseEvent event) {
        changeTab("settings/export");
    }

    @FXML
    private void onSync(MouseEvent event) {
        changeTab("settings/sync");
    }

    private void changeTab(String s) {
        activeTab.getChildren().removeAll();
        try {
            activeTab.getChildren().setAll(Rabano.loadFXML(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        FadeTransition ft = new FadeTransition(Duration.millis(400), activeTab);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
    }
}
