import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class BuildingBlocks {

	public static void main(String[] args) {
		
		// Question 1. 
		/* Using the code below as a guide make an ArrayList of four Double values and 
		 * then create print out the values using a for loop. 
		 */
		
		ArrayList<Integer> myArray = new ArrayList<Integer>();
		myArray.add(5);
		myArray.add(3);
		myArray.add(-10);
		
		for(int i =0;i<myArray.size();i++){
			System.out.println("The value at index "+i+" is "+myArray.get(i));
		}
		
		ArrayList<Double> myArrayD = new ArrayList<Double>();
		myArrayD.add(1.3);
		myArrayD.add(5.8);
		myArrayD.add(7.0);
		myArrayD.add(2.5);
		
		for(int i =0;i<myArray.size();i++){
			System.out.println("The value at index "+i+" is "+myArrayD.get(i));
		}
		
		//Question 2
		/* Using the code below as a guide make a 2D ArrayList of 4 x 5 Doubles
		 */
		
		ArrayList<ArrayList<Integer>> my2DArray = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> rowOne = new ArrayList<Integer>();
		rowOne.add(5);
		rowOne.add(7);
		rowOne.add(-10);
		
		ArrayList<Integer> rowTwo = new ArrayList<Integer>();
		rowTwo.add(-15);
		rowTwo.add(22);
		rowTwo.add(33);
		
		my2DArray.add(rowOne);
		my2DArray.add(rowTwo);
		
		for(int row = 0; row < my2DArray.size(); row++){
			ArrayList<Integer> aRow = my2DArray.get(row);
			for(int col = 0; col < aRow.size();col++){
				Integer anElement = aRow.get(col);
				System.out.println("The element at "+row+", "+col+" is "+anElement);
			}
		}
		
		
ArrayList<ArrayList<Double>> my2DArrayD = new ArrayList<ArrayList<Double>>();
		
		ArrayList<Double> rowOneD = new ArrayList<Double>();
		rowOneD.add(5.0);
		rowOneD.add(4.2);
		rowOneD.add(-9.5);
		
		ArrayList<Double> rowTwoD = new ArrayList<Double>();
		rowTwoD.add(12.3);
		rowTwoD.add(7.3);
		rowTwoD.add(11.8);
		
		ArrayList<Double> rowThreeD = new ArrayList<Double>();
		rowThreeD.add(5.0);
		rowThreeD.add(4.2);
		rowThreeD.add(-9.5);
		
		ArrayList<Double> rowFourD = new ArrayList<Double>();
		rowFourD.add(12.3);
		rowFourD.add(7.3);
		rowFourD.add(11.8);
		
		my2DArrayD.add(rowOneD);
		my2DArrayD.add(rowTwoD);
		my2DArrayD.add(rowThreeD);
		my2DArrayD.add(rowFourD);
		
		for(int row = 0; row < my2DArrayD.size(); row++){
			ArrayList<Double> aRow = my2DArrayD.get(row);
			for(int col = 0; col < aRow.size();col++){
				Double anElement = aRow.get(col);
				System.out.println("The element at "+row+", "+col+" is "+anElement);
			}
		}
		
		//Question 3
		/* Using the code in Magic.java for reading and writing to and from a file 
		 * intFileRead read
		 * intFileWrite write 
		 * 
		 * and make two new methods for reading and writing double values to and from a file.
		 * You can use static methods for these
		 * 
		 * Put these (along with the other reading and writing files in Magic.java) into a new file
		 * called FileIO  
		 */
		
		
		//Question 4 
		/* Using the code below and in the file BuildingBlocksPanel as a guide create a new frame
		 * and panel that draws three ovals with three different colors
		 */
		
		JFrame frame = new JFrame("This is our Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Code to add a panel!
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(800,600));
		BuildingBlocksPanel bbPanel = new BuildingBlocksPanel();
		mainPanel.add(bbPanel);
		frame.getContentPane().add(mainPanel);
		frame.pack();

		frame.setVisible(true);
		
		//Code for my frame
		JFrame myFrame = new JFrame("This is my Frame");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Code to add my panel to my Frame!
		JPanel myMainPanel = new JPanel();
		myMainPanel.setPreferredSize(new Dimension(800,600));
		MyPanel mpPanel = new MyPanel();
		myMainPanel.add(mpPanel);
		myFrame.getContentPane().add(myMainPanel);
		myFrame.pack();

		myFrame.setVisible(true);
		
		//Question 5
		/* Using the code below and in the file BuildingBlocksTimerPanel and square as a guide create a new frame
		 * and a panel that draws an oval that moves gradually to the right
		 */
		
		JFrame frameTimer = new JFrame("This is our Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Code to add a panel!
		JPanel mainPanelTimer = new JPanel();
		mainPanel.setPreferredSize(new Dimension(800,600));
		BuildingBlocksTimerPanel bbTimerPanel = new BuildingBlocksTimerPanel();
		mainPanelTimer.add(bbTimerPanel);
		frameTimer.getContentPane().add(mainPanelTimer);
		frameTimer.pack();

		frameTimer.setVisible(true);
		
		
		Timer timer = new Timer(20, bbTimerPanel);
		timer.start();
		
		//Code for my timed frame!
		JFrame myFrameTimer = new JFrame("This is our Frame");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Code to add a panel!
		JPanel myMainPanelTimer = new JPanel();
		myMainPanel.setPreferredSize(new Dimension(800,600));
		MyTimerPanel myTimerPanel = new MyTimerPanel();
		myMainPanelTimer.add(myTimerPanel);
		myFrameTimer.getContentPane().add(myMainPanelTimer);
		myFrameTimer.pack();

		myFrameTimer.setVisible(true);
		
		
		Timer myTimer = new Timer(20, myTimerPanel);
		myTimer.start();
		
		ArrayList<ArrayList<RunData>> data = new ArrayList<ArrayList<RunData>>();
		ArrayList<RunData> row1 = new ArrayList<RunData>();
		row1.add(new RunData("RD1",5,10));
		row1.add(new RunData("RD2",6,12));
		row1.add(new RunData("RD3",7,14));
		
		ArrayList<RunData> row2 = new ArrayList<RunData>();
		row2.add(new RunData("RD2.1",5,10));
		row2.add(new RunData("RD2.2",6,12));
		row2.add(new RunData("RD2.3",7,14));
		
		data.add(row1);
		data.add(row2);
		FileIO.RunDataFileWrite("RunDataList1", data);
		
		ArrayList<ArrayList<RunData>> inData = FileIO.RunDataFileRead("RunDataList1");
		for(int i = 0; i < inData.size();i++){
			System.out.println("Row: "+(i+1));
			for(int j = 0; j < inData.get(i).size();j++){
				System.out.println(inData.get(i).get(j).toString());
			}
		}
	}

}
