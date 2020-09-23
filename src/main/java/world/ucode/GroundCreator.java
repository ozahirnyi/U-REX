package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GroundCreator extends Pane {
  Image landImage;
  ImageView landImageView;
  public int landX;

  private Image randomGroundGenerator() {
    double foo = Math.random() * 100;

    if (foo > 97) return new Image("/land3.png");
    else if (foo < 4) return new Image("/land1.png");
    else return new Image("/land2.png");
  }

  private void groundCreator() {
    landImage = randomGroundGenerator();
    landImageView = new ImageView(landImage);

    setTranslateY(730);
    getChildren().add(landImageView);
  }

  GroundCreator(int x) {
    landX = x;
    groundCreator();
  }
}
