import java.awt.Color;
import java.awt.Graphics;


public class Square {
	private int x;
	private int y;
	private int side;
	private Color color;
	private final Color ORG_COLOR;
	private boolean isColorChanged;
	
	public Square(int x, int y, int side, Color c){
		this.x = x;
		this.y = y;
		this.color = c;
		ORG_COLOR = c;
		this.side = side;
		isColorChanged = false;
	}
	
	//Draws the square for you
	public void draw(Graphics page){
		page.setColor(this.color);
		page.fillRect(this.x, this.y, this.side, this.side);
	}
	
	
	//Allwos us to move the square
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

	public int getSide() {
		return side;
	}

	public Color getColor() {
		return color;
	}
	
	public void changeColor(Color color){
		if(this.color != ORG_COLOR){
			this.color = ORG_COLOR;
		}else{
			this.color = color;
		}
	}
}
