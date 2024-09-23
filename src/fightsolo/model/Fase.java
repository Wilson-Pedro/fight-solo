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
	private Player01 player01;
	private Player02 player02;
	private Timer timer;
	
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon imageIcon = new ImageIcon("res\\Florest02.png");
		this.background = imageIcon.getImage();
		
		this.player01 = new Player01();
		this.player01.load();
		
		this.player02 = new Player02();
		this.player02.load();
		
		addKeyListener(new TecladoPlayerAdapter());
		addKeyListener(new TecladoEnemyAdapter());
		
		this.timer = new Timer(0, this);
		this.timer.start();
		
	}
	
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		graphics2D.drawImage(background, 0, 0, null);
		
		graphics2D.drawImage(player01.getImage(), player01.getX(), player01.getY(), this);
		
		graphics2D.drawImage(player02.getImage(), player02.getX(), player02.getY(), this);
		
		graphics.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		player01.update();
		player02.update();
		if(player01.isAttack()) {
			timer.setDelay(1);
		}
		
		if(!player01.isAttack()) {
			timer.setDelay(5);
		}
		
		if(player02.isAttack()) {
			timer.setDelay(1);
		}
		
		if(!player02.isAttack()) {
			timer.setDelay(5);
		}
		repaint();
	}
	
	private class TecladoPlayerAdapter extends KeyAdapter {
		            
		public void keyPressed(KeyEvent key) {
			player01.KeyPressed(key);
		}
		
		public void keyReleased(KeyEvent key) {
			player01.KeyRelease(key);
		}
	}
	
	private class TecladoEnemyAdapter extends KeyAdapter {
		
		public void keyPressed(KeyEvent key) {
			player02.KeyPressed(key);
		}
		
		public void keyReleased(KeyEvent key) {
			player02.keyRelease(key);
		}
	}
}
