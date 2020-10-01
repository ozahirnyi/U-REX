package world.ucode;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.InputStream;
import javafx.scene.control.Button;

public class Main extends Application {
    static public Pane root = new Pane();
    static public Scene scene = new Scene(root, 1200, 600);
    static public Stage primStage;
    static public Button newGameButton = new Button();
    static public boolean newGame = true;
    static public int maxLandX;
    static public double speed = 1;
    static public int lastLand = 1000;

    public void mainIcon(Stage primaryStage) {
        InputStream mainIconStream = getClass().getResourceAsStream("/main_icon.png");
        Image mainIconImage = new Image(mainIconStream);
        primaryStage.getIcons().add(mainIconImage);
    }

    private void setTitle(Stage primaryStage) {
        primaryStage.setTitle("Dino");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainIcon(primaryStage);
        setTitle(primaryStage);
        primStage = primaryStage;
        WindowCreator windowCreator = new WindowCreator();
        windowCreator.sceneCreator();

        newGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().remove(newGameButton);
                newGame = true;
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}