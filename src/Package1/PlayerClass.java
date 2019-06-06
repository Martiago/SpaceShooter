package Package1;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayerClass extends Sprite {

    private final int StartX = 960;
    private final int StartY = 540;
    private BufferedImage imagenormal, imageleft, imagetop, imageright, imageback;

    public PlayerClass() {

        try {
            imagenormal = ImageIO.read(getClass().getResource("pic/ship.png"));
            imageleft = ImageIO.read(getClass().getResource("pic/Shipleft.png"));
            imagetop = ImageIO.read(getClass().getResource("pic/Shiptop.png"));
            imageright = ImageIO.read(getClass().getResource("pic/Shipright.png"));
            imageback = ImageIO.read(getClass().getResource("pic/Shipback.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setImage(imagenormal);
        setX(StartX);
        setY(StartY);
    }

    public void coordinates() {

        x += dx;
        y += dy;

        if (x <= 1) {
            x = 1;
        }
        if (x >= 1800) {
            x = 1800;
        }
        if (y <= 1) {
            y = 1;
        }
        if (y >= 940) {
            y = 940;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -10;
            setImage(imageleft);
        }
        if (key == KeyEvent.VK_RIGHT) {

            dx = 10;
            setImage(imageright);
        }
        if (key == KeyEvent.VK_UP) {

            dy = -10;
            setImage(imagetop);
        }
        if (key == KeyEvent.VK_DOWN) {

            dy = 10;
            setImage(imageback);
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
            setImage(imagenormal);
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
            setImage(imagenormal);
        }
        if (key == KeyEvent.VK_UP) {

            dy = 0;
            setImage(imagenormal);
        }
        if (key == KeyEvent.VK_DOWN) {

            dy = 0;
            setImage(imagenormal);
        }
    }
}