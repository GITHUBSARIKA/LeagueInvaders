import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
int xspeed = -5;
	
	public Alien(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void update() {
	y+=5;
	
	if (y<=0) {
		isAlive=false;
	}
	
	x += xspeed;
	
	if(x < 0) {
		xspeed=5;
	}
	
	
}
void draw(Graphics g) {
	g.setColor(Color.YELLOW);
	g.drawRect(x, y, width, height);
}

}
