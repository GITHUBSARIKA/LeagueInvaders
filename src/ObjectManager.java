import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
 
public class ObjectManager {
	ArrayList<Projectiles> projectiles = new ArrayList<>(); 
	 ArrayList<Alien> aliens = new ArrayList<Alien>();
     
	RocketShip rocketship; 
ObjectManager(RocketShip r){
	rocketship=r;
}
void update() {
	rocketship.update();
	for(Projectiles j:projectiles) {
		j.update();
	}
}
void draw(Graphics g) {
	rocketship.draw(g);
	for(Projectiles j:projectiles) {
		j.draw(g);
	}
}
void addProjectile(Projectiles projectile) {
	projectiles.add(projectile);
}


public void manageEnemies(){
    int enemyTimer;
    int enemySpawnTime;
   
	if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
    }
}



}
