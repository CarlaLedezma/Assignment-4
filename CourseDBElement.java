package hw4_DataBasesCursesV2;

public class CourseDBElement implements Comparable {

	private String courseID;
	private int curseCRN;
	private int numberOfcredits;
	private String roomNumber;
	private String instructorName;


	public CourseDBElement() {
		this.courseID = "";
		this.curseCRN = 0;
		this.numberOfcredits = 0;
		this.roomNumber = "";
		this.instructorName = "";
	}//end default constructor

	public CourseDBElement(String courseID, int curseCRN, int numberOfcredits, String roomNumber,
			String instructorName) {
		super();
		this.courseID = courseID;
		this.curseCRN = curseCRN;
		this.numberOfcredits = numberOfcredits;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}


	/**Compare by curseCRN only*/
	@Override
	public int compareTo(CourseDBElement other)
	{
		if(Integer.compare(this.curseCRN,other.curseCRN)==0) {
			return 0;
		}
		else 
			return Integer.compare(this.curseCRN,other.curseCRN);
	}

	/**
	 * Get the curseCRN field
	 * @return curseCRN
	 */
	public int getCRN() {
		return curseCRN;
	}

	/**
	 * Converted curseCRN into a String
	 * @return curseCRN as String
	 */
	public String getStringCRN() {

		String stringCRN= Integer.toString(getCRN());
		return stringCRN;
	}

	/**
	 * get the hashCode of an String
	 */
	@Override
	public int hashCode() {
		String s= getStringCRN();
		int result= s.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "\nCourse:" + courseID + " CRN:" + curseCRN + " Credits:"
				+ numberOfcredits + " Instructor:" + instructorName+ " Room:" + roomNumber;
	}

	/**
	 * Set the curseCRN
	 * @param crn the parameter to be set as curseCRN
	 */
	public void setCRN(int crn) {
		this.curseCRN=	crn;
	}
	
	//	/* (non-Javadoc)
	//	 * @see java.lang.Object#equals(java.lang.Object)
	//	 */
	//	@Override
	//	public boolean equals(Object obj) {
	//		if (this == obj)
	//			return true;
	//		if (obj == null)
	//			return false;
	//		if (getClass() != obj.getClass())
	//			return false;
	//		CourseDBElement other = (CourseDBElement) obj;
	//		if (curseCRN != other.curseCRN)
	//			return false;
	//		return true;
	//	}

}
