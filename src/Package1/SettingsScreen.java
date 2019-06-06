package Package1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SettingsScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private FancyButton returnButton;
    private FancyButton controlsButton;
    private FancyButton musicButton;
    private JLabel backgroundLabel;
    private JLabel titleLabel;
    private BufferedImage backgroundImg;
    private Background backgroundComponent;

    public SettingsScreen() throws HeadlessException {

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {
            backgroundImg = ImageIO.read(getClass().getResource("pic/MenuBackground.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        backgroundComponent = new Background(backgroundImg);
        this.setContentPane(backgroundComponent);

        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 1920, 1080);
        GridBagLayout layout = new GridBagLayout();
        backgroundLabel.setLayout(layout);
        this.add(backgroundLabel);

        GridBagConstraints a = new GridBagConstraints();
        a.insets = new Insets(0, 0, 208, 0);
        a.anchor = GridBagConstraints.LINE_START;
        a.weightx = 1;
        a.weighty = 0;

        titleLabel = new JLabel("SPACE SHOOTER");
        titleLabel.setFont(new Font("Monospaced", Font.ITALIC, 150));
        titleLabel.setForeground(Color.WHITE);
        a.gridx = 0;
        a.gridy = 0;
        backgroundLabel.add(titleLabel, a);

        controlsButton = new FancyButton("  Controls  ");
        a.gridx = 0;
        a.gridy = 2;
        a.insets = new Insets(0, 0, 20, 0);
        backgroundLabel.add(controlsButton, a);

        musicButton = new FancyButton("  Music  ");
        a.gridx = 0;
        a.gridy = 3;
        backgroundLabel.add(musicButton, a);

        returnButton = new FancyButton("  Return  ");
        a.gridx = 0;
        a.gridy = 4;
        backgroundLabel.add(returnButton, a);
    }

    public FancyButton getsetMusicButton(){return musicButton;}
    public FancyButton getsetControlButton(){return controlsButton;}
    public FancyButton getReturnButton(){return returnButton;}
}