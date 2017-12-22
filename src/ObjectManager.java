import java.awt.Graphics;

public class ObjectManager {
	RocketShip rocketship; 
ObjectManager(RocketShip r){
	rocketship=r;
}
void update() {
	rocketship.update();
}
void draw(Graphics g) {
	rocketship.draw(g);
}
}
