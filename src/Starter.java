import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Starter {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bounce Time");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(800,600));
		//This creates the bouncing window
//		BouncePanel bpPanel = new BouncePanel();
//		mainPanel.add(bpPanel);
		//This creates the checkerboard that changes color
//		ColorChangeBoard colorChanger = new ColorChangeBoard();
//		mainPanel.add(colorChanger);
		//This creates the checkerboard with moving pieces
		CheckerBoard checker = new CheckerBoard();
		mainPanel.add(checker);
		frame.getContentPane().add(mainPanel);
		frame.pack();

		frame.setVisible(true);
		
		/*
		 * Note: Must uncomment the lines for the color changing board.
		 */
//		Timer timerBounce = new Timer(20,bpPanel);
//		timerBounce.start();
//		Timer timerColor = new Timer(20,colorChanger);
//		timerColor.start();
//		Timer timer = new Timer(20,checker);
//		timer.start();
	}

}
