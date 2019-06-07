package Package1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BulletClass extends Sprite {

    private final int HorizontalFromShip = 45;
    private final int VerticalFromShip = 15;
    private BufferedImage bulletImg;
//checking working git
    public BulletClass() {
        //Metoda jest pusta i nie zawiera zmiennych, zaczytujemy ja w PlayScreen, metoda ponizej ustawia pocisk na graczu.
    }

    public void coordinates(){
        if (Visible()) {
            int bulletspeedY = getY();
            bulletspeedY -= 30;
            if (bulletspeedY < 0){
                die(); // visible false
            } else {
                setY(bulletspeedY);
            }
        }
    }

    public BulletClass(int bulletpositionX, int bulletpositionY) {

        try {
            bulletImg = ImageIO.read(getClass().getResource("pic/bullet.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setImage(bulletImg);
        setX(bulletpositionX + HorizontalFromShip);
        setY(bulletpositionY - VerticalFromShip);
    }

}