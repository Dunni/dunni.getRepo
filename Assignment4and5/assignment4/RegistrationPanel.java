package assignment4;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class RegistrationPanel extends JPanel implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtStudentNumber;
	private JTextField txtCourseNumber;
	private JButton btnBack, btnRegister;
	private JLabel lblStudentNumber, lblCourseNumber;
	
	
	public JTextField getTxtStudentNumber() {
		return txtStudentNumber;
	}
	
	
	public void setTxtStudentNumber(JTextField txtStudentNumber) {
		this.txtStudentNumber = txtStudentNumber;
	}
	
	
	public JTextField getTxtCourseNumber() {
		return txtCourseNumber;
	}
	
	
	public void setTxtCourseNumber(JTextField txtCourseNumber) {
		this.txtCourseNumber = txtCourseNumber;
	}
	
	
	public JButton getBtnBack() {
		return btnBack;
	}
	
	
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
	
	
	public JButton getBtnRegister() {
		return btnRegister;
	}
	
	
	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}
	
	
	public JLabel getLblStudentNumber() {
		return lblStudentNumber;
	}
	
	
	public void setLblStudentNumber(JLabel lblStudentNumber) {
		this.lblStudentNumber = lblStudentNumber;
	}
	
	
	public JLabel getLblCourseNumber() {
		return lblCourseNumber;
	}
	
	
	public void setLblCourseNumber(JLabel lblCourseNumber) {
		this.lblCourseNumber = lblCourseNumber;
	}
	
	
	/**
	 * Create the panel.
	 */
	public RegistrationPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		btnBack = new JButton("Back");
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 223, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 357, SpringLayout.WEST, this);
		add(btnBack);
		
		btnRegister = new JButton("Register");
		springLayout.putConstraint(SpringLayout.NORTH, btnRegister, 223, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnRegister, 264, SpringLayout.WEST, this);
		add(btnRegister);
		
		txtStudentNumber = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtStudentNumber, 149, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtStudentNumber, 213, SpringLayout.WEST, this);
		add(txtStudentNumber);
		txtStudentNumber.setColumns(10);
		
		txtCourseNumber = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtCourseNumber, 99, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtCourseNumber, 213, SpringLayout.WEST, this);
		add(txtCourseNumber);
		txtCourseNumber.setColumns(10);
		
		lblStudentNumber = new JLabel("Student Number:");
		springLayout.putConstraint(SpringLayout.NORTH, lblStudentNumber, 155, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblStudentNumber, 75, SpringLayout.WEST, this);
		add(lblStudentNumber);
		
		lblCourseNumber = new JLabel("Course Number:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCourseNumber, 105, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCourseNumber, 79, SpringLayout.WEST, this);
		add(lblCourseNumber);

	}

}
