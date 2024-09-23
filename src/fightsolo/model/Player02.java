package fightsolo.model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player02 implements ActionListener {

	private Image image;
	private int height, width;
	private int x, y;
	private int dx;
	private Timer timer;
	private boolean isAttack;
	
	public Player02() {
		this.x = 1000;
		this.y = 280;
		
		this.timer = new Timer(700, this);
		this.timer.start();
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
	
	public void attack() {
		this.isAttack = true;
		ImageIcon imageAttack = new ImageIcon("res\\Enemy-Attack.png");
		this.image = imageAttack.getImage();
	}
	
	public void KeyPressed(KeyEvent key) {
		int code = key.getKeyCode();
		
		if(code == KeyEvent.VK_ENTER) {
			attack();
		}
		
		if(code == KeyEvent.VK_LEFT) {
			dx = -3;
		}
		
		if(code == KeyEvent.VK_RIGHT) {
			dx = 3;
		}
	}
	
	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		
		if(codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
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
}
