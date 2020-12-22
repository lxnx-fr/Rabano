package de.laurinfrank.fxml;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.laurinfrank.EncerraPass;
import javafx.animation.PathTransition;
import javafx.css.converter.PaintConverter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.regex.Pattern;

/**
 * EncerraPass: de.laurinfrank.fxml.SignInController
 * created on 21 Dezember 2020
 * by Laurin Noel Frank
 **/
public class SignInController {

    @FXML
    private PasswordField signInSecretKey;
    @FXML
    private PasswordField signInPassword;
    @FXML
    private TextField signInMail;
    @FXML
    private Button signInButton;
    @FXML
    private MaterialDesignIconView signInMailIcon;
    @FXML
    private MaterialDesignIconView signInPasswordIcon;
    @FXML
    private MaterialDesignIconView signInSecretKeyIcon;


    @FXML
    private void signIn(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            checkCredentials();
        }
    }

    private void failureTransiton(Node node, Runnable start, Runnable end) {
        start.run();
        Path path = new Path();
        path.getElements().add(new MoveTo(200, 10));
        path.getElements().add(new HLineTo(205));
        path.getElements().add(new HLineTo(195));
        path.getElements().add(new ClosePath());
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(0.5));
        pathTransition.setNode(node);
        pathTransition.setPath(path);
        pathTransition.setOnFinished(event -> end.run());
        pathTransition.play();
    }

    public static boolean validateEmailAddress(String emailID) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(emailID).matches();
    }

    public void checkCredentials() {
        if (this.signInMail.getText().isEmpty() || !validateEmailAddress(this.signInMail.getText())) {
            failureTransiton(signInMail, () -> {
                this.signInMailIcon.setIcon(MaterialDesignIcon.ALERT_CIRCLE);
                this.signInMailIcon.setFill(Color.rgb(171, 56, 56));
                this.signInMail.setStyle("-fx-border-color: rgb(171,56,56);");
            }, () -> {
                this.signInMailIcon.setIcon(MaterialDesignIcon.EMAIL);
                this.signInMailIcon.setFill(Color.WHITE);
                this.signInMail.setStyle("-fx-border-color: white;"); });
        }
        if (this.signInPassword.getText().isEmpty()) {
            failureTransiton(signInPassword, () -> {
                this.signInPasswordIcon.setIcon(MaterialDesignIcon.ALERT_CIRCLE);
                this.signInPasswordIcon.setFill(Color.rgb(171, 56, 56));
                this.signInPassword.setStyle("-fx-border-color: rgb(171, 56, 56);");
            }, () -> {
                this.signInPasswordIcon.setIcon(MaterialDesignIcon.LOCK_OUTLINE);
                this.signInPasswordIcon.setFill(Color.WHITE);
                this.signInPassword.setStyle("-fx-border-color: white;"); });
        }
        if (this.signInSecretKey.getText().isEmpty()) {
            failureTransiton(signInSecretKey, () -> {
                this.signInSecretKeyIcon.setIcon(MaterialDesignIcon.ALERT_CIRCLE);
                this.signInSecretKeyIcon.setFill(Color.rgb(171, 56, 56));
                this.signInSecretKey.setStyle("-fx-border-color: rgb(171, 56, 56);");
            }, () -> {
                this.signInSecretKeyIcon.setIcon(MaterialDesignIcon.KEY);
                this.signInSecretKeyIcon.setFill(Color.WHITE);
                this.signInSecretKey.setStyle("-fx-border-color: white;");});
        }
    }
}
