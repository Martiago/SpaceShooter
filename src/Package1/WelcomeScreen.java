package Package1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WelcomeScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private FancyButton playButton;
	private FancyButton settingsButton;
	private FancyButton exitButton;
	private JLabel backgroundLabel;
	private JLabel titleLabel;
	private BufferedImage backgroundImg;
	private Background backgroundComponent;

	public WelcomeScreen() throws HeadlessException {

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		try {
			backgroundImg = ImageIO.read(getClass().getResource("pic/MenuBackground.jpg"));
		} catch (IOException e) {

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

		playButton = new FancyButton("  Play  ");
		a.gridx = 0;
		a.gridy = 2;
		a.insets = new Insets(0, 0, 20, 0);
		backgroundLabel.add(playButton, a);

		settingsButton = new FancyButton("  Settings  ");
		a.gridx = 0;
		a.gridy = 3;
		backgroundLabel.add(settingsButton, a);

		exitButton = new FancyButton("  Exit  ");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		a.gridx = 0;
		a.gridy = 4;
		backgroundLabel.add(exitButton, a);

	}

	public FancyButton getSettingsButton(){
		return settingsButton;
	}

	public FancyButton getPlayButton(){
		return playButton;
	}
}

