package hw4_DataBasesCursesV2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * LinkedList ivokes all the methods provides by java. 
 * And for this proyect, think about LinkedList like it was an simple ArrayList.
 * That helps to undestand how there will be a LinkedList (supouse it is ArrayList) will be 
 * inside another LinkedList array(ArrayList)
 * @author cpled
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBElement cdbe;
	private CourseDBStructure cDBS;
	private int size;


	public CourseDBManager() {
		//Create an structure with defauld size of the array inside
		size=16;//By default	
		cDBS=new CourseDBStructure(size);
	}//end default constructor

	public CourseDBManager(int aSize) {
		this.size=aSize;	
		cDBS=new CourseDBStructure(size);
	}//end constructor

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {

		cdbe= new CourseDBElement(id,crn,credits,roomNum,instructor);
		//if null create a new structure
		if(cDBS == null) {
			//Create an structure obj with defauld size of the array inside
			cDBS=new CourseDBStructure();
		}
		//At this point the the structure is not null or was already created
		cDBS.add(cdbe);

	}

	/**get an object by using the crn as a key to search*/
	@Override
	public CourseDBElement get(int crn) {

		try {
			return cDBS.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**Read from a file and add it to the hashTable*/
	@Override
	public void readFile(File inputFile) throws FileNotFoundException {
		//At this point the inputFile is not null, so we can use inputFile

		// Create a Scanner for the file
		Scanner input;

		try {
			input = new Scanner(inputFile);
			// Read data from a file
			while (input.hasNext()) {
				String id=input.next();
				int crn=input.nextInt();
				int credits=input.nextInt();
				//IMPORTANT consume the remaining newline character
				// Only when we read from Systema in. Scanner scan=new Scanner (System.in);
				//When we read from a file, there is not remaining newLine character
				//input.nextLine();//No needed
				String roomNum=input.next();
				String instructor=input.nextLine();//get all the rest of the strings
				
				//Acoording to the instructions we have to add the items read from the file
				add( id, crn, credits, roomNum, instructor);
			
			}

			// Close the file outside the while, otherwise it will close the file before reaching the second item
			input.close();
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("Carla here is the e.getMessage(): " + e.getMessage() );
		}
	}
	/**Show all the items in the table*/
	@Override
	public ArrayList<String> showAll() {

		ArrayList<String> arrDBS= new ArrayList<String>();

		for (int i = 0; i < cDBS.getTableSize(); i++) {
			// Print out the toString version of each element in the arr
			//Create a LinkedL where we will store all what is in arr[i]. And because hashtable in is a LinkedList array of DBS(like bankAccount) so, items has to be a linkedList as well to hold each item of the array in the i possition 
			LinkedList<CourseDBElement> items = cDBS.hashTable[i];

			//if the LinkedList is null, dont do anything
			//if not null, add each DBE element obj stored in that link to the ArrayList. Using the enhance for loop 
			if (items != null) {
				for(CourseDBElement item : items) {
					arrDBS.add(item.toString()); 				
				}
			}

		}
		return arrDBS;
	}

}
