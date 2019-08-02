import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BouncePanel extends JPanel implements ActionListener{

	private Circle myCircle;
	private int x,y;
	private ArrayList<DisCircle> fade;

	public BouncePanel(){
		super();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(800,600));
		Random rand = new Random();
		fade = new ArrayList<DisCircle>();
		Color col = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		myCircle = new Circle(400,300,50,col);
		x = -3;
		y = -3;
	}


	public void paintComponent(Graphics page){
		super.paintComponent(page);
		if(fade.size()>0){
			for(int i = 0; i < fade.size(); i++){
				fade.get(i).draw(page);
			}
		}
		myCircle.draw(page);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(myCircle.getX()+myCircle.getDiameter() >= 800 || myCircle.getX() <= 0){
			x *= -1;
		}

		if(myCircle.getY()+myCircle.getDiameter() >= 600 || myCircle.getY() <= 0){
			y *= -1;
		}
		myCircle.moveBy(x,y);

		DisCircle disC = new DisCircle(myCircle.getX(),myCircle.getY(),50,new Color(255,0,0,255),255,0,0,255);

		fade.add(disC);

		for(int i = 0; i < fade.size(); i++){
			DisCircle c = fade.get(i);
			if(c.getAlpha()<=0){
				fade.remove(c);
			}
		}


		this.repaint();

	}
}