package fightsolo.model.player;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import fightsolo.model.soundEffects.SoundEffect;

public class Player01 implements ActionListener {

	private Image image;
	private int height, width;
	private int x, y;
	private int dx;
	private Timer timer;
	private boolean isAttack;
	private boolean isVisible;
	private int life;
	private SoundEffect soundEffect;
	
	public Player01() {
		this.x = 100;
		this.y = 305;
		
		soundEffect = new SoundEffect();
		
		this.isVisible = true;
		this.life = 1000;
		
		this.timer = new Timer(700, this);
		this.timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isAttack == true) {
			attack();
			isAttack = false;
		}
		
		if(!isAttack) {
			load();
		}
	}

	public void load() {
		ImageIcon imageIcon = new ImageIcon("res\\Player01.png");
		this.image = imageIcon.getImage();
		
		this.height = image.getHeight(null);
		this.width = image.getWidth(null);
	}
	
	public void update() {
		if((x + dx) > 0 && (x + dx) <= 1120) {
			this.x += dx;
		}
	}
	
	public void attack() {
		this.isAttack = true;
		ImageIcon imageAttack = new ImageIcon("res\\Player01-Attack.png");
		this.image = imageAttack.getImage();
		soundEffect.playAttackSound();
	}
	
	public Rectangle getPlayerForm() {
		return new Rectangle(x, y, width, height);
	}
	
	public Rectangle getPlayerAttackForm() {
		return new Rectangle(x, y, 432, 431);
	}
	
	public void KeyPressed(KeyEvent key) {
		int code = key.getKeyCode();
		
		if(code == KeyEvent.VK_SPACE) {
			attack();
		}
		
		if(code == KeyEvent.VK_D) {
			dx = 3;
		}
		
		if(code == KeyEvent.VK_A) {
			dx = -3;
		}
	}
	
	public void KeyRelease(KeyEvent key) {
		int code = key.getKeyCode();
		
		if(code == KeyEvent.VK_D) {
			dx = 0;
		}
		
		if(code == KeyEvent.VK_A) {
			dx = 0;
		}
	}
	
	public void decrementLife() {
		this.life -= 10;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Image getImage() {
		return image;
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
}
