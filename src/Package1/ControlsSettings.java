package Package1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ControlsSettings extends JFrame {

	private static final long serialVersionUID = 1L;
	private FancyButton returnButton;
    private FancyButton shooting;
    private FancyButton controlOff;
    private JLabel backgroundL;
    private JLabel titleL;
    private BufferedImage backgroundImg;
    private Background backgroundComp;


    public ControlsSettings() {

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {
            backgroundImg = ImageIO.read(getClass().getResource("pic/MenuBackground.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        backgroundComp = new Background(backgroundImg);
        this.setContentPane(backgroundComp);

        backgroundL = new JLabel();
        backgroundL.setBounds(0, 0, 1920, 1080);
        GridBagLayout layout = new GridBagLayout();
        backgroundL.setLayout(layout);
        this.add(backgroundL);

        GridBagConstraints a = new GridBagConstraints();
        a.insets = new Insets(0, 0, 208, 0);
        a.anchor = GridBagConstraints.LINE_START;
        a.weightx = 1;
        a.weighty = 0;

        titleL = new JLabel("SPACE SHOOTER");
        titleL.setFont(new Font("Monospaced", Font.ITALIC, 150));
        titleL.setForeground(Color.WHITE);
        a.gridx = 0;
        a.gridy = 0;
        backgroundL.add(titleL, a);

        shooting = new FancyButton("  Shooting ");
        a.gridx = 0;
        a.gridy = 2;
        a.insets = new Insets(0, 0, 20, 0);
        backgroundL.add(shooting, a);

        controlOff = new FancyButton("  Ship Control  ");
        a.gridx = 0;
        a.gridy = 3;
        a.insets = new Insets(0, 0, 20, 0);
        backgroundL.add(controlOff, a);

        returnButton = new FancyButton("  Return  ");
        a.gridx = 0;
        a.gridy = 4;
        a.insets = new Insets(0, 0, 20, 0);
        backgroundL.add(returnButton, a);
    }

    public FancyButton getReturnButton() {
        return returnButton;
    }

}