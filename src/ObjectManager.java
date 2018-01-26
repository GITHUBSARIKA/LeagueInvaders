import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer;
	int enemySpawnTime;
	int score;
	ArrayList<Projectiles> projectiles = new ArrayList<>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	RocketShip rocketship;

	ObjectManager(RocketShip r) {
		rocketship = r;
		enemyTimer = 0;
		enemySpawnTime = 1000;
		score=0;
	}

	void update() {
		rocketship.update();
		for (Projectiles j : projectiles) {
			j.update();
		}
		for (Alien k : aliens) {
			k.update();
		}
	}

	void draw(Graphics g) {
		rocketship.draw(g);
		for (Projectiles j : projectiles) {
			j.draw(g);
			
		}
		for (Alien k : aliens) {
			k.draw(g);
		}
			
		
	}

	void addProjectile(Projectiles projectile) {
		projectiles.add(projectile);
	}

	void addAlien(Alien alien) {
		aliens.add(alien);

	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);
			if (alien.isAlive == false) {
				aliens.remove(alien);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectiles projectile = projectiles.get(i);
			if (projectile.isAlive == false) {
				projectiles.remove(projectile);
			}

		}
	}

	public void manageEnemies() {

		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {

			if (rocketship.collisionBox.intersects(a.collisionBox)) {

				rocketship.isAlive = false;

			}
			for (Projectiles p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {

					p.isAlive = false;
					a.isAlive = false;
					score++;

				}

			}
			
		}
	}
	int getScore() {
		return score;
		
	}

}
