import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class FileIOTests {

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
		
		assertTrue("Didn't read and/or write correctly.",inData == data);
	}

}
