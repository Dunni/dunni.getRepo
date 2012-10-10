package assignment4;

import java.util.ArrayList;


public class Course implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int courseNumber;
	private String courseName;
	private int capacity;
	private ArrayList <Integer> registeredStudents;
	
	public Course(int courseNumber, String courseName, int capacity) {
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.capacity = capacity;
		this.registeredStudents = new ArrayList<Integer>();
	}
						
	public String toString() {
		return "\nCourse Name: " + courseName + "\nCourse Number: " + courseNumber
				+ "\nCapacity: " + capacity + "\nNumber of Registered Students: " + registeredStudents.size()
				+ "\nRegistered Students: " + registeredStudents;
	}

	
	public Course(int courseNumber, String courseName, int capacity, ArrayList<Integer> registeredStudents) {
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.capacity = capacity;
		this.registeredStudents = registeredStudents;
	}
	
	public Course(Course c) {
		this.courseNumber = c.courseNumber;
		this.courseName = c.courseName;
		this.capacity = c.capacity;
		this.registeredStudents = c.registeredStudents;
	}
	
	public String[] toStringArray(){
		String [] temp = {"" +this.courseNumber, this.courseName, "" + this.capacity};
		return temp;
	}
	
	
	public void addStudent(Student student){
		this.registeredStudents.add(student.getId());
		}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public ArrayList<Integer> getRegisteredStudents() {
		return registeredStudents;
	}

	public void setRegisteredStudents(ArrayList<Integer> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}

}
