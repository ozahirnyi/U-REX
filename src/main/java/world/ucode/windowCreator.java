package world.ucode;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import java.util.ArrayList;

public class windowCreator {
    static private ArrayList<GroundCreator> lands = new ArrayList<>();
    int windowLastLand = Main.lastLand;

    public void sceneCreator() {
        newGameBtnCreator();

        Main.root.getChildren().add(Main.newGameButton);

        dinoBody dinoBody = new dinoBody();
        dinoBody.activator();
        Main.root.getChildren().add(dinoBody);

        for (int i = 0; i < Main.lastLand; i++) {
            GroundCreator groundCreator = new GroundCreator(71 * i);
            lands.add(groundCreator);
        }
        Main.maxLandX = 71 * 98;
        Main.root.getChildren().addAll(lands);
        dinoBody.toFront();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
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
        };

        animationTimer.start();

        Main.primStage.setScene(new Scene(Main.root, 1200, 800));
        Main.primStage.show();
    }

    private void newGameBtnCreator() {
        Main.newGameButton.setText("New Game");
        Main.newGameButton.setLayoutX(525);
        Main.newGameButton.setLayoutY(300);
    }

}
