import java.awt.Color;
import java.awt.Graphics;


public class DisCircle extends Circle {
	
	private int x,y,diameter,alpha,red,green,blue;
	private Color color;
	
	public DisCircle(int x, int y, int diameter, Color color,int red,int green,int blue,int alpha) {
		super(x, y, diameter, color);
		this.alpha = alpha;
		this.red = red;
		this.green = green;
		this.blue = blue;
		
	}
	
	public void draw(Graphics page, Color color){
		alpha-=5;
		green+=5;
		page.setColor(new Color(255,green,0,alpha));
		page.fillOval(this.x, this.y, this.diameter, this.diameter);
	}

	public int getGreen() {
		return green;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void incAlpha(int alpha) {
		this.alpha -= alpha;
	}

	public int getAlpha() {
		return alpha;
	}

	public void incRed(int red) {
		this.red -= red;
	}

	public void incGreen(int green) {
		this.green -= green;
	}

	public void incBlue(int blue) {
		this.blue -= blue;
	}

}
