//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package de.laurinfrank.fxml;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.laurinfrank.Rabano;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private VBox vbox;
    @FXML
    public MaterialDesignIconView minimizeBtnLine;
    @FXML
    public MaterialDesignIconView minimizeBtn;
    @FXML
    private Pane pane;
    @FXML
    private MaterialDesignIconView settingsBtn;
    @FXML
    private MaterialDesignIconView closeBtn;
    @FXML
    private MaterialDesignIconView closeBtnX;
    @FXML
    private Button importSpotifyBtn;
    @FXML
    private Button importTidalBtn;
    @FXML
    private Button importAppleMusicBtn;
    @FXML
    private Button importFileBtn;
    private boolean isAnimating = false;

    public MainController() {
    }

    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void openSignUp(ActionEvent event) {
    }

    @FXML
    private void onClose(MouseEvent event) throws IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Platform.exit();
        }

    }

    @FXML
    private void onMinimize(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            ((Stage) Rabano.getScene().getWindow()).setIconified(true);
        }

    }

    @FXML
    private void onSettings(MouseEvent event) throws IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            this.pane.getChildren().removeAll(new Node[0]);
            this.pane.getChildren().setAll(new Node[]{Rabano.loadFXML("settings/settings")});
            FadeTransition ft = new FadeTransition(Duration.millis(350.0D), this.pane);
            ft.setFromValue(0.0D);
            ft.setToValue(1.0D);
            ft.play();
        }

    }
}
