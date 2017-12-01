import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	final int width = 500;
	final int height = 800;

	LeagueInvaders() {
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setTitle("LeagueInvaders");
	}

	public static void main(String[] args) {
		LeagueInvaders leagueinvaders = new LeagueInvaders();
		leagueinvaders.setup();

	}

	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	}
}
