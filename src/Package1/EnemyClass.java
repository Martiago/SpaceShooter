package Package1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class EnemyClass extends Sprite {

    private BufferedImage enemyimg;
    private final int StartY = -100;
    private int dy = 5;
    private Random rand = new Random();
    
    public EnemyClass() {

        try {
            enemyimg = ImageIO.read(getClass().getResource("pic/enemyship.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setImage(enemyimg);
        setY(StartY);
    }

    public void coordinate() {
        y += dy;
        if (y >= 1100) {
            setX(rand.nextInt(1800));
            setY(StartY);
        }
        
        if (isDying()) {
            setX(rand.nextInt(1800));
            setY(StartY);
            setDying(false);
        }
    }
}


