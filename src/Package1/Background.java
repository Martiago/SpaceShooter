package Package1;

import javax.swing.*;
import java.awt.*;

public class Background extends JComponent {

	private static final long serialVersionUID = 1L;
	private Image image;

    public Background(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}