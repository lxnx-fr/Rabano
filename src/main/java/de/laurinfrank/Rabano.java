package de.laurinfrank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @author lxnx.fr
 * @version 0.1
 * @website laurinfrank.de
 */

public class Rabano extends Application {
    private static Parent parent;
    private static Scene scene;
    private double xOffset = 0.0D;
    private double yOffset = 0.0D;

    public Rabano() {
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Rabano.class.getResource("/de/laurinfrank/fxml/" + fxml + ".fxml"));
        return (Parent) fxmlLoader.load();
    }

    public static void main(String[] args) throws InterruptedException {
        launch(args);
    }

    public static Parent getParent() {
        return parent;
    }

    public static Scene getScene() {
        return scene;
    }

    public void start(Stage stage) throws InterruptedException, IOException {
        parent = loadFXML("main");
        scene = new Scene(parent);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        Image logo = new Image("/de/laurinfrank/fxml/img/logo.png");
        stage.getIcons().setAll(logo);
        scene.getWindow().centerOnScreen();
        stage.setTitle("Rabano");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        createDraggabbility();
    }

    public void createDraggabbility() {
        parent.setOnMousePressed(event -> {
            this.xOffset = event.getSceneX();
            this.yOffset = event.getSceneY();
        });
        parent.setOnMouseDragged(event -> {
            scene.getWindow().setX(event.getScreenX() - Rabano.this.xOffset);
            scene.getWindow().setY(event.getScreenY() - Rabano.this.yOffset);
        });
    }
}
