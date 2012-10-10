package assignment4;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;


public class CoursePanel extends JPanel implements java.io.Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField courseNameField, courseNumberField, capacityField;
	 private JLabel lblCourseNumber, lblCourseName, lblCapacity;
	 private JButton btnAdd, btnRemove, btnBack, btnDisplay;
	 private JScrollPane courseScrollPane;
	 private JTable courseTable;
	DefaultTableModel courseTableModel;
	public JTextField getCourseNameField() {
		return courseNameField;
	}
	public void setCourseNameField(JTextField courseNameField) {
		this.courseNameField = courseNameField;
	}
	public JTextField getCourseNumberField() {
		return courseNumberField;
	}
	public void setCourseNumberField(JTextField courseNumberField) {
		this.courseNumberField = courseNumberField;
	}
	public JTextField getCapacityField() {
		return capacityField;
	}
	public void setCapacityField(JTextField capacityField) {
		this.capacityField = capacityField;
	}
	public JLabel getLblCourseNumber() {
		return lblCourseNumber;
	}
	public void setLblCourseNumber(JLabel lblCourseNumber) {
		this.lblCourseNumber = lblCourseNumber;
	}
	public JLabel getLblCourseName() {
		return lblCourseName;
	}
	public void setLblCourseName(JLabel lblCourseName) {
		this.lblCourseName = lblCourseName;
	}
	public JLabel getLblCapacity() {
		return lblCapacity;
	}
	public void setLblCapacity(JLabel lblCapacity) {
		this.lblCapacity = lblCapacity;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}
	public JButton getBtnRemove() {
		return btnRemove;
	}
	public void setBtnRemove(JButton btnRemove) {
		this.btnRemove = btnRemove;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
	public JButton getBtnDisplay() {
		return btnDisplay;
	}
	public void setBtnDisplay(JButton btnDisplay) {
		this.btnDisplay = btnDisplay;
	}
	public JScrollPane getCourseScrollPane() {
		return courseScrollPane;
	}
	public void setCourseScrollPane(JScrollPane courseScrollPane) {
		this.courseScrollPane = courseScrollPane;
	}
	public JTable getCourseTable() {
		return courseTable;
	}
	public void setCourseTable(JTable courseTable) {
		this.courseTable = courseTable;
	}
	public DefaultTableModel getCourseTableModel() {
		return courseTableModel;
	}
	public void setCourseTableModel(DefaultTableModel courseTableModel) {
		this.courseTableModel = courseTableModel;
	}
	/**
	 * Create the panel.
	 */
	public CoursePanel() {
		String [] s = {"Course Number", "Course Name", "Capacity"};
		courseTableModel = new DefaultTableModel(s, 0);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		  
		   
	
		                                                                                                                                                                                        
		lblCourseNumber = new JLabel("Course Number:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCourseNumber, 170, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCourseNumber, 10, SpringLayout.WEST, this);
		add(lblCourseNumber);
		
		courseNumberField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, courseNumberField, 198, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, courseNumberField, 4, SpringLayout.WEST, this);
		add(courseNumberField);
		courseNumberField.setColumns(10);
		
		lblCourseName = new JLabel("Course Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCourseName, 170, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCourseName, 150, SpringLayout.WEST, this);
		add(lblCourseName);
		
		courseNameField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, courseNameField, 198, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, courseNameField, 144, SpringLayout.WEST, this);
		add(courseNameField);
		courseNameField.setColumns(10);
		
		capacityField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, capacityField, 198, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, capacityField, 290, SpringLayout.WEST, this);
		add(capacityField);
		capacityField.setColumns(10);
		
		lblCapacity = new JLabel("Capacity");
		springLayout.putConstraint(SpringLayout.NORTH, lblCapacity, 170, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCapacity, 290, SpringLayout.WEST, this);
		add(lblCapacity);
		
		btnAdd = new JButton("Add");
		add(btnAdd);
		
		btnRemove = new JButton("Remove");
		springLayout.putConstraint(SpringLayout.NORTH, btnRemove, 12, SpringLayout.SOUTH, courseNameField);
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 0, SpringLayout.NORTH, btnRemove);
		add(btnRemove);
		
		btnBack = new JButton("Back");
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 12, SpringLayout.SOUTH, capacityField);
		springLayout.putConstraint(SpringLayout.EAST, btnRemove, -24, SpringLayout.WEST, btnBack);
		springLayout.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.EAST, capacityField);
		add(btnBack);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 150, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 450, SpringLayout.WEST, this);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		courseTable = new JTable(courseTableModel){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int colIndex) {
		        return false;   //Disallow the editing of any cell
		    }
		};
		courseTable.setColumnSelectionAllowed(false);
		
		courseScrollPane = new JScrollPane(courseTable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				courseTable.setVisible(true);
				courseTable.setBounds(0, 0, 200, 100);
		panel.add(courseScrollPane);
		
		btnDisplay = new JButton("Display");
		springLayout.putConstraint(SpringLayout.WEST, btnAdd, 16, SpringLayout.EAST, btnDisplay);
		springLayout.putConstraint(SpringLayout.NORTH, btnDisplay, 0, SpringLayout.NORTH, btnAdd);
		springLayout.putConstraint(SpringLayout.EAST, btnDisplay, 0, SpringLayout.EAST, lblCourseNumber);
		add(btnDisplay);
		
		

	}
}
