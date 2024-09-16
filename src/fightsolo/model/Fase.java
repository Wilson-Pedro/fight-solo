package fightsolo.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Image background;
	private Player player;
	private Enemy enemy;
	private Timer timer;
	
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon imageIcon = new ImageIcon("res\\Florest02.png");
		this.background = imageIcon.getImage();
		
		this.player = new Player();
		this.player.load();
		
		this.enemy = new Enemy();
		this.enemy.load();
		
		addKeyListener(new TecladoPlayerAdapter());
		addKeyListener(new TecladoEnemyAdapter());
		
		this.timer = new Timer(5, this);
		this.timer.start();
		
	}
	
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		graphics2D.drawImage(background, 0, 0, null);
		
		graphics2D.drawImage(player.getImage(), player.getX(), player.getY(), this);
		
		graphics2D.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
		
		graphics.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		enemy.update();
		repaint();
	}
	
	private class TecladoPlayerAdapter extends KeyAdapter {
		            
		public void keyPressed(KeyEvent key) {
			player.KeyPressed(key);
		}
		
		public void keyReleased(KeyEvent key) {
			player.KeyRelease(key);
		}
	}
	
	private class TecladoEnemyAdapter extends KeyAdapter {
		
		public void keyPressed(KeyEvent key) {
			enemy.KeyPressed(key);
		}
		
		public void keyReleased(KeyEvent key) {
			enemy.KeyPressed(key);
		}
	}
}
