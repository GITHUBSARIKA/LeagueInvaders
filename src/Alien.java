import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
public Alien(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void update() {
	y++;
	if (y<=0) {
		isAlive=false;
	}	
	
}
void draw(Graphics g) {
	g.setColor(Color.YELLOW);
	g.drawRect(x, y, width, height);
}
void addAlien() {
	
	Alien alien=new Alien(x,y,width,height);
}
}
