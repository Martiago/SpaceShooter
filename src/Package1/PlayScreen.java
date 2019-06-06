package Package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class PlayScreen extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	int updates = 0;
    int frames = 0;
    long timer = System.currentTimeMillis();

    private PlayerClass playerClass;
    private BulletClass bulletClass;
    private BackgroundClass backgroundClass;
    private ArrayList<EnemyClass> enemyClasses;
    private boolean running = true;
    private Thread thread;
    private JFrame frame;
    private int bulletX;
    private int bulletY;
    private int enemyX;
    private int enemyY;
    private String points;
    private int pnumber = 0;
    
    public PlayScreen() {
        super();
        addKeyListener(this);
        setFocusable(true);
        setDoubleBuffered(true);

        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.add(this);
        points = new String("POINTS:");
        playerClass = new PlayerClass();
        bulletClass = new BulletClass();
        backgroundClass = new BackgroundClass();

        enemyClasses = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            EnemyClass enemy = new EnemyClass();
            enemy.setX(100 + i*270);
            enemyClasses.add(enemy);
        }

        if (thread == null || !running) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void draw(Graphics g) {
    	
    	if (backgroundClass.Visible()) {

    		g.drawImage(backgroundClass.getImage(), backgroundClass.getX(), backgroundClass.getY(), this);
    		
        }
        if (playerClass.Visible()) {

        	g.drawImage(playerClass.getImage(), playerClass.getX(), playerClass.getY(), this);
        }
       if (bulletClass.Visible()) {

    	   	g.drawImage(bulletClass.getImage(), bulletClass.getX(), bulletClass.getY(), this);
        }	
      
        for (EnemyClass enemy: enemyClasses) {

            if (enemy.Visible()) {
                g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
        		g.drawString(points, 10, 30); //draw String ma miec argumenty: (String str, int x, int y)
        		g.drawString("Arrow keys - movement", 1600, 950);
        		g.drawString("Space - shooting", 1600, 1000);
        		g.drawString("ESC - exit", 1600, 1050);
            }
        }
      
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.setColor(Color.WHITE);
		
        if (running) {
            draw(g);
        }
       g.dispose();
    }

    public void coordinates() {

        for (EnemyClass enemy: enemyClasses){
             enemy.coordinate();
             
             enemyX = enemy.getX();
             enemyY = enemy.getY();
             
             if (enemy.Visible()) {
                 if (playerClass.getX() >= (enemyX - 95)
                         && playerClass.getX() <= (enemyX + 95)
                         && playerClass.getY() >= (enemyY - 90)
                         && playerClass.getY() <= (enemyY + 120)) {
                	 try {
						Thread.sleep(10000000); // Usypia gre po przegranej
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                 }
             }
        }
        
        playerClass.coordinates();
        bulletClass.coordinates();
        backgroundClass.coordinates();

        if (bulletClass.Visible()) {

            bulletX = bulletClass.getX();
            bulletY = bulletClass.getY();

            for (EnemyClass enemy: enemyClasses) {

            enemyX = enemy.getX();
            enemyY = enemy.getY();
            
                if (enemy.Visible()) {
                    if (bulletX >= (enemyX - 20)
                            && bulletX <= (enemyX + 100)
                            && bulletY >= (enemyY - 50)
                            && bulletY <= (enemyY + 50)) {
                        enemy.setDying(true); //powoduje reset pozycji wroga
                        bulletClass.die();
                        pnumber ++;
                        points = "POINTS: " + pnumber;
                    }
                }
            }
        }
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        final double amofTicks = 60.0;
        double ns = 1000000000 / amofTicks;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                repaint();
                coordinates();
                updates++;
                delta--;
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                updates = 0;
                frames = 0;
            }

        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

        playerClass.keyReleased(e);
    }


    @Override
    public void keyPressed(KeyEvent e) {

        playerClass.keyPressed(e);

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            if (running) {
                if (!bulletClass.Visible()) {
                    bulletClass = new BulletClass(playerClass.getX(), playerClass.getY());
                }
            }
        }
        
        if (key == KeyEvent.VK_ESCAPE) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}