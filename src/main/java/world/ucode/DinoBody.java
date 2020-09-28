package world.ucode;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class DinoBody extends Pane{
  private static final Image IMAGE = new Image("dino-body.png");
  private static final int COLUMNS = 1;
  private static final int COUNT = 4;
  private static final int OFFSET_X = 0;
  private static final int OFFSET_Y = 0;
  private static final int WIDTH = 88;
  private static final int HEIGHT = 143;
  public int landY = 451;

  public void activator() {
    final ImageView imageView = new ImageView(IMAGE);
    imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
    final Animation animation =
        new spriteAnimation(
            imageView, Duration.millis(900),
                COUNT, COLUMNS, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);
    animation.setCycleCount(Animation.INDEFINITE);
    animation.play();
    setTranslateX(25);
    setTranslateY(landY);
    getChildren().add(imageView);
  }
}
