import java.awt.Color;
import java.awt.Graphics;



public class Circle {

	private int x;
	private int y;
	private int diameter;
	private Color color;

	public Circle(int x, int y, int diameter, Color color) {
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.color = color;
	}
	
	//Draws the circle for you
		public void draw(Graphics page){
			page.setColor(this.color);
			page.fillOval(this.x, this.y, this.diameter, this.diameter);
		}
		
		
		//Allwos us to move the circle
		public void moveBy(int deltaX,int deltaY){
			x+=deltaX;
			y+=deltaY;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getDiameter() {
			return diameter;
		}

		public Color getColor() {
			return color;
		}
}
