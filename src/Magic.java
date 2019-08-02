import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/** 
 * Magic.Java
 * Version 4.0
 * @author ablock
 *
 */

public class Magic {


	// *** MAGIC LEVEL 0: Simple input/Output ***

	// Output methods
	public static void print(String output){
		System.out.print(output);
	}

	public static void print(int output){
		System.out.print(output);
	}

	public static void print(boolean output){
		System.out.print(output);
	}

	public static void print(double output){
		System.out.print(output);
	}

	public static void print(char output){
		System.out.print(output);
	}

	public static void println(String output){
		System.out.println(output);
	}

	public static void println(double output){
		System.out.println(output);
	}

	public static void println(int output){
		System.out.println(output);
	}

	public static void println(boolean output){
		System.out.println(output);
	}

	public static void println(char output){
		System.out.println(output);
	}

	public static int random(int max){
		Random rand = new Random();
		int number = rand.nextInt(max+1);
		return number;
	}

	// Input Methods
	private static Scanner scan = new Scanner(System.in); 
	public static int nextInt(){
		int rtn = scan.nextInt();
		scan.nextLine();
		return rtn;
	}

	public static double nextDouble(){
		double rtn = scan.nextDouble();
		scan.nextLine();
		return rtn;
	}

	public static float nextFloat(){
		float rtn = scan.nextFloat();
		scan.nextLine();
		return rtn;
	}

	public static long nextLong(){
		long rtn = scan.nextLong();
		scan.nextLine();
		return rtn;
	}

	public static short nextShort(){
		short rtn = scan.nextShort();
		scan.nextLine();
		return rtn;
	}

	public static byte nextByte(){
		byte rtn = scan.nextByte();
		scan.nextLine();
		return rtn;
	}

	public static boolean nextBoolean(){
		boolean rtn = scan.nextBoolean();
		scan.nextLine();
		return rtn;
	}

	public static String nextLine(){
		return scan.nextLine();
	}

	public static char nextCharacter(){
		String tmp = scan.next();
		char rtnChar = tmp.charAt(0);
		return rtnChar;
	}

	public static boolean fileExists(String fileName){
		return (new File(fileName)).isFile();
	}

	public static int[] simpleIntFileRead(String fileName){
		int[] rtnArray=null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;
			str = in.readLine();
			if (str!=null){
				String[] rawData = str.split(",");
				rtnArray = new int[rawData.length];
				for(int index = 0;index <rawData.length;index++ ){
					rtnArray[index] = Integer.parseInt(rawData[index]);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error");
		}
		return rtnArray;
	}

	public static int[][] intFileRead(String fileName){
		int[][] rtnArray=null;
		ArrayList<int[]> buildArray = null;
		int maxValue=0;
		try {
			buildArray = new ArrayList<int[]>();
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;
			str = in.readLine();
			while (str!=null){
				String[] rawData = str.split(",");
				if (rawData.length>maxValue){
					maxValue = rawData.length;
				}
				int[] tmpArray = new int[rawData.length];
				for(int index = 0;index <rawData.length;index++ ){
					tmpArray[index] = Integer.parseInt(rawData[index]);
				}
				buildArray.add(tmpArray);
				str = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error");
		}
		if(buildArray!=null){
			int rows = buildArray.size();
			rtnArray = new int[rows][maxValue];
			for(int row =0;row<rows;row++){
				int[] tmpArray = buildArray.get(row);
				for(int col=0;col<tmpArray.length;col++){
					rtnArray[row][col] =tmpArray[col]; 
				}
			}
		}
		return rtnArray;
	}

	public static void simpleIntFileWrite(String fileName, int[] data){
		try{
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			String printFile="";
			for(int i =0;i<data.length-1;i++){
				printFile+=data[i]+",";
			}
			if (data.length>0){
				printFile+=data[data.length-1];
			}
			writer.println(printFile);
			writer.close();
		} catch (IOException e) {
			System.out.println("File write Error");
		}
	}

	public static void intFileWrite(String fileName, int[][] data){
		try{
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");

			for(int j = 0;j<data.length;j++){
				String printFile="";
				System.out.println("j");
				for(int i =0;i<data[j].length-1;i++){
					printFile+=data[j][i]+",";
				}
				if (data[j].length>0){
					printFile+=data[j][data[j].length-1];
				}
				if(j==(data.length-1)){
					writer.print(printFile);
				} else {
					writer.println(printFile);
				}
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("File write Error");
		}
	}



	// *** Magic Level 2: Graphics ***
	public static JFrame frame = new JFrame("Magic Frame");
	public static MagicPanel primaryPanel= new MagicPanel();
	public static boolean startedDrawing = false;
	public static MagicImage image1 =new MagicImage();
	public static MagicImage image2 =new MagicImage();
	public static MagicImage image3 =new MagicImage();
	public static MagicImage image4 =new MagicImage();

	public enum MagicColor {Red, Blue, Green, Black, White, Magenta, Cyan, Gray, DarkGray, Yellow, Pink};


	private static void startDrawing(){
		if(!startedDrawing){
			frame.getContentPane().add(primaryPanel);
			primaryPanel.setPreferredSize(new Dimension(800,600));
			primaryPanel.setBackground(Color.white);
			frame.pack();
			frame.setVisible(true);
			startedDrawing = true;
			Magic.drawRectangle(0, 0, 800, 600, "white");
		}
	}

	private static Color convertMagicToNormalColor(MagicColor c){
		switch (c){
		case Red:
			return Color.red;
		case Blue:
			return Color.blue;
		case Green:
			return Color.green;
		case White:
			return Color.white;
		case Magenta:
			return Color.magenta;
		case Cyan:
			return Color.cyan;
		case Gray:
			return Color.gray;
		case DarkGray:
			return Color.darkGray;
		case Black:
			return Color.black;
		case Yellow:
			return Color.yellow;
		case Pink:
			return Color.pink;
		default:
			return Color.black;
		}
	}

	private static Color convertStringToNormalColor(String c){
		if(c.equalsIgnoreCase("red")){
			return Color.red;
		} else if(c.equalsIgnoreCase("blue")) {
			return Color.blue;
		} else if(c.equalsIgnoreCase("green")) {
			return Color.green;
		} else if(c.equalsIgnoreCase("white")) {
			return Color.white;
		} else if(c.equalsIgnoreCase("magenta")) {
			return Color.magenta;
		} else if(c.equalsIgnoreCase("cyan")) {
			return Color.cyan;
		} else if(c.equalsIgnoreCase("gray")) {
			return Color.gray;
		} else if(c.equalsIgnoreCase("darkGray")) {
			return Color.darkGray;
		} else if(c.equalsIgnoreCase("black")) {
			return Color.black;
		} else if(c.equalsIgnoreCase("yellow")) {
			return Color.yellow;
		} else if(c.equalsIgnoreCase("pink")) {
			return Color.pink;
		} else {
			return Color.black;
		}
	}

	public static void drawRectangle(int x, int y, int width, int height, String c){
		drawRectangle(x, y, width, height, convertStringToNormalColor(c));
	}

	public static void drawEmptyRectangle(int x, int y, int width, int height, String c){
		drawEmptyRectangle(x, y, width, height, convertStringToNormalColor(c));
	}


	public static void drawOval(int x, int y, int width, int height, String c){
		drawOval(x, y, width, height, convertStringToNormalColor(c));
	}

	public static void drawLine(int startX, int startY, int endX, int endY, String c){
		drawLine(startX, startY, endX, endY, convertStringToNormalColor(c));
	}

	public static void drawRectangle(int x, int y, int width, int height, MagicColor c){
		drawRectangle(x, y, width, height, convertMagicToNormalColor(c));
	}
	public static void drawEmptyRectangle(int x, int y, int width, int height, MagicColor c){
		drawEmptyRectangle(x, y, width, height, convertMagicToNormalColor(c));
	}

	public static void drawRectangle(int x, int y, int width, int height, Color c){
		startDrawing();
		MagicPaintObject paintObject = new MagicPaintObject(x,y,width,height,c, MagicObjectType.RECTANGLE);
		primaryPanel.addObject(paintObject);
		primaryPanel.updatePanel();
	}

	public static void drawEmptyRectangle(int x, int y, int width, int height, Color c){
		startDrawing();
		MagicPaintObject paintObject = new MagicPaintObject(x,y,width,height,c, MagicObjectType.EMPTY_RECTANGLE);
		primaryPanel.addObject(paintObject);
		primaryPanel.updatePanel();
	}


	public static void drawOval(int x, int y, int width, int height, Color c){
		startDrawing();
		MagicPaintObject paintObject = new MagicPaintObject(x,y,width,height,c, MagicObjectType.OVAL);
		primaryPanel.addObject(paintObject);
		primaryPanel.updatePanel();
	}

	public static void drawOval(int x, int y, int width, int height, MagicColor c){
		drawOval(x, y, width, height, convertMagicToNormalColor(c));
	}

	public static void drawLine(int startX, int startY, int endX, int endY, Color c){
		startDrawing();
		MagicPaintObject paintObject = new MagicPaintObject(startX,startY,endX,endY,c, MagicObjectType.LINE);
		primaryPanel.addObject(paintObject);
		primaryPanel.updatePanel();
	}

	public static void drawLine(int startX, int startY, int endX, int endY, MagicColor c){
		drawLine(startX, startY, endX, endY, convertMagicToNormalColor(c));
	}

	public static void updateImages(){
		startDrawing();
		primaryPanel.updateImages();
	}

	public static void clearImage1(){
		image1.clear();
		primaryPanel.updatePanel();
	}

	public static void clearImage2(){
		image2.clear();
		primaryPanel.updatePanel();
	}

	public static void clearImage3(){
		image3.clear();
		primaryPanel.updatePanel();
	}

	public static void clearImage4(){
		image4.clear();
		primaryPanel.updatePanel();
	}

	public static void clean(){
		primaryPanel.updatePanel();
	}

	public static void setImage1(String imageName){
		image1.setImage(imageName);
	}

	public static void setPosForImage1(int x, int y){
		image1.setPos(x, y);
	}

	public static void setImage2(String imageName){
		image2.setImage(imageName);
	}

	public static void setPosForImage2(int x, int y){
		image2.setPos(x, y);
	}

	public static void setImage3(String imageName){
		image3.setImage(imageName);
	}

	public static void setPosForImage3(int x, int y){
		image3.setPos(x, y);
	}

	public static void setImage4(String imageName){
		image4.setImage(imageName);
	}

	public static void setPosForImage4(int x, int y){
		image4.setPos(x, y);
	}


	public static void wait(int milliseconds){
		try{
			Thread.sleep(milliseconds);
		} catch(Exception e) {
		}
	}

	private enum MagicObjectType {OVAL, LINE, RECTANGLE, EMPTY_RECTANGLE};

	private static class MagicImage{
		private Image myImage;
		private boolean doesExist;
		private int x;
		private int y;

		public MagicImage(){
			doesExist= false;
		}


		public void setImage(String imageName){
			try{
				myImage = ImageIO.read(new File(imageName));
				doesExist= true;
			}catch (Exception e){
				myImage= null;
				System.out.println("OH OH! Can't find Iamge");
			}
		}

		public void clear(){
			myImage = null;
			doesExist = false;
		}
		public void setPos(int x, int y){
			this.x = x;
			this.y = y;
		}

		public void paint(Graphics page){
			if(doesExist){
				page.drawImage(myImage,x,y,null);
			}
		}
	}

	private static class MagicPaintObject{
		private int height, width, upperX, upperY;
		private Color color;
		private MagicObjectType objectType; 

		public void draw (Graphics page){
			page.setColor(color);
			switch(objectType){
			case OVAL:
				page.fillOval(upperX, upperY, width, height);
				break;
			case LINE:
				page.drawLine(upperX, upperY, width, height);
				break;
			case RECTANGLE:
				page.fillRect(upperX, upperY, width, height);
				break;
			case EMPTY_RECTANGLE:
				page.drawRect(upperX, upperY, width, height);
				break;
			default:
				break;
			}
		}

		public MagicPaintObject(int x, int y, int w, int h, Color c, MagicObjectType objType){
			height = h;
			width = w;
			upperX = x;
			upperY = y;
			color = c;
			objectType = objType;
		}

		/*		public int getHeight(){
			return height;
		}

		public int getWidth(){
			return width;
		}

		public int getX(){
			return upperX;
		}

		public int getY(){
			return upperY;
		}

		public MagicObjectType getObjectType(){
			return objectType;
		}

		public Color getColor(){
			return color;
		}

		public void setHeight(int h){
			height = h;
		}

		public void setWidth(int w){
			width = w;
		}

		public void setX(int x){
			upperX = x;
		}

		public void setY(int y){
			upperY = y;
		}

		public void setObjectType(MagicObjectType obj){
			objectType = obj;
		}

		public void setColor(Color c){
			color = c;
		}
		 */
	}

	private static class MagicPanel extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private ArrayList<MagicPaintObject> objectsToDisplay;

		public MagicPanel(){
			objectsToDisplay = new ArrayList<MagicPaintObject>();
		}

		public void addObject(MagicPaintObject paintObject){
			objectsToDisplay.add(paintObject);
		}

		public void paintComponent(Graphics page){
			super.paintComponent(page);
			for(int i=0; i<objectsToDisplay.size(); i++){
				objectsToDisplay.get(i).draw(page);
			}

			//Draw the three images
			image1.paint(page);
			image2.paint(page);
			image3.paint(page);
			image4.paint(page);
		}

		public void updatePanel(){
			paintComponent(this.getGraphics());
		}

		public void updateImages(){
			Graphics page= this.getGraphics();
			for(int i=0; i<objectsToDisplay.size(); i++){
				objectsToDisplay.get(i).draw(page);
			}
			image1.paint(page);
			image2.paint(page);
			image3.paint(page);
			image4.paint(page);
		}
	}	

}
