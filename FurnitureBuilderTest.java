/**
 ** @author Adeshpal Virk, Hannah Oluyemisi Asaolu, Tyler Galea, Cole Barraclough
 * @since April 3, 2021
 * @version 1.0
 * {@summary} This class tests the various methods in the FurnitureBuilder class
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FurnitureBuilderTest {
	
	public FurnitureBuilderTest() {}

	
	//Takes in an array of furniture objects and returns every possible combination
	//This test tests the number of subsets
	@Test
	public void testFindAllSubsetsLength() {
		Filing file1 = new Filing("F003", "Large", "N", "N", "Y", 150, "002");
		Filing file2 = new Filing("F010", "Large", "Y", "N", "Y", 225, "002");
		Filing file3 = new Filing("F011", "Large", "N", "Y", "Y", 225, "005");
		Filing file4 = new Filing("F012", "Large", "N", "Y", "N", 75, "005");
		Filing file5 = new Filing("F015", "Large", "Y", "N", "N", 75, "004");
		
		Furniture[] objs = new Furniture [5];
		objs[0] = file1; objs[1] = file2; objs[2] = file3; objs[3] = file4; objs[4] = file5;

		int i=objs.length; int num = factorialCalc(objs.length);
		int expected = 1;
		
		
		for (int j = 0; j<objs.length; j++) {
			expected += num/(factorialCalc(j)*factorialCalc(objs.length- j));
		}
				
		FurnitureBuilder test = new FurnitureBuilder();
		int actual = test.findAllSubsets(objs).length;
		
	
		assertEquals("Correct number ofsubset combinations ", expected, actual);
				
	}
	
	//Takes in an array of furniture objects and returns every possible combination
	//This test tests all combinaton of subsets
	@SuppressWarnings({ "deprecation", "unlikely-arg-type" })
	@Test
	public void testFindAllSubsets() {
		Lamp swing1 = new Lamp("L053", "Swing Arm", "Y", "N", 27, "002");
		Lamp swing2  = new Lamp("L096", "Swing Arm", "N", "Y", 3, "002");
		Lamp swing3  = new Lamp("L487", "Swing Arm", "Y", "N", 27, "002");
		Lamp swing4  = new Lamp("L879", "Swing Arm", "N", "Y", 3, "005");
		
		
		Furniture[] objs = new Furniture [4];
		objs[0] = swing1; objs[1] = swing2; objs[2] = swing3; objs[3] = swing4;
		
		//Creating a combination of subset using the furniture ID only
		String check="{}";
				
		//generate combination of one item
		for(int i=0; i<objs.length; i++) {
			check+="\n{[" + objs[i].getId() + "]}";
		}
				
		//generate combos of two items
		for(int i =0, j =0; j<objs.length-1; j++) {
			check+="\n{[" + objs[i].getId() + "]" + "[" + objs[j+1].getId() + "]}";
		}
		for(int i =1,j=1; j<objs.length-1;j++) {
			check+="\n{[" + objs[i].getId() + "]" + "[" + objs[j+1].getId() + "]}";
		}
		for(int i =2,j=2; j<objs.length-1;j++) {
			check+="\n{[" + objs[i].getId() + "]" + "[" + objs[j+1].getId() + "]}";
		}
			
		//generate combos of three items
		check+="\n{[" + objs[0].getId() + "]" + "[" + objs[1].getId() + "]["+ objs[2].getId() + "]}";
		check+="\n{[" + objs[0].getId() + "]" + "[" + objs[1].getId() + "]["+ objs[3].getId() + "]}";
		check+="\n{[" + objs[1].getId() + "]" + "[" + objs[2].getId() + "]["+ objs[3].getId() + "]}";
		check+="\n{[" + objs[0].getId() + "]" + "[" + objs[2].getId() + "]["+ objs[3].getId() + "]}";
		
		//a combination of four items
		check+="\n{[" + objs[0].getId() + "][" + objs[1].getId() + "]" + "[" + objs[2].getId() + "]["+ objs[3].getId() + "]}";
		
		//Converting the string to an Arraylist
		String[] checksplit = check.split("\n");
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList(checksplit));
		
		FurnitureBuilder test = new FurnitureBuilder();
		Furniture[][] all = test.findAllSubsets(objs);
		
		//Converting the results of findAllSubsets into an Arraylist
		//so that we may compare against the expected Arraylist
		String wait="";
		for (int i=0; i< all.length; i++) {
			wait+="{";
			//System.out.print("{");
			for(int j=0; j<all[i].length; j++) {
				wait +="[" + all[i][j].getId() + "]";
			}
			wait+="}\n";
		}
		ArrayList<String> actual = new ArrayList<String>(Arrays.asList(wait.split("\n")));
		
		assertEquals("Generated the same "
				+ "combination of objects"
				, expected.containsAll(actual), actual.containsAll(expected));		

		
	}
	
	/**
	 * Tests that it cannot build more than 3 desks
	 */
	@Test
	public void testBuildFurniture() {
		
		FurnitureBuilder test = new FurnitureBuilder();
 		
		Desk one = new Desk("D1030", "Adjustable", "N", "Y", "N",150,"002");
        Desk two = new Desk("D2746", "Adjustable", "Y", "N", "Y",250,"004");
        Desk three = new Desk("D3682", "Adjustable", "N", "N", "Y",50,"005");
        Desk four = new Desk("D4475", "Adjustable", "N", "Y", "Y",200,"002");
        Desk five = new Desk("D5437", "Adjustable", "Y", "N", "N",200,"001");
        Desk six =new Desk("D7373", "Adjustable", "Y", "Y", "N",350,"005");
        
        Furniture [] desks = new Desk[6];
        desks[0] = one; desks[1] =two; desks[2] = three; desks[3] = four;
        desks[4] = five; desks[5] =six;
        
		assertFalse("Unable to build more than 3 furnitures", test.buildFurniture(desks, 4));
	}
	
	@Test
    /**
     * Builds the list for 2 of the cheapest and then outputs the
     * ids of those and tests if they all work
     */
    public void testGetIds() {
        FurnitureBuilder test = new FurnitureBuilder();

        //Create an array of furniture type
        Chair[] chairs = new Chair[5];
        chairs[0] = new Chair("C5842", "Task", "Y", "N", "Y", "N", 50, "002");
        chairs[1] = new Chair("C7492", "Task", "Y", "N", "N", "Y", 25, "003");
        chairs[2] = new Chair("C3847", "Task", "N", "Y", "Y", "N", 125, "004");
        chairs[3] = new Chair("C4893", "Task", "N", "Y", "N", "Y", 100, "002");
        chairs[4] = new Chair("C3884", "Task", "N", "Y", "N", "Y", 75, "003");

        //Expected ids is any 2 of the ids in the expected array
        String [] expected = {"C5842","C7492","C3847", "C4893", "C3884"};
                
        //Build 2 furnitures
        test.buildFurniture(chairs, 1);
        String [] actual = test.getIds();
        
        //All items in the actual array must be presented in the expected array.
        //If an item in the actual array isnt in the expected array, the count value is
        //less than the actual array's length
        int count = 0;
        for(int i=0; i<actual.length; i++) {
        	if (Arrays.asList(expected).contains(actual[i]) ) {
        		count++;
        	}
        }
             
        assertEquals(actual.length, count);
      }
	
	/**
	 * Tests the ability of the getPrice method to return the lowest 
	 * price for requested number of furniture.
	 */
	@Test
	public void testGetPrice() {
		Desk one = new Desk("D0890", "Traditional", "N", "N", "Y",25,"002");
        Desk two = new Desk("D4231", "Traditional", "N", "Y", "Y",50,"005");
        Desk three = new Desk("D8675", "Traditional", "Y", "Y", "N",75,"001");
        Desk four = new Desk("D9352", "Traditional", "Y", "N", "Y",75,"002");
        
        Desk[] desks = new Desk[4];
        desks[0] = one; desks[1] =two; desks[2] = three; desks[3] = four;
        
        //If wishing to build 2 desks, expected cost is the price of desk #3 and #1
        //+ desk #2 and desk#4
        int expected = 225;
        
        //Access the getPrice() to see if we get the same price for building 2 desks
        //but first, call the buildFurniture to select the number of furnitures
        FurnitureBuilder test = new FurnitureBuilder();
        test.buildFurniture(desks, 2);
        int actual = test.getPrice();
        
        assertEquals(expected, actual);
        
	}
	
	/**
	 * Confirms that we indeed get a list of the cheapest furniture we can build
	 * based on the type, category and requested number. This test will compare the ids
	 * of the expected and actual buildlists 
	 * @param value
	 * @return
	 */
	@Test
	public void testGetBuildList() {
		Lamp one = new Lamp("L223", "Study", "N", "Y", 2, "005");
		Lamp two  = new Lamp("L928", "Study", "Y", "Y", 10, "002");
		Lamp three  = new Lamp("L980", "Study", "N", "Y", 2, "004");
		Lamp four  = new Lamp("L982", "Study", "Y", "N", 8, "002");
		
		Furniture[] lamps = new Furniture[4];
		lamps[0]= one; lamps[1]= two; ; lamps[2] =three; lamps[3] = four;
		
		//The cheapest 2 furnitures we can expect to build have these ids
		String [] arr = {"L928", "L980", "L982","L223"};
		
		//Because we can build two furnitures at the same cost from either "L223" and "L982"
		//or "L928" and "L982" as well aas "L980", then the method will past this test
		//if it includes "L982" and "L928" which both variations have in common
		ArrayList<String>expected = new ArrayList<>();
		expected.add(arr[0]); expected.add(arr[2]);
		
		FurnitureBuilder test = new FurnitureBuilder();
		test.buildFurniture(lamps, 2);
		
		ArrayList<ArrayList<Furniture>> actual = test.getBuildList();
		int result = 0;
		for (int i=0; i< actual.size(); i++) {
			for (int j=0; j<actual.get(i).size(); j++) {
				if (expected.contains(actual.get(i).get(j).getId()) ) {
					result++;
				}
			}
		}
		assertEquals("Successfully built two lamps", expected.size(), result);
		
	}
		
		
		
	
	public int factorialCalc(int value) {
		int result = 1;
		for (int i=value; i>0; i--) {
			result*=i;
		}
		return result;
	}
	
	
	//Test the different combinations that can build a furniture
	@Test
	public void testCheckArray() {
		Filing one = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");
        Filing two = new Filing("F004", "Small", "N", "Y", "Y", 75, "004");
        Filing three = new Filing("F005", "Small", "Y", "N", "Y", 75, "005");
        Filing ofour = new Filing("F006", "Small", "Y", "Y", "N", 50, "005");
        Filing five = new Filing("F013", "Small", "N", "N", "Y", 50, "002");
        
        Furniture [] files = new Furniture[5];
        files[0] = one; files[1] =two; files[2] = three; files[3] = ofour; files[4] =five;
                
        ArrayList<String>expected = new ArrayList<>();
        
        //The loop makes pairs that can build a furniture set
        for(int i=0; i<files.length; i++) {
        	for(int j =i+1; j<files.length; j++) {
        		boolean [] arr0 = files[i].getParts();
        		boolean[] arr1 = files[j].getParts();
        		
        		if( (arr0[0] == true || arr1[0] == true) && (arr0[1] == true || arr1[1] == true)
        				&& (arr0[2] == true || arr1[2] == true)) {
        			String ans = "[" + files[i].getId() + "][" + files[j].getId() + "]\n";
        			expected.add(ans);
        		}
        	}
        }
        
        //This loop makes 3 combinations that can build a furniture set
        for(int i=0; i<files.length; i++) {
        	for(int j =i+1; j<files.length; j++) {
        		for (int k =j+1; k<files.length; k++) {
        	  		boolean [] arr0 = files[i].getParts();
            		boolean[] arr1 = files[j].getParts();
            		boolean[] arr2 = files[k].getParts();
            		
            		if( (arr0[0] == true || arr1[0] == true || arr2[0] == true) && 
            				(arr0[1] == true || arr1[1] == true || arr2[1] == true)
            				&& (arr0[2] == true || arr1[2] == true|| arr2[2] == true) ) {
            			String ans = "[" + files[i].getId() + "][" + files[j].getId() + "][" + files[k].getId() + "]\n";
            			expected.add(ans);
        		}
              		
        	}
        	}
        }
        
        //This loop makes 4 combinations that can build a furniture set
        for(int i=0; i<files.length; i++) {
        	for(int j =i+1; j<files.length; j++) {
        		for (int k =j+1; k<files.length; k++) {
        			for(int l= k+1; l<files.length; l++ ) {
        				String ans="";
            	  		boolean [] arr0 = files[i].getParts();
                		boolean[] arr1 = files[j].getParts();
                		boolean[] arr2 = files[k].getParts();
                		boolean[] arr3 =files[l].getParts();
                		
                		if( (arr0[0] == true || arr1[0] == true || arr2[0] == true || arr3[0] == true) && 
                				(arr0[1] == true || arr1[1] == true || arr2[1] == true || arr3[1] == true)
                				&& (arr0[2] == true || arr1[2] == true|| arr2[2] == true || arr3[2] == true) ) {
                			ans += "[" + files[i].getId() + "][" + files[j].getId() + "][" + files[k].getId()
                					 + "]["+ files[l].getId() + "]\n";
                			expected.add(ans);
        			}
            		
            	       		}
              		
        	}
        	}
        }
      
        
        //5 combo - final combination that can build a furniture
        String ans = "[" + files[0].getId() + "][" + files[1].getId() + "][" + files[2].getId()
				 + "]["+ files[3].getId()+ "]["+ files[4].getId() + "]\n";
        expected.add(ans);
        
        
        //Passing the FILING array to compare against our expected furniture combinations
        FurnitureBuilder test = new FurnitureBuilder();
        Furniture[][] out = test.findAllSubsets(files);
        ArrayList<ArrayList<Furniture>>workingArray = test.checkArray(out);
        ArrayList<String>actual = new ArrayList<String>();
             
        //This loop places the result of the checkArray method into a single ArrayList
        String comb="";
        for(int i=0; i<workingArray.size(); i++) {
        	int j=0;
        	while(j<workingArray.get(i).size()) {
        		comb +="[" + workingArray.get(i).get(j).getId() + "]";
        		j++;
        	}
        	comb+="\n";actual.add(comb);
        	comb="";
        }
        
        //Sort both the expected and actual arraylists and compare them
        Collections.sort(actual); Collections.sort(expected);
        
        assertTrue(actual.containsAll(expected));
     
        }
	

	/**
	 * Creates a ArrayList of Chair objects and test if
	 * FurnitureBuilder.java can return the cheapest combination
	 * of chairs that can successfully create 1 chair of
	 * the specified type
	 */
	@Test
	public void testFurnitureBuilderChair1() {
        
        FurnitureBuilder mb = new FurnitureBuilder();

        Chair[] chairs = new Chair[5];

        chairs[0] = new Chair("C5842", "Task", "Y", "N", "Y", "N", 50, "002");
        chairs[1] = new Chair("C7492", "Task", "Y", "N", "N", "Y", 25, "003");
        chairs[2] = new Chair("C3847", "Task", "N", "Y", "Y", "N", 125, "004");
        chairs[3] = new Chair("C4893", "Task", "N", "Y", "N", "Y", 100, "002");
		chairs[4] = new Chair("C3884", "Task", "N", "Y", "N", "Y", 75, "003");

        mb.buildFurniture(chairs, 1);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"C5842", "C3884"}};
		assertTrue("A non-cheapest list of chairs was returned", Arrays.deepEquals(idList, check));
	}
	
	@Test
	
	/**
	 * Creates a ArrayList of Chair objects and test if
	 * FurnitureBuilder.java list can return the cheapest combination
	 * of chairs that can successfully create 2 chairs of
	 * the specified type
	 */
	
	public void testFurnitureBuilderChair2() {
        
        FurnitureBuilder mb = new FurnitureBuilder();

        Chair[] chairs = new Chair[5];

        chairs[0] = new Chair("C5842", "Task", "Y", "N", "Y", "N", 50, "002");
        chairs[1] = new Chair("C7492", "Task", "Y", "N", "N", "Y", 25, "003");
        chairs[2] = new Chair("C3847", "Task", "N", "Y", "Y", "N", 125, "004");
        chairs[3] = new Chair("C4893", "Task", "N", "Y", "N", "Y", 100, "002");
		chairs[4] = new Chair("C3884", "Task", "N", "Y", "N", "Y", 75, "003");

        mb.buildFurniture(chairs, 2);
		ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
		String[][] idList = new String[test.size()][];
		for(int i = 0; i < test.size(); i++){
			idList[i] = new String[test.get(i).size()];
			for(int j = 0; j < test.get(i).size(); j++){
				idList[i][j] = test.get(i).get(j).getId();
			}
		}
		String[][] check = {{"C5842", "C3884"}, {"C7492", "C3847"}};
		assertTrue("A non-cheapest list of chairs was returned", Arrays.deepEquals(idList, check));
	}

@Test

/**
 * Creates a ArrayList of Chair objects and test if
 * FurnitureBuilder.java can detect that it is impossible
 * to create 3 chairs of the specified type
 */

public void testFurnitureBuilderChair3() {
    
    FurnitureBuilder mb = new FurnitureBuilder();

    Chair[] chairs = new Chair[5];

    chairs[0] = new Chair("C5842", "Task", "Y", "N", "Y", "N", 50, "002");
    chairs[1] = new Chair("C7492", "Task", "Y", "N", "N", "Y", 25, "003");
    chairs[2] = new Chair("C3847", "Task", "N", "Y", "Y", "N", 125, "004");
    chairs[3] = new Chair("C4893", "Task", "N", "Y", "N", "Y", 100, "002");
	chairs[4] = new Chair("C3884", "Task", "N", "Y", "N", "Y", 75, "003");

	assertFalse("Failed to detect that the build was impossible", mb.buildFurniture(chairs, 3));
}

@Test

/**
 * Creates a ArrayList of Desk objects and test if
 * FurnitureBuilder.java can return the cheapest combination
 * of desks that can successfully create 1 desk of
 * the specified type
 */

public void testFurnitureBuilderDesk1() {
    
    FurnitureBuilder mb = new FurnitureBuilder();

    Desk[] desks = new Desk[5];

    desks[0] = new Desk("D3456", "Standing", "Y", "N", "N", 25, "002");
    desks[1] = new Desk("D8478", "Standing", "Y", "Y", "Y", 300, "003");
    desks[2] = new Desk("D8035", "Standing", "Y", "Y", "N", 125, "004");
    desks[3] = new Desk("D0843", "Standing", "Y", "Y", "N", 100, "002");
	desks[4] = new Desk("D0693", "Standing", "N", "N", "Y", 75, "003");

    mb.buildFurniture(desks, 1);
	ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
	String[][] idList = new String[test.size()][];
	for(int i = 0; i < test.size(); i++){
		idList[i] = new String[test.get(i).size()];
		for(int j = 0; j < test.get(i).size(); j++){
			idList[i][j] = test.get(i).get(j).getId();
		}
	}
	String[][] check = {{"D0843", "D0693"}};
	assertTrue("A non-cheapest list of desks was returned", Arrays.deepEquals(idList, check));
}

@Test

/**
 * Creates a ArrayList of Filing objects and test if
 * FurnitureBuilder.java can return the cheapest combination
 * of filings that can successfully create 1 filing of
 * the specified type
 */

public void testFurnitureBuilderFiling1() {
    
    FurnitureBuilder mb = new FurnitureBuilder();

    Filing[] filings = new Filing[5];

    filings[0] = new Filing("F023", "Small", "N", "Y", "Y", 150, "002");
    filings[1] = new Filing("F025", "Small", "Y", "Y", "Y", 300, "003");
    filings[2] = new Filing("F054", "Small", "Y", "N", "N", 50, "004");
    filings[3] = new Filing("F028", "Small", "N", "Y", "N", 50, "002");
	filings[4] = new Filing("F015", "Small", "N", "N", "Y", 50, "003");

    mb.buildFurniture(filings, 1);
	ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
	String[][] idList = new String[test.size()][];
	for(int i = 0; i < test.size(); i++){
		idList[i] = new String[test.get(i).size()];
		for(int j = 0; j < test.get(i).size(); j++){
			idList[i][j] = test.get(i).get(j).getId();
		}
	}
	String[][] check = {{"F054", "F028", "F015"}};
	assertTrue("A non-cheapest list of filings was returned", Arrays.deepEquals(idList, check));
}

@Test

/**
 * Creates a ArrayList of Lamp objects and test if
 * FurnitureBuilder.java can return the cheapest combination
 * of lamps that can successfully create 1 lamp of
 * the specified type
 */

public void testFurnitureBuilderLamp1() {
    
    FurnitureBuilder mb = new FurnitureBuilder();

    Lamp[] lamps = new Lamp[5];

    lamps[0] = new Lamp("L030", "Desk", "N", "Y", 10, "002");
    lamps[1] = new Lamp("L374", "Desk", "Y", "Y", 300, "003");
    lamps[2] = new Lamp("L394", "Desk", "Y", "N", 11, "004");
    lamps[3] = new Lamp("L340", "Desk", "Y", "N", 10, "002");
	lamps[4] = new Lamp("L163", "Desk", "N", "Y", 10, "003");

    mb.buildFurniture(lamps, 1);
	ArrayList<ArrayList<Furniture>> test = mb.getBuildList();
	String[][] idList = new String[test.size()][];
	for(int i = 0; i < test.size(); i++){
		idList[i] = new String[test.get(i).size()];
		for(int j = 0; j < test.get(i).size(); j++){
			idList[i][j] = test.get(i).get(j).getId();
		}
	}
	String[][] check = {{"L030", "L340"}};
	assertTrue("A non-cheapest list of lamps was returned", Arrays.deepEquals(idList, check));
}


	
}

	
   