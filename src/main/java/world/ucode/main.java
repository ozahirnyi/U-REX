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

class newGame {
    Stage primStage;
    Button gameButton;

    newGame(Stage primaryStage, Button newGameButton) {
        this.primStage = primaryStage;
        this.gameButton = newGameButton;
    }
    public void changeButtonText() {
        gameButton.setText("Game Play");
        primStage.show();
    }
}

public class Main extends Application {
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
        Button newGameBtn = new Button();
        newGameBtn.setText("New Game");

        Pane root = new Pane();
        root.getChildren().add(newGameBtn);
        root.setStyle("-fx-background-color: lightGray;");
        primaryStage.setScene(new Scene(root, 1200, 800));

        mainIcon(primaryStage);

        newGameBtn.setLayoutX(400);
        newGameBtn.setLayoutY(400);

        primaryStage.show();
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newGame changer = new newGame(primaryStage, newGameBtn);
                changer.changeButtonText();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}