import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class MyPanel extends JPanel {
	
	public MyPanel(){
		super();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(800,600));
	}
	
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		page.setColor(Color.red);
		page.fillOval(100, 200, 300, 300);
		//Values go from 0 to 255, RGB
		Color c = new Color(128,128,128);
		page.setColor(c);
		page.fillOval(5, 15, 25, 25);
		//Values go from 0 to 255, even last value which is transparency
		//0 is completely transparent, 255 is completely opaque. 
		Color transparent = new Color(30,255,30,128);
		page.setColor(transparent);
		page.fillOval(50, 150, 100, 100);
	}

}
