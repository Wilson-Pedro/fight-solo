package fightsolo.model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Enemy implements ActionListener {

	private Image image;
	private int width, height;
	private int x, y;
	private int dx;
	private Timer timer;
	
	public Enemy() {
		this.x = 1000;
		this.y = 265;
		
		this.timer = new Timer(5000, this);
		this.timer.start();
	}
	
	public void load() {
		ImageIcon imageIcon = new ImageIcon("res\\Enemy.png");
		this.image = imageIcon.getImage();
		
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
	}
	
	public void update() {
		this.x += dx;
	}
	
	public void KeyPressed(KeyEvent key) {
		int code = key.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT) {
			dx = -3;
		}
		
//		if(code == KeyEvent.VK_LEFT) {
//			dx = -3;
//		}
	}
	
	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		
//		if(codigo == KeyEvent.VK_RIGHT) {
//			dx = 0;
//		}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
