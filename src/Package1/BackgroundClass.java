package Package1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BackgroundClass extends Sprite {

    private final int StartX = 0;
    private final int StartY = -5357;
    private BufferedImage backgroundimg;

    public BackgroundClass() {
        try {
            backgroundimg = ImageIO.read(getClass().getResource("pic/longbackground.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setImage(backgroundimg);
        setX(StartX);
        setY(StartY);
    }

    public void coordinates() {

        if (y < -1000)
            y += 1;
    }
}

