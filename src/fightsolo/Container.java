package fightsolo;

import javax.swing.JFrame;

import fightsolo.model.Fase;

public class Container extends JFrame {
	private static final long serialVersionUID = 1L;

	public Container() {
		add(new Fase());
		setTitle("Fight Solo");
		setSize(1366, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Container();
	}
}
