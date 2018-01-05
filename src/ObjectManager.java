import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<Projectiles> projectiles = new ArrayList<>(); 
	
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
}
