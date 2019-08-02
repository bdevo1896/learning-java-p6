import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.Timer;


public class MovableObject{

	private int x,y;
	private Image img;
	private boolean isMoving;

	public MovableObject(int x, int y, Image img,boolean isMoving){
		this.x = x;
		this.y = y;
		this.img = img;
		this.isMoving = isMoving;
	}

	public void draw(Graphics page){
		page.drawImage(img, x, y,null);
	}


	public void moveBy(int deltaX,int deltaY){
		x+=deltaX;
		y+=deltaY;
	}

	public void move(Square s){
		if(x!=s.getX() || y!=s.getY()){
			if(x<s.getX()){
				moveBy(1, 0);
			}else if(x>s.getX()){
				moveBy(-1, 0);
			}

			if(y<s.getY()){
				moveBy(0, 1);
			}else if(y>s.getY()){
				moveBy(0, -1);
			}

		}else{
			setMoving(false);
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage(){
		return img;
	}

	public boolean isMoving() {
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
}