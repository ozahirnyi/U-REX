package world.ucode;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class newGame {
    public void windowCreator() {
        newGameBtnCreator();

        Main.root.getChildren().add(Main.newGameButton);
        Main.root.setStyle("-fx-background-color: White;");

        dinoBody dinoBody = new dinoBody();
        dinoBody.activator();
        Main.root.getChildren().add(dinoBody);

        Main.primStage.setScene(new Scene(Main.root, 1200, 800));
        Main.primStage.show();
    }

    private void newGameBtnCreator() {
        Main.newGameButton.setText("New Game");
        Main.newGameButton.setLayoutX(525);
        Main.newGameButton.setLayoutY(300);
    }

}
