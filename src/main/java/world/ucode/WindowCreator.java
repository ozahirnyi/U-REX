package world.ucode;

import javafx.animation.AnimationTimer;
import java.util.ArrayList;
import javafx.scene.input.KeyCode;

public class WindowCreator {
    static final private ArrayList<GroundCreator> lands = new ArrayList<>();
    int windowLastLand = Main.lastLand;
    private int dinoMaxJump = 0;
    private int dinoGravity = 1;

    public void sceneCreator() {
        newGameBtnCreator();

        Main.root.getChildren().add(Main.newGameButton);

        DinoBody dinoBody = new DinoBody();
        dinoBody.activator();
        Main.root.getChildren().add(dinoBody);

        landsCreator();
        dinoBody.toFront();

    AnimationTimer animationTimer =
        new AnimationTimer() {
          @Override
          public void handle(long now) {
            Main.scene.setOnKeyPressed(
                event -> {
                  KeyCode keyCode = event.getCode();

                  if ((keyCode.equals(keyCode.SPACE) || keyCode.equals(keyCode.UP))
                      && dinoBody.getTranslateY() == dinoBody.landY) dinoJump(dinoBody);
                });
            dinoBody.setTranslateY(dinoBody.getTranslateY() - dinoMaxJump);
            dinoDown(dinoBody);
            if (dinoBody.getTranslateY() >= dinoBody.landY) {
              dinoMaxJump = 0;
              dinoBody.setTranslateY(dinoBody.landY);
            }
            landsMover();
          }
        };

        animationTimer.start();

        Main.scene.setRoot(Main.root);
        Main.primStage.setScene(Main.scene);
        Main.primStage.show();
    }

    private void dinoJump(DinoBody dinoBody) {
        dinoBody.setTranslateY(dinoBody.getTranslateY() - dinoMaxJump);
        dinoMaxJump = 20;
    }

    private void dinoDown(DinoBody dinoBody) {
        dinoMaxJump -= dinoGravity;
    }

    private void cactusMover() {

    }

    private void landsMover() {
        for (int i = 0; i < lands.size(); i++) {
            GroundCreator land = lands.get(i);
            land.landX -= 10 * Main.speed;
            if (land.landX < -71)
                land.landX = Main.maxLandX;
            land.setTranslateX(land.landX);
        }
        windowLastLand--;
        if (windowLastLand == 0) {
            Main.speed += 0.03;
            windowLastLand = Main.lastLand;
        }
    }

    private void cactusCreator() {
        for (int i = 0; i < 34; i++) {

        }
    }

    private void landsCreator() {
        for (int i = 0; i < Main.lastLand; i++) {
            GroundCreator groundCreator = new GroundCreator(66 * i);
            lands.add(groundCreator);
        }
        Main.maxLandX = 66 * 98;
        Main.root.getChildren().addAll(lands);
    }

    private void newGameBtnCreator() {
        Main.newGameButton.setText("New Game");
        Main.newGameButton.setLayoutX(525);
        Main.newGameButton.setLayoutY(300);
    }

}
