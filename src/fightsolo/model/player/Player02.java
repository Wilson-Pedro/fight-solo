package fightsolo.model.player;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import fightsolo.model.soundEffects.SoundEffect;

public class Player02 implements ActionListener {

	private Image image;
	private int height, width;
	private int x, y;
	private int dx;
	private Timer timer;
	private boolean isAttack;
	private boolean isVisible;
	private boolean inGame;
	private int life;
	private SoundEffect soundEffect;
	
	public Player02() {
		this.x = 1000;
		this.y = 280;
		
		soundEffect = new SoundEffect();
		
		this.isVisible = true;
		this.life = 1000;
		
		this.timer = new Timer(700, this);
		this.timer.start();
		
		inGame = true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isAttack) {
			attack();
			isAttack = false;
		}
		
		if(!isAttack) {
			load();
		}
	}
	
	public void load() {
		ImageIcon imageIcon = new ImageIcon("res\\Enemy.png");
		this.image = imageIcon.getImage();
		
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
	}
	
	public void update() {
		if((x + dx) > 0 && (x + dx) <= 1120) {
			this.x += dx;
		}
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void attack() {
		this.isAttack = true;
		ImageIcon imageAttack = new ImageIcon("res\\Enemy-Attack.png");
		this.image = imageAttack.getImage();
		soundEffect.playAttackSound();
	}
	
	public Rectangle getPlayerAttackForm() {
		return new Rectangle(x, y, 396, 467);
	}
	
	public Rectangle getPlayerForm() {
		return new Rectangle(x, y, width, height);
	}
	
	public void KeyPressed(KeyEvent key) {
		int code = key.getKeyCode();
		
		if(inGame == true && code == KeyEvent.VK_ENTER) {
			attack();
		}
		
		if(inGame == true && code == KeyEvent.VK_LEFT) {
			dx = -3;
		}
		
		if(inGame == true && code == KeyEvent.VK_RIGHT) {
			dx = 3;
		}
	}
	
	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if(inGame == true && codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		
		if(inGame == true && codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
	
	public void decrementLife() {
		this.life -= 10;
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isAttack() {
		return isAttack;
	}
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public int getLife() {
		return life;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
}
