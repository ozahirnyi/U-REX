package world.ucode;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class newGame {
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
