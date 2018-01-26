import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	Font titleFont;
	Font subtitleFont;
	int currentState = MENU_STATE;
	RocketShip rocketship = new RocketShip(250, 700, 50, 50);
	ObjectManager objectmanager = new ObjectManager(rocketship);

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subtitleFont = new Font("Arial", Font.PLAIN, 24);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	void startGame() {

		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocketship.up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketship.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.left = true;
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			objectmanager.addProjectile(new Projectiles(rocketship.x+(rocketship.width /2), rocketship.y, 10,10));


		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocketship.up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketship.down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.left = false;
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectmanager.update();
		objectmanager.manageEnemies();
		objectmanager.checkCollision();
		objectmanager.purgeObjects();
		if (rocketship.isAlive==false) {
			currentState=END_STATE;
			objectmanager.reset();
			rocketship=new RocketShip(250, 700, 50, 50);
			
	
			
			
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.PINK);
		g.drawString("League Invaders", 50, 50);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 50, 200);
		g.drawString("Press SPACE for instructions", 50, 350);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		objectmanager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.PINK);
		g.drawString("Game Over", 50, 50);
		g.setFont(subtitleFont);
		g.drawString("You killed " +objectmanager.getScore()+ " enemies", 50, 200);
		g.drawString("Press ENTER to restart", 50, 350);
		g.setColor(Color.PINK);
	}

}
