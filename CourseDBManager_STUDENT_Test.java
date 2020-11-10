package hw4_DataBasesCursesV2;



import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author ralexander
 *
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("MATH101",30200,3,"SC202","Diana Torrez");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() { 	
		dataMgr.add("MATH101",30200,3,"SC202","Diana Torrez");
		dataMgr.add("MATH103",30240,4,"SC404","Isabelle Villca");
		dataMgr.add("PHIS200",30550,4,"SC303","Aldo Ramos");
		ArrayList<String> list = dataMgr.showAll();
		
		assertEquals(list.get(0),"\nCourse:MATH103 CRN:30240 Credits:4 Instructor:Isabelle Villca Room:SC404");
		assertEquals(list.get(1),"\nCourse:PHIS200 CRN:30550 Credits:4 Instructor:Aldo Ramos Room:SC303");
		assertEquals(list.get(2),"\nCourse:MATH101 CRN:30200 Credits:3 Instructor:Diana Torrez Room:SC202");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			//File inputFile = new File("D:\\Montomery College\\CMSC 203\\ECLIPSE_FILES_CARLA\\CMSC204_A0Assigments\\src\\hw4_DataBasesCursesV2\\Test1.txt");
			File inputFile = new File("Test1Student.txt"); //but creates the file outsite the package, however still is reached when we read it

			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("MATH101 30200 3 SC202 Diana Torrez");
			inFile.print("MATH103 30240 4 SC404 Isabelle Villca");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			//System.out.println(dataMgr.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
