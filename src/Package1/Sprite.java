package Package1;

import java.awt.*;

public class Sprite {

    private boolean visible;
    private Image image;
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected boolean dying;

    public Sprite() {

        visible = true;
    }

    public void die() {

        visible = false;
    }

    public boolean Visible() {

        return visible;
    }

    public void setImage(Image image) {

        this.image = image;
    }

    public Image getImage() {

        return image;
    }

    public void setDying(boolean dying) {

        this.dying = dying;
    }

    public boolean isDying() {

        return this.dying;
    }
    
    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int getY() {

        return y;
    }

    public int getX() {

        return x;
    }
}
