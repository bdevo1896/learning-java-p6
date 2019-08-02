import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class RunDataTests {

	//Tests the 'getTimeAsString' method.
	@Test
	public void testGetTimeAsString() {

		RunData runD = new RunData("Bryce",2.0,64.4);

		assertTrue("Didn't display correctly.",runD.getTimeAsString().equals("1:04:24"));

		RunData runD2 = new RunData("",0,35);

		assertTrue("Didn't display correctly."+runD2.getTimeAsString(),runD2.getTimeAsString().equals("0:35:00"));

		RunData runD3 = new RunData("",0,0);

		assertTrue("Didn't display correctly."+runD3.getTimeAsString(),runD3.getTimeAsString().equals("0:00:00"));
	}
	
	//Tests the 'getPace' method.
	@Test
	public void testGetPace(){
		
		RunData runD = new RunData("",3,39);
		
		assertTrue("Didn't calculate correctly."+runD.getPace(),runD.getPace()== 13.0);
		
		RunData runD2 = new RunData("",0,1);
		
		assertTrue("Divided by 0 for some reason."+runD2.getPace(),runD2.getPace()==0.0);
		
		RunData runD3 = new RunData("",1,13);
		
		assertTrue("Didn't calculate correctly."+runD3.getPace(),runD3.getPace()==13.0);
	}
	
	//Tests the 'getPaceAsString' method.
	@Test
	public void testGetPaceAsString(){
		
		RunData runD = new RunData("",3,39);
		
		assertTrue("Didn't work for some reason."+runD.getPaceAsString(),runD.getPaceAsString().equals("0:13:00"));
		
		RunData runD2 = new RunData("",0,1);
		
		assertTrue("Didn't work for some reason."+runD2.getPaceAsString(),runD2.getPaceAsString().equals("0:00:00"));
		
		RunData runD3 = new RunData("",1,13);
		
		assertTrue("Didn't work for some reason."+runD3.getPaceAsString(),runD3.getPaceAsString().equals("0:13:00"));
	}
	
	//Tests the filing methods of FileIO for RunData 2D ArrayLists
	@Test
	public void testFilingMethods() {
		
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
		FileIO.RunDataFileWrite("TestList", data);
		
		ArrayList<ArrayList<RunData>> inData = FileIO.RunDataFileRead("TestList");
		
		assertTrue("Didn't read and/or write correctly.",inData.equals(data));
	}

}
