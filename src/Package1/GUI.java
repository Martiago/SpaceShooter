package Package1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel {

	private static final long serialVersionUID = 1L;

	public GUI() {

		WelcomeScreen welcS = new WelcomeScreen();
		welcS.setVisible(true);
		SettingsScreen settS = new SettingsScreen();
		settS.setVisible(false);
		MusicSettings musicS = new MusicSettings();
		musicS.setVisible(false);
		ControlsSettings setControls = new ControlsSettings();
		setControls.setVisible(false);

		Music music = new Music();

		welcS.getSettingsButton().setAllVisible(settS);
		settS.getReturnButton().setAllVisible(welcS);
		settS.getReturnButton().Hide(settS);

		settS.getsetMusicButton().setAllVisible(musicS);
		musicS.getReturnButton().setAllVisible(settS);
		musicS.getReturnButton().Hide(musicS);

		settS.getsetControlButton().setAllVisible(setControls);
		setControls.getReturnButton().setAllVisible(settS);
		setControls.getReturnButton().Hide(setControls);
		
		welcS.getPlayButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PlayScreen playS = new PlayScreen();
				playS.setVisible(true);
			}
		});

		musicS.getmusicON().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				music.getClip().start();
			}
		});

		musicS.getmusicOFF().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				music.getClip().stop();
			}
		});


	}

}
