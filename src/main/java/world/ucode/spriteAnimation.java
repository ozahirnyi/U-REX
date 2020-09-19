package world.ucode;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class spriteAnimation extends Transition {
    private ImageView imageView;
    private final int count;
    private final int columns;
    private final int offsetX;
    private final int offsetY;
    private final int width;
    private final int height;
    private int lastIndex;

    public spriteAnimation(
            ImageView imageView,
            Duration duration,
            int count,   int columns,
            int offsetX, int offsetY,
            int width,   int height) {
        this.imageView = imageView;
        this.count     = count;
        this.columns   = columns;
        this.offsetX   = offsetX;
        this.offsetY   = offsetY;
        this.width     = width;
        this.height    = height;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    protected void interpolate(double k) {
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            final int x = (index % count) * width  + offsetX;
            final int y = 1;
            System.out.println(Integer.toString(x));
            System.out.println(Integer.toString(y));
            System.out.println(Integer.toString(index));
            System.out.println(Double.toString(k));
            imageView.setViewport(new Rectangle2D(x, y, width, height));
            lastIndex = index;
        }
    }
}