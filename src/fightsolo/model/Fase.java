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
	private Timer timer;
	
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon imageIcon = new ImageIcon("res\\Florest02.png");
		this.background = imageIcon.getImage();
		
		this.player = new Player();
		player.load();
		
		addKeyListener(new TecladoAdapter());
		
		this.timer = new Timer(5, this);
		this.timer.start();
	}
	
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		graphics2D.drawImage(background, 0, 0, null);
		
		graphics2D.drawImage(player.getImage(), player.getX(), player.getY(), this);
		
		graphics.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		repaint();
	}
	
	private class TecladoAdapter extends KeyAdapter {
		            
		public void keyPressed(KeyEvent key) {
			player.KeyPressed(key);
		}
		
		public void keyReleased(KeyEvent key) {
			player.KeyRelease(key);
		}
	}
}
