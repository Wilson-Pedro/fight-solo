package fightsolo.model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player01 implements ActionListener {

	private Image image;
	private int height, width;
	private int x, y;
	private int dx;
	private Timer timer;
	private boolean isAttack;
	
	public Player01() {
		this.x = 100;
		this.y = 305;
		
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image;
	}

	public boolean isAttack() {
		return isAttack;
	}
}
