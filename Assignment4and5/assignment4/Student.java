package assignment4;

import java.util.ArrayList;


public class Student implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private int birthYear;
	private int startingYear;
	private int id;
	private ArrayList<Integer> coursesTaking;

	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getBirthYear() {
		return birthYear;
	}


	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}


	public int getStartingYear() {
		return startingYear;
	}


	public void setStartingYear(int startingYear) {
		this.startingYear = startingYear;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<Integer> getCoursesTaking() {
		return coursesTaking;
	}


	public void setCoursesTaking(ArrayList<Integer> coursesTaking) {
		this.coursesTaking = coursesTaking;
	}


	public String[] toStringArray(){
		String [] temp = {this.firstName, this.lastName, "" + this.birthYear, "" + this.startingYear, "" + this.id};
		return temp;
	}


	public Student(String firstName, String lastName, int birthYear,
			int startingYear, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.startingYear = startingYear;
		this.id = id;
		this.coursesTaking = new ArrayList<Integer>();
	}

	public Student(Student s){
		this.firstName = s.firstName;
		this.lastName = s.lastName;
		this.birthYear = s.birthYear;
		this.startingYear = s.startingYear;
		this.id = s.id;
		this.coursesTaking = s.coursesTaking;
		
	}
	public void addCourse(Course course){
		this.coursesTaking.add(course.getCourseNumber());
		}

	public String toString() {
		return "\nFirst Name: " + firstName + " \nLast Name: " + lastName
				+ "\nBirth Year: " + birthYear + "\nStarting Year: " + startingYear
				+ "\nCourses Taking: " + coursesTaking;
	}

}
