package world.ucode;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Score extends Pane{
    protected Text score = new Text(970, 30, "Score: 00000");
    private int scoreDuration = 70;
    static int counter = 0;
    static Timeline timer;

    public Score() {
        this.score.setStyle("-fx-font-size: 24;");
        this.score.setFill(Color.OLIVE);
        getChildren().add(this.score);
        this.time();
    }

    protected void time() {
        timer = new Timeline(
                new KeyFrame(Duration.millis(scoreDuration), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        counter++;
                        score.setText("Score: " + String.format("%05d", counter));
                    }
                })
        );
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }
}
