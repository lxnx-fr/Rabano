package de.laurinfrank.fxml;

import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.laurinfrank.EncerraPass;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * EncerraPass: de.laurinfrank.fxml.MainController
 * created on 19 Dezember 2020
 * by Laurin Noel Frank
 **/
public class MainController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private Parent fxml;
    @FXML
    private MaterialIconView closeIcon;

    private boolean isAnimating = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(0.7), vbox);
        t.setToX(vbox.getLayoutX() * 13.2);
        vboxAnimation(t, "sign_in.fxml");
    }
    @FXML
    private void openSignIn(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.2), vbox);
        t.setToX(vbox.getLayoutX() * 13.2);
        vboxAnimation(t, "sign_in.fxml");
    }

    private void vboxAnimation(TranslateTransition t, String file) {
        if (!isAnimating) {
            isAnimating = true;
            t.play();
            t.setOnFinished((e) -> {
                try {
                    fxml = new FXMLLoader(EncerraPass.class.getResource(file)).load();
                    vbox.getChildren().removeAll();
                    vbox.getChildren().setAll(fxml);
                    isAnimating = false;
                } catch (IOException ex) {
                }
            });
        }
    }

    @FXML
    private void openSignUp(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.2), vbox);
        t.setToX(0);
        vboxAnimation(t, "sign_up.fxml");
    }

    @FXML
    private void close(MouseEvent event) throws IOException {
        if (event.getButton() == MouseButton.PRIMARY)
            Platform.exit();
    }



}
