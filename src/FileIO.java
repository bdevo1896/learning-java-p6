import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class FileIO {

	public FileIO() {

	}

	/**
	 * Reads 'double' values from a file with the same name as 'filename'.
	 * @param fileName
	 * @return
	 */
	public static double[][] doubleFileRead(String fileName){
		double[][] rtnArray=null;
		ArrayList<double[]> buildArray = null;
		int maxValue=0;
		try {
			buildArray = new ArrayList<double[]>();
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;
			str = in.readLine();
			while (str!=null){
				String[] rawData = str.split(",");
				if (rawData.length>maxValue){
					maxValue = rawData.length;
				}
				double[] tmpArray = new double[rawData.length];
				for(int index = 0;index <rawData.length;index++ ){
					tmpArray[index] = Double.parseDouble(rawData[index]);
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
			rtnArray = new double[rows][maxValue];
			for(int row =0;row<rows;row++){
				double[] tmpArray = buildArray.get(row);
				for(int col=0;col<tmpArray.length;col++){
					rtnArray[row][col] =tmpArray[col]; 
				}
			}
		}
		return rtnArray;
	}

	/**
	 * Writes a file under the 'filename' with 'double' values.
	 * @param fileName
	 * @param data
	 */
	public static void doubleFileWrite(String fileName, double[][] data){
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

	/**
	 * Reads 'int' values from the specified file.
	 * @param fileName
	 * @return
	 */
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

	/**
	 * Reads 'int' the specified files (can read multiple lines)
	 * @param fileName
	 * @return
	 */
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

	/**
	 * Writes 'int' values from the specified file (only single lined files)
	 * @param fileName
	 * @param data
	 */
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

	/**
	 * Writes 'int' values to a file (Multiple rows)
	 * @param fileName
	 * @param data
	 */
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

	//For Part D.
	/**
	 * Writes a file under the 'filename' with 'double' values.
	 * @param fileName
	 * @param data
	 */
	public static void RunDataFileWrite(String fileName, ArrayList<ArrayList<RunData>> data){
		try{
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");

			for(int j = 0;j<data.size();j++){
				String printFile="";
				System.out.println("j");
				for(int i =0;i<data.get(j).size();i++){
					RunData runD = data.get(j).get(i);
					printFile+=runD.getTitle()+","+runD.getDistanceInMiles()+","+runD.getTime()+" ";
					writer.print(printFile);
					printFile="";
				}
				writer.println();
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("File write Error");
		}
	}

	/**
	 * Reads 'int' the specified files (can read multiple lines)
	 * @param fileName
	 * @return
	 */
	public static ArrayList<ArrayList<RunData>> RunDataFileRead(String fileName){
		ArrayList<ArrayList<RunData>> rtnArray=null;
		ArrayList<ArrayList<RunData>> buildArray = null;
		int maxValue=0;
		try {
			buildArray = new ArrayList<ArrayList<RunData>>();
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;
			str = in.readLine();
			while (str!=null){
				ArrayList<RunData> runDList = new ArrayList<RunData>();
				String[] rawData1 = str.split(" ");
				if (rawData1.length>maxValue){
					maxValue = rawData1.length;
				}

				String rawDLine = "";
				for(int i = 0; i < rawData1.length; i++){
					rawDLine+=rawData1[i];
					String[] rawData2 = rawDLine.split(",");
					double distanceInMiles = Double.parseDouble(rawData2[1]);
					double time = Double.parseDouble(rawData2[2]);
					runDList.add(new RunData(rawData2[0],distanceInMiles,time));
					rawDLine = "";
				}
				buildArray.add(runDList);
				str = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error");
		}
//		if(buildArray!=null){
//			int rows = buildArray.size();
//			rtnArray = new int[rows][maxValue];
//			for(int row =0;row<rows;row++){
//				int[] tmpArray = buildArray.get(row);
//				for(int col=0;col<tmpArray.length;col++){
//					rtnArray[row][col] =tmpArray[col]; 
//				}
//			}
//		}
		
		rtnArray = buildArray;
		return rtnArray;
	}
}
