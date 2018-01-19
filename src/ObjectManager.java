import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer;
	int enemySpawnTime;
	ArrayList<Projectiles> projectiles = new ArrayList<>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	RocketShip rocketship;

	ObjectManager(RocketShip r) {
		rocketship = r;
		enemyTimer = 0;
		enemySpawnTime = 1000;
	}

	void update() {
		rocketship.update();
		for (Projectiles j : projectiles) {
			j.update();
		}
		for(Alien k: aliens) {
			k.update();
		}
	}

	void draw(Graphics g) {
		rocketship.draw(g);
		for (Projectiles j : projectiles) {
			j.draw(g);
		for(Alien k:aliens) {
			k.draw(g);
		}
		}
	}

	void addProjectile(Projectiles projectile) {
		projectiles.add(projectile);
	}

	void addAlien(Alien alien) {
		aliens.add(alien);

	}
void purgeObjects() {
	for(int i = 0; i < aliens.size(); i++){
		Alien alien = aliens.get(i);
		
	}	
}
	public void manageEnemies() {

		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

}
