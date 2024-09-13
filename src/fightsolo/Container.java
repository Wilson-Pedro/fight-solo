package fightsolo;

import javax.swing.JFrame;

public class Container extends JFrame {
	private static final long serialVersionUID = 1L;

	public Container() {
		setTitle("Fight Solo");
		setSize(1024, 728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Container();
	}
}
