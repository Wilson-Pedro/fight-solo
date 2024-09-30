package fightsolo.model.phase;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import fightsolo.model.player.Player01;
import fightsolo.model.player.Player02;
import fightsolo.model.soundEffects.SoundEffect;

public class Fase extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Image background;
	private Player01 player01;
	private Player02 player02;
	private Timer timer;
	private boolean player01InGame;
	private boolean player02InGame;
	
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
		
		player01InGame = true;
		player02InGame = true;
	}
	
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		graphics2D.drawImage(background, 0, 0, null);
		
		if(player01InGame) {
			graphics2D.drawImage(player01.getImage(), player01.getX(), player01.getY(), this);
		}
		
		if(player02InGame) {
			graphics2D.drawImage(player02.getImage(), player02.getX(), player02.getY(), this);
		}
		
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
		checkCollisionsAttacks();
		repaint();
	}

	public void checkCollisionsAttacks() {		
		Rectangle formPlayer01 = player01.getPlayerForm();
		Rectangle formPlayer02 = player02.getPlayerForm();
		Rectangle formAttack01 = player01.getPlayerAttackForm();
		Rectangle formAttack02 = player02.getPlayerAttackForm();
		
		if(formAttack01.intersects(formPlayer02) && player01.isAttack()) {
			player02.decrementLife();
			if(player02.getLife() <= 0) {
				player02.setVisible(false);
				player02InGame = false;
			}

		}
		
		if(formAttack02.intersects(formPlayer01) && player02.isAttack()) {
			player01.decrementLife();
			if(player01.getLife() <= 0) {
				player01.setVisible(false);
				player01InGame = false;
			}
		}
		
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
