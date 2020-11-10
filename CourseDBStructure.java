package hw4_DataBasesCursesV2;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * LinkedList ivokes all the methods provides by java. 
 * And for this proyect, think about LinkedList like it was an simple ArrayList.
 * That helps to undestand how there will be a LinkedList (supouse it is ArrayList) will be 
 * inside another LinkedList array(ArrayList)
 * @author cpled
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{

	private int size;//estimatedSize of HashTab
	private String strForTest;
	//hashTable  is an array
	public LinkedList<CourseDBElement> [] hashTable;//array of LinkendList from java

	@SuppressWarnings("unchecked")
	public CourseDBStructure() {
		this.size = 16;//default by theory
		hashTable =new LinkedList[size];
		for(int i=0; i<16; i++) {
			hashTable[i] = null;
		}
	}//end defauld constructor
	/**
	 * Create a hash table with a specified initial size.
	 * Precondition: initalSize > 0.
	 */
	public CourseDBStructure(int size) {

		if (size <= 0)
			throw new IllegalArgumentException("Illegal table size");
		this.size = size;
		hashTable = new LinkedList[size];
		for(int i=0; i<size; i++) {
			hashTable[i] = null;
		}
	}//end constructor

	public CourseDBStructure( String strForTest,int size) {
		if (size <= 0)
			throw new IllegalArgumentException("Illegal table size");
		this.size = size;
		this.strForTest = strForTest;
		hashTable =new LinkedList[size];
		for(int i=0; i<size; i++) {
			hashTable[i] = null;
		}
	}//end constructor

	//	//getIndex method. No used 
	//	private int hash(Object key) {
	//		return (Math.abs(key.hashCode())) % hashTable.length;
	//	}

    /**Add an object*/
	@Override
	public void add(CourseDBElement element) {
		//Declare a Key
		String key=element.getStringCRN();

		//calculate getIndex using the MOD formula
		int index = key.hashCode() % size;

		//Create a LinkedL where we will store all what is in arr[i]. It is like saying that each element of the arr is going to be another ArrayList(In this case LinkedList). That is cool because that internal ArrayList(LinkedList) will hold more items 
		LinkedList<CourseDBElement> items = hashTable[index];

		if(items == null) {
			//Create a defauld LinkedList
			items = new LinkedList<CourseDBElement>();

			//Add the element/item to LinkedList using the LinkedList java methods.
			items.add(element);

			//Assign the LinkedList/BankAccount to the array in the index correspondient
			hashTable[index] = items;
		} 
		//At this point the LinkedList is not null
		/*Search all the items in the LinkedList items  using Enhance for loop and
		compare if both elements are equal. 
		If equal, then do not add. Dont do anything*/
		else {
			for(CourseDBElement item : items) {

				//Also works//if(item.getStringCRN().equals(key)) {
				//the compareTo methods was overriden
				if(item.compareTo(element)==0) {
					return; //meaning do not do anything
				}
			}
			//At this point they are not equal, so add the element
			items.add(element);
		}

	}//end add

	//return un obj of type class
	/**
	 * Return un obj of type class
	 * @param key the parameter string the represents curseCRN in String format
	 * @return an object of CourseDBElement
	 */
	private CourseDBElement getObj(String key) {
		if(key == null)
			return null;

		int index = key.hashCode() % size;
		//Create a LinkedL where we will store all what is in arr[i]
		LinkedList<CourseDBElement> items = hashTable[index];

		if(items == null)
			return null;

		//Search for the cde item that match the key we are looking for
		for(CourseDBElement item : items) {
			if(item.getStringCRN().equals(key))//change to compare to
				return item;
		}
		return null;
	}//end getObj


	/**get and object by its crn*/
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String stringCRN= Integer.toString(crn);

		CourseDBElement item = getObj(stringCRN);
		if(item == null)
			//return null;
		throw new IOException(" This CDE object does not exist");
		else
			return item;
	}
	@Override
	public int getTableSize() {
		return size;
	}

}//end get


