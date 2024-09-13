package fightsolo.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel {
	private static final long serialVersionUID = 1L;

	private Image background;
	
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon imageIcon = new ImageIcon("res\\Florest02.png");
		this.background = imageIcon.getImage();
	}
	
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		graphics2D.drawImage(background, 0, 0, null);
		
		graphics.dispose();
	}
}
