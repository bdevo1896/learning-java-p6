import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BuildingBlocksTimerPanel extends JPanel implements ActionListener{

	private Square mySquare;
	
	public BuildingBlocksTimerPanel(){
		super();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(800,600));
		//We choose the values 375 and 275 because the square is 50x50 and the screen is 800x200 
		//Since the X,y coordinates are the upper left corner of the square. If we want to center the square
		//The we need to choose the values 800/2 - 50/2, 600/2 - 25/2 = 375, 275
		mySquare = new Square(375,275,50, Color.red);
	}


	public void paintComponent(Graphics page){
		super.paintComponent(page);
		//mySquare has a method to draw itself
		mySquare.draw(page);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//Because we use 1,2 moves at a non-45 degree angle each tick
		mySquare.moveBy(1, 2);
		
		//Gotta repaint or nothing happens
		this.repaint();
		
	}
}

