import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class GameObject {
	 int x;
     int y;
     int width;
     int height;
     boolean isAlive;
     Rectangle collisionBox;
    

	GameObject(int x, int y, int width, int height){
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	collisionBox= new Rectangle();
	isAlive=true;
}
void update() {
	   
	collisionBox.setBounds(x, y, width, height);


}
void draw(Graphics g) {

}
}
