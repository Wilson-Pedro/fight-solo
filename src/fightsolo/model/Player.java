package fightsolo.model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player implements ActionListener {

	private Image image;
	private int height, width;
	private int x, y;
	private int dx;
	private Timer timer;
	
	public Player() {
		this.x = 100;
		this.y = 305;
		
		this.timer = new Timer(5000, this);
		this.timer.start();
	}

	public void load() {
		ImageIcon imageIcon = new ImageIcon("res\\Player01.png");
		this.image = imageIcon.getImage();
		
		this.height = image.getHeight(null);
		this.width = image.getWidth(null);
	}
	
	public void update() {
		this.x += dx;
	}
	
	public void KeyPressed(KeyEvent key) {
		int code = key.getKeyCode();
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
