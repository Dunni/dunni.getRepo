package assignment4;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class HomePanel extends JPanel implements java.io.Serializable {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton btnCourses, btnStudents, btnRegister, btnSave;
	/**
	 * Create the panel.
	 */
	public HomePanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblWelcomeToCarleton = new JLabel("WELCOME TO Carleton University");
		springLayout.putConstraint(SpringLayout.NORTH, lblWelcomeToCarleton, 128, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblWelcomeToCarleton, -117, SpringLayout.EAST, this);
		add(lblWelcomeToCarleton);
		
		btnCourses = new JButton("Courses");
		springLayout.putConstraint(SpringLayout.WEST, btnCourses, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCourses, -54, SpringLayout.SOUTH, this);
		add(btnCourses);
		
		btnStudents = new JButton("Students");
		springLayout.putConstraint(SpringLayout.NORTH, btnStudents, 0, SpringLayout.NORTH, btnCourses);
		springLayout.putConstraint(SpringLayout.WEST, btnStudents, 6, SpringLayout.EAST, btnCourses);
		add(btnStudents);
		
		btnRegister= new JButton("Register");
		springLayout.putConstraint(SpringLayout.NORTH, btnRegister, 0, SpringLayout.NORTH, btnCourses);
		springLayout.putConstraint(SpringLayout.WEST, btnRegister, 22, SpringLayout.EAST, btnStudents);
		add(btnRegister);
		
		btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, 0, SpringLayout.NORTH, btnCourses);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 21, SpringLayout.EAST, btnRegister);
		add(btnSave);

	}
}
