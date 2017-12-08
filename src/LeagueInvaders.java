import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	final int width = 500;
	final int height = 800;
	GamePanel gamepanel=new GamePanel();

	LeagueInvaders() {
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setTitle("LeagueInvaders");frame.addKeyListener(gamepanel);
	}

	public static void main(String[] args) {
		LeagueInvaders leagueinvaders = new LeagueInvaders();
		leagueinvaders.setup();

	}

	void setup() {
		frame.add(gamepanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		gamepanel.startGame();

	}
}
