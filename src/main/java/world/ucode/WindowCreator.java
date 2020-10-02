package world.ucode;

import javafx.animation.AnimationTimer;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

public class WindowCreator {
    static final private ArrayList<GroundCreator> lands = new ArrayList<>();
    static final private ArrayList<CactusCreator> cactuses = new ArrayList<>();
    static private Button replayBtn = new Button();
    AnimationTimer animationTimer;
    static public int lastCactusX = 40;
    int windowLastLand = Main.lastLand;
    private int dinoMaxJump = 0;
    static final private int dinoGravity = 1;
    private DinoBody dinoBody = new DinoBody();
    private Score score = new Score();

    public void sceneCreator() {
    if (Main.newGame == true) {
      Main.root.getChildren().add(score);

      newGameBtnCreator();

      Main.root.getChildren().add(Main.newGameButton);

      dinoBody.activator();
      Main.root.getChildren().add(dinoBody);

      landsCreator();
      cactusesCreator();
      dinoBody.toFront();
    }
    animationTimer =
        new AnimationTimer() {
          @Override
          public void handle(long now) {
            Main.scene.setOnKeyPressed(
                event -> {
                  KeyCode keyCode = event.getCode();
                  if ((keyCode.equals(keyCode.SPACE) || keyCode.equals(keyCode.UP))
                      && dinoBody.getTranslateY() == dinoBody.landY) {
                    dinoJump(dinoBody);
                    Main.speed = 1;
                  }
                });
            dinoBody.setTranslateY(dinoBody.getTranslateY() - dinoMaxJump);
            dinoDown();
            if (dinoBody.getTranslateY() >= dinoBody.landY) {
              dinoMaxJump = 0;
              dinoBody.setTranslateY(dinoBody.landY);
            }
              if (collisionCheck(dinoBody)) {
                  score.timer.stop();
                  animationTimer.stop();
                  dinoBody.animation.stop();
                  replay();
              }
              cactusMover();
              landsMover();
          }
        };

        animationTimer.start();

        Main.scene.setRoot(Main.root);
        Main.primStage.setScene(Main.scene);
        Main.primStage.show();
    }

    private void replay() {
        replayBtnCreator();
        Main.newGame = false;
        Main.root.getChildren().add(replayBtn);
        replayBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.root.getChildren().remove(replayBtn);
                score.counter = 0;
                score.timer.play();
                dinoBody.animation.play();
                sceneCreator();
            }
        });
    }

    private void dinoJump(DinoBody dinoBody) {
        dinoBody.setTranslateY(dinoBody.getTranslateY() - dinoMaxJump);
        dinoMaxJump = 20;
    }

    private void dinoDown() {
        dinoMaxJump -= dinoGravity;
    }

    private boolean collisionCheck(DinoBody dinoBody) {
        for (var it : cactuses) {
            if (dinoBody.getTranslateX() >= it.getTranslateX()
                    && dinoBody.getTranslateX() <= it.getTranslateX() + 51
                    && dinoBody.getTranslateY() + 94 >= it.getTranslateY()) {
                it.setTranslateX(it.getTranslateX() - 250);
                return true;
            }
            else if (dinoBody.getTranslateX() + 88 <= it.getTranslateX() + 49
                    && dinoBody.getTranslateX() + 88 >= it.getTranslateX()
                    && dinoBody.getTranslateY() + 94 >= it.getTranslateY()) {
                it.setTranslateX(it.getTranslateX() - 250);
                return true;
            }
        }
        return false;
    }

    private void cactusMover() {
    for (int i = 0; i < 15; i++) {
      CactusCreator cactusCreator = cactuses.get(i);
      if (cactusCreator.getTranslateX() >= -100) {
        cactusCreator.cactusX -= 10 * Main.speed;

        if (cactusCreator.cactusX < -100) {
          cactusCreator.cactusX = cactusXgenerator(lastCactusX);
          lastCactusX = (int) cactusCreator.cactusX;
        }
        cactusCreator.setTranslateX(cactusCreator.cactusX);
      }
      }
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
        if (windowLastLand == 0 && Main.speed < 2) {
            Main.speed += 0.03;
            windowLastLand = Main.lastLand;
        }
    }

    private void cactusesCreator() {
        for (int i = 0; i < 15; i++) {
            int randomXcactus = cactusXgenerator(lastCactusX + (i * 10));
            CactusCreator cactusCreator = new CactusCreator(randomXcactus);
            lastCactusX = randomXcactus;
            cactusCreator.setTranslateX(lastCactusX);
            cactuses.add(cactusCreator);
            if (i == 14)
                lastCactusX = (int)cactusCreator.cactusX;
        }
        Main.root.getChildren().addAll(cactuses);
    }

    private void landsCreator() {
        for (int i = 0; i < Main.lastLand; i++) {
            GroundCreator groundCreator = new GroundCreator(71 * i);
            lands.add(groundCreator);
        }
        Main.maxLandX = 71 * 71;
        Main.root.getChildren().addAll(lands);
    }

    private void replayBtnCreator() {
        replayBtn.setText("Replay?");
        replayBtn.setTranslateX(525);
        replayBtn.setTranslateY(300);
    }

    private void newGameBtnCreator() {
        Main.newGameButton.setText("New Game");
        Main.newGameButton.setLayoutX(525);
        Main.newGameButton.setLayoutY(300);
    }

    static public int cactusXgenerator(int lastCactusX) {
        return (int)(lastCactusX + (450 + Math.random() * 1000));
    }

}
