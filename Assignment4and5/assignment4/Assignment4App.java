package assignment4;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.thoughtworks.xstream.XStream;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Assignment4App extends JFrame implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane; //The pane that holds all the other panels
	HashMap<Integer, Course> courses = new HashMap<Integer, Course>(); //a list of all courses that are currently in the system
	HashMap<Integer, Student> students = new HashMap<Integer, Student>(); // a list of all students currently in the system
	StudentPanel studentPanel; 
	CoursePanel coursePanel;
	RegistrationPanel registrationPanel;
	HomePanel homePanel;
	int nextID;
	static final XStream xstream = new XStream(); // the Stream used to save and load TO XML using XML parsing
	
	public Assignment4App() { //constructor: Sets up the UI of my app by adding all the required panel and sets my layout to card layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		studentPanel = new StudentPanel();
		contentPane.add(studentPanel, "student");
		coursePanel = new CoursePanel();
		contentPane.add(coursePanel, "course");
		registrationPanel = new RegistrationPanel();
		contentPane.add(registrationPanel, "registration");
		homePanel = new HomePanel();
		contentPane.add(homePanel, "home");
		CardLayout temp = (CardLayout) (contentPane.getLayout());
		temp.show(homePanel.getParent(), "home");
		contentPane.setLayout(temp);
		this.nextID = 1;
	}

	public void saveState() { //Method which I use to save my program in its current state
		try {
			// Create file
			String xml = xstream.toXML(this); // converts my object to an XML stream
			File temp = new File("saved.txt"); // creates a new file object which references the "saved.txt" text file.
			if(temp.exists()) temp.delete();  // If the file already exists, deletes it to prevent repetition
			FileWriter fstream = new FileWriter("saved.txt"); // creates a file writer with which to write to the "saved.txt" file
															  // and also creates the "saved.txt' file
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(xml); //writes my object XML stream to the text file "saved.txt"
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // Main method
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Assignment4App temp; //creates a temporary frame
				try {
					File saved = new File("saved.txt"); //creates a new file object from the "saved.txt" file
					if(saved.exists()){ // if "saved.txt" already exists, reads the file into a string
					BufferedReader reader = new BufferedReader(new FileReader(
							saved));
					String line = null;
					StringBuilder stringBuilder = new StringBuilder();
					String ls = System.getProperty("line.separator");

					while ((line = reader.readLine()) != null) {//  reads text file line by line to a string builder
						stringBuilder.append(line);
						stringBuilder.append(ls);
					}
					   temp = (Assignment4App) xstream
												.fromXML(stringBuilder.toString()); // rebuilds my object from the string builder and assigns that
					   																// object to temp
					}
					else{  temp = new Assignment4App(); //If "saved.txt" doesn't exist, creates a completely new instance of my App and assigns it to temp
					}
					final Assignment4App frame = temp; //creates a final instance of my App called frame and assigns temp to frame.

					
					
					frame .homePanel.btnSave  
							.addActionListener(new ActionListener() { // handles the click of the save button. using a dialog box
								@Override
								public void actionPerformed(ActionEvent e) {

									if (JOptionPane
											.showConfirmDialog(
													null,
													"Are you sure you want to save all your changes?",
													"Save",
													JOptionPane.YES_NO_OPTION,
													JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
										frame.saveState(); // if you decide you want to save, calls the prgram's save method on your frame object

									} else {
										// Go back to normal
									}

								}
							});

					frame.homePanel.btnRegister
							.addActionListener(new ActionListener() { //switches to the registration panel
								@Override
								public void actionPerformed(ActionEvent e) {
									CardLayout temp = (CardLayout) (frame.contentPane
											.getLayout());
									temp.show(frame.contentPane,
											"registration");
									frame.contentPane.setLayout(temp);
								}
							});

					frame.homePanel.btnCourses
							.addActionListener(new ActionListener() { // switches to the course panel
								@Override
								public void actionPerformed(ActionEvent e) {
									CardLayout temp = (CardLayout) (frame.contentPane
											.getLayout());
									temp.show(frame.contentPane,
											"course");
									frame.contentPane.setLayout(temp);
								}
							});

					frame.homePanel.btnStudents
							.addActionListener(new ActionListener() { //switches to the student panel
								@Override
								public void actionPerformed(ActionEvent e) {
									CardLayout temp = (CardLayout) (frame.contentPane
											.getLayout());
									temp.show(frame.contentPane,
											"student");
									frame.contentPane.setLayout(temp);
								}
							});

					frame.coursePanel.getBtnBack().addActionListener( //switches back to the home panel
							new ActionListener() { 
								@Override
								public void actionPerformed(ActionEvent e) {
								CardLayout temp = (CardLayout) (frame.contentPane.getLayout());
									temp.show(frame.contentPane,
											"home");
									frame.contentPane.setLayout(temp);
								}
							});

					frame.coursePanel.getBtnAdd().addActionListener(
							new ActionListener() { //adds a new course to my JTable and my courses Hash Map as long as a fields are validly filled
												   // user is notified of errors via dialog boxes.
								@Override
								public void actionPerformed(ActionEvent e) {

									try {
										String tempName = frame.coursePanel
												.getCourseNameField().getText();
										int tempNumber = Integer
												.parseInt(frame.coursePanel
														.getCourseNumberField()
														.getText());
										int tempCapacity = Integer
												.parseInt(frame.coursePanel
														.getCapacityField()
														.getText());
										Course tempCourse = new Course(
												tempNumber, tempName,
												tempCapacity);

										if (frame.courses
												.containsKey(tempNumber)) {
											JOptionPane
													.showMessageDialog(null,
															"A course with that number already exists");
										} else if (tempNumber > 9999
												|| tempNumber < 1000) {
											JOptionPane
													.showMessageDialog(null,
															"Course number out of valid range (1000 - 9999) ");
											frame.coursePanel
													.getCourseNumberField()
													.setText(null);
										} else if (tempName.length() > 50) {
											JOptionPane
													.showMessageDialog(null,
															"Course name too long.(50 Characters Max)");
											frame.coursePanel
													.getCourseNameField()
													.setText(null);
										} else {
											frame.courses.put(
													tempNumber, tempCourse);
											frame.coursePanel.courseTableModel
													.addRow(tempCourse
															.toStringArray());
											frame.coursePanel
													.getCourseNameField()
													.setText(null);
											frame.coursePanel
													.getCourseNumberField()
													.setText(null);
											frame.coursePanel
													.getCapacityField()
													.setText(null);
										}
									} catch (Exception f) {
										JOptionPane
												.showMessageDialog(
														null,
														"Please fill all fields with valid data. Course Number and Capacity must be Integers. No field may be left empty");

									}

								}
							});

					frame.coursePanel.getBtnRemove()
							.addActionListener(new ActionListener() {//removes a selected course from my JTable and my courses Hash Map
																	 // If no course is selected, requests that you select one.
								@Override
								public void actionPerformed(ActionEvent e) {

									try {
										int i = frame.coursePanel
												.getCourseTable()
												.getSelectedRow();

										frame.courses.remove(Integer
												.parseInt((String) frame.coursePanel.courseTableModel
														.getValueAt(i, 0)));
										frame.coursePanel.courseTableModel
												.removeRow(i);
									} catch (Exception f) {
										JOptionPane
										.showMessageDialog(
												null, "Please select a course to remove");
									}

								}
							});

					frame.coursePanel.getBtnDisplay()
							.addActionListener(new ActionListener() { // Displays a selected course's information
																	  // If no course is selected, requests that you select one.
								@Override
								public void actionPerformed(ActionEvent e) {

									try {
										int i = frame.coursePanel
												.getCourseTableModel()
												.findColumn("Course Number");
										int j = frame.coursePanel
												.getCourseTable()
												.getSelectedRow();
										int tempNumber = Integer
												.parseInt(frame.coursePanel
														.getCourseTableModel()
														.getValueAt(j, i)
														.toString());
										
										Course tempCourse = new Course(frame.courses.get(tempNumber)){
											/**
											 * 
											 */
											private static final long serialVersionUID = 1L;

											public String toString() {
												String s = new String();
												
												for(Student st: frame.students.values()){
													if(this.getRegisteredStudents().contains(st.getId()))
													s+= "\n " + st.getFirstName() + " " + st.getLastName();
												}
												if(s.isEmpty()) return "\nCourse Name: " + this.getCourseName() + "\nCourse Number: " + this.getCourseNumber()
													+ "\nCapacity: " + this.getCapacity() + "\nNumber of Registered Students: " + this.getRegisteredStudents().size()
													+ "\nRegistered Students: " + "(none)";
												else return "\nCourse Name: " + this.getCourseName() + "\nCourse Number: " + this.getCourseNumber()
														+ "\nCapacity: " + this.getCapacity() + "\nNumber of Registered Students: " + this.getRegisteredStudents().size()
														+ "\nRegistered Students: " + s;
											}
										
										};
										JOptionPane.showMessageDialog(
												null,
												tempCourse.toString());
									} catch (Exception f) {
										JOptionPane
										.showMessageDialog(
												null, "Please select a course to display");
									}

								}
							});

					frame.studentPanel.getBtnBack().addActionListener( //switches back to the home panel
							new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									CardLayout temp = (CardLayout) (frame.contentPane
											.getLayout());
									temp.show(frame.contentPane,
											"home");
									frame.contentPane.setLayout(temp);
								}
							});

					frame.studentPanel.getBtnEdit().addActionListener( // Enables user to edit a student's information by entering
																	   // the student number.
							new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {

									try {
										int i = frame.studentPanel
												.getStudentTableModel()
												.findColumn("Student ID");
										final int j = frame.studentPanel
												.getStudentTable()
												.getSelectedRow();
										final int tempID = Integer
												.parseInt(frame.studentPanel
														.getStudentTableModel()
														.getValueAt(j, i)
														.toString());
										Student tempStudent = new Student(frame.students.get(tempID));
										final StudentEditPanel dialog = new StudentEditPanel(tempStudent);
										dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
										dialog.setVisible(true);
										dialog.setResizable(false);
										dialog.getOkButton().addActionListener(
												
												new ActionListener(){
													public void actionPerformed(ActionEvent x){
														Student tempStudent = new Student(frame.students.get(dialog.getStudentNumber()));
														tempStudent.setFirstName(dialog.getTxtFirstname().getText());
														tempStudent.setLastName(dialog.getTxtLastname().getText());
														tempStudent.setBirthYear(Integer.parseInt((dialog.getTxtBirthyear().getText())));
														tempStudent.setStartingYear(Integer.parseInt((dialog.getTxtStartingyear().getText())));
													
														frame.studentPanel.getStudentTableModel().removeRow(j);
														frame.studentPanel.getStudentTableModel().addRow(tempStudent.toStringArray());
														frame.students.put(tempStudent.getId(), tempStudent);
														dialog.dispose();
													}
												}
												
												);
									} catch (Exception f) {
										JOptionPane
										.showMessageDialog(
												null, "Please select a student to edit");
									}

								}
							});

					frame.studentPanel.getBtnAdd().addActionListener( //adds a new student to my JTable and my students Hash Map as long as a fields are validly filled
																	 // user is notified of errors via dialog boxes.
							new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {

									try {
										String tempFirst = frame.studentPanel
												.getTxtFirstName().getText();
										String tempLast = frame.studentPanel
												.getTxtLastName().getText();
										int tempStart = Integer
												.parseInt(frame.studentPanel
														.getTxtStartingYear()
														.getText());
										int tempBirth = Integer
												.parseInt(frame.studentPanel
														.getTxtBirthYear()
														.getText());
										Student tempStudent = new Student(
												tempFirst, tempLast, tempBirth,
												tempStart, frame.nextID);

										frame.studentPanel
												.getTxtFirstName()
												.setText(null);
										frame.studentPanel
												.getTxtLastName().setText(null);
										frame.studentPanel
												.getTxtStartingYear().setText(
														null);
										frame.studentPanel
												.getTxtBirthYear()
												.setText(null);

										frame.students.put(frame.nextID,
												tempStudent);
										frame.studentPanel
												.getStudentTableModel()
												.addRow(tempStudent
														.toStringArray());
										frame.nextID++;

									} catch (Exception f) {
										JOptionPane
												.showMessageDialog(null,
														"Please fill all fields with valid data.");

									}

								}
							});

					frame.studentPanel.getBtnRemove()
							.addActionListener(new ActionListener() { // Removes a selected student from the JTable and students Hash Map
																	 // If no student is selected, requests that you select one.
								@Override
								public void actionPerformed(ActionEvent e) {

									try {
										int i = frame.studentPanel
												.getStudentTable()
												.getSelectedRow();

										frame.students.remove(i);
										frame.studentPanel
												.getStudentTableModel()
												.removeRow(i);
									} catch (Exception f) {
										JOptionPane
										.showMessageDialog(
												null, "Please select a student to remove");

								
									}

								}
							});

					frame.studentPanel.getBtnDisplay()
							.addActionListener(new ActionListener() { // Displays a selected student's information
																	 // If no student is selected, requests that you select one.
								@Override
								public void actionPerformed(ActionEvent e) {

									try {
										int i = frame.studentPanel
												.getStudentTableModel()
												.findColumn("Student ID");
										int j = frame.studentPanel
												.getStudentTable()
												.getSelectedRow();
										final int tempID = Integer
												.parseInt(frame.studentPanel
														.getStudentTableModel()
														.getValueAt(j, i)
														.toString());
										Student tempStudent = new Student(frame.students.get(tempID)){
											/**
											 * 
											 */
											private static final long serialVersionUID = 1L;

											public String toString(){
												String s = new String();
												
												for(Course c: frame.courses.values()){
													if(this.getCoursesTaking().contains(c.getCourseNumber()))
													s+= "\n " + c.getCourseName() + ":" + c.getCourseNumber();
												};
												if(s.isEmpty()) return "\nFirst Name: " + this.getFirstName() + " \nLast Name: " + this.getLastName()
														+ "\nBirth Year: " + this.getBirthYear() + "\nStarting Year: " + this.getStartingYear()
														+ "\nCourses Taking: " + "(none)";
												else return "\nFirst Name: " + this.getFirstName() + " \nLast Name: " + this.getLastName()
														+ "\nBirth Year: " + this.getBirthYear() + "\nStarting Year: " + this.getStartingYear()
														+ "\nCourses Taking: " + s;
											};
										};											
											
										
										JOptionPane.showMessageDialog(
												null,
												tempStudent.toString());
									} catch (Exception f) {
										JOptionPane
										.showMessageDialog(
												null, "Please select a student to display");
									}

								}
							});
					
					

					frame.registrationPanel.getBtnBack()
							.addActionListener(new ActionListener() { // returns to the home panel
								@Override
								public void actionPerformed(ActionEvent e) {
									CardLayout temp = (CardLayout) (frame.contentPane
											.getLayout());
									temp.show(frame.contentPane,
											"home");
									frame.contentPane.setLayout(temp);
								}
							});

					frame.registrationPanel.getBtnRegister()
							.addActionListener(new ActionListener() { // registers a student, identified by a unique number in a course also identified by a unique number
																	  // notifies user of various possible errors with dialog boxes
								@Override
								public void actionPerformed(ActionEvent e) {
									try {
										int tempCourseNumber = Integer
												.parseInt(frame.registrationPanel
														.getTxtCourseNumber()
														.getText()); //gets unique course number
										int tempStudentID = Integer
												.parseInt(frame.registrationPanel
														.getTxtStudentNumber()
														.getText()); // gets unique student number
										if (frame.courses
												.containsKey(tempCourseNumber)) { // if a course with that course number exists
											if (frame.students
													.containsKey(tempStudentID)) { // and a student with that student number also exists
												if (frame.courses.get(
														tempCourseNumber)
														.getCapacity() > frame.courses
														.get(tempCourseNumber)
														.getRegisteredStudents()
														.size()) { // and the course isn't full
													if(!(frame.courses.get(
															tempCourseNumber)
															.getRegisteredStudents()
															.contains(tempStudentID))){ // And the student Isn't already registered in the course
														
													frame.courses
															.get(tempCourseNumber)
															.addStudent(
																	frame.students
																			.get(tempStudentID)); // add the student to that course
													frame.students
															.get(tempStudentID)
															.addCourse(
																	frame.courses
																			.get(tempCourseNumber)); // add the course to that student
													frame.registrationPanel
															.getTxtCourseNumber()
															.setText(null);
													frame.registrationPanel
															.getTxtStudentNumber()
															.setText(null);
													JOptionPane
															.showMessageDialog(
																	null,
																	"Registration Successful!");
													}else JOptionPane
													.showMessageDialog(
															null,
															"That student is already registered in this course");
												} else
													JOptionPane
															.showMessageDialog(
																	null,
																	"This Course is full.");
											} else
												JOptionPane
														.showMessageDialog(
																null,
																"This Student does not exist.");
										} else
											JOptionPane
													.showMessageDialog(null,
															"This Course does not exist.");

									} catch (Exception f) {
										JOptionPane
												.showMessageDialog(null,
														"Please fill all fields with valid data.");
									}
								}

							});
					
//					frame.studentEditDialog.getOkButton().addActionListener(new ActionListener() {
//						public void actionPerformed(ActionEvent e) {
//							Student tempStudent = new Student(frame.students.get(frame.studentEditDialog.getStudentNumber()));
//							tempStudent.setFirstName(frame.studentEditDialog.getTxtFirstname().getText());
//							tempStudent.setLastName(frame.studentEditDialog.getTxtLastname().getText());
//							tempStudent.setBirthYear(Integer.parseInt((frame.studentEditDialog.getTxtBirthyear().getText())));
//							tempStudent.setStartingYear(Integer.parseInt((frame.studentEditDialog.getTxtStartingyear().getText())));
//							
//							int i = frame.studentPanel
//									.getStudentTableModel()
//									.findColumn("Student ID");
//							for(int j = 0; j<frame.studentPanel.getStudentTableModel())
//							frame.students.remove(i);
//							frame.studentPanel
//									.getStudentTableModel()
//									.removeRow(i);
//							}
//					});
					
					
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
