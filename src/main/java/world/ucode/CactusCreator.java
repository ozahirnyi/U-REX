package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CactusCreator extends Pane {
    Image cactusImage;
    ImageView cactusImageView;
    public int landX;

    private Image randomCactusGenerator() {
        double foo = Math.random() * 100;

        if (foo > 49) return new Image("/cactus1.png");
        else return new Image("/castus2.png");
    }

    CactusCreator(int lastCactusX) {
        landX = lastCactusX + ((int)Math.random() * 50);
        cactusImage = randomCactusGenerator();
        cactusImageView = new ImageView(cactusImage);

        setTranslateY(530);
//        getChildren().add(cactusImageView);lol kek cheburek
        getChildren().add(cactusImageView);
    }
}
