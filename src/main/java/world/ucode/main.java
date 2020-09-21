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
    static public Stage primStage;
    static public Button newGameButton = new Button();

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

        newGame newGame = new newGame();
        newGame.windowCreator();

        newGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setStyle("-fx-background-color: Red;");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}