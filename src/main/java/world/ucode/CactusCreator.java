package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CactusCreator extends Pane {
    Image cactusImage;
    ImageView cactusImageView;
    public double cactusX;

    private Image randomCactusGenerator() {
        double foo = Math.random() * 100;

        if (foo > 66) return new Image("cactus1.png");
        else if (foo < 33) return new Image("cactus2.png");
        else return new Image("cactus3.png");
    }

    CactusCreator(int lastCactusX) {
//    System.out.println(Integer.toString(lastCactusX));
        cactusX = WindowCreator.cactusXgenerator(lastCactusX);
        cactusImage = randomCactusGenerator();
        cactusImageView = new ImageView(cactusImage);

        setTranslateY(473);
        cactusImageView.setFitWidth(cactusImage.getWidth() * 1.75);
        cactusImageView.setFitHeight(74);
//        getChildren().add(cactusImageView);lol kek cheburek
        getChildren().add(cactusImageView);
    }
}
