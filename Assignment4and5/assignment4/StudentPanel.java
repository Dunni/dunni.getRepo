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




public class StudentPanel extends JPanel implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAdd, btnRemove, btnBack, btnDisplay,btnEdit;
	private JScrollPane studentScrollPane;
	private JTable studentTable;
	private DefaultTableModel studentTableModel;
	private JTextField txtFirstName, txtLastName, txtStartingYear, txtBirthYear;
	private JLabel lblBirthYear, lblStartingYear;
	/**
	 * Create the panel.
	 */
	public JButton getBtnEdit() {
		return btnEdit;
	}


	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}


	public JButton getBtnDisplay() {
		return btnDisplay;
	}

	
	public void setBtnDisplay(JButton btnDisplay) {
		this.btnDisplay = btnDisplay;
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
	
	public JScrollPane getStudentScrollPane() {
		return studentScrollPane;
	}
	
	public void setStudentScrollPane(JScrollPane studentScrollPane) {
		this.studentScrollPane = studentScrollPane;
	}
	
	public JTable getStudentTable() {
		return studentTable;
	}
	
	public void setStudentTable(JTable studentTable) {
		this.studentTable = studentTable;
	}
	
	public DefaultTableModel getStudentTableModel() {
		return studentTableModel;
	}
	
	public void setStudentTableModel(DefaultTableModel studentTableModel) {
		this.studentTableModel = studentTableModel;
	}
	
	public JTextField getTxtFirstName() {
		return txtFirstName;
	}
	
	public void setTxtFirstName(JTextField txtFirstName) {
		this.txtFirstName = txtFirstName;
	}
	
	public JTextField getTxtLastName() {
		return txtLastName;
	}
	
	public void setTxtLastName(JTextField txtLastName) {
		this.txtLastName = txtLastName;
	}
	
	public JTextField getTxtStartingYear() {
		return txtStartingYear;
	}
	
	public void setTxtStartingYear(JTextField txtStartingYear) {
		this.txtStartingYear = txtStartingYear;
	}
	
	public JTextField getTxtBirthYear() {
		return txtBirthYear;
	}
	
	public void setTxtBirthYear(JTextField txtBirthYear) {
		this.txtBirthYear = txtBirthYear;
	}
	
	public JLabel getLblBirthYear() {
		return lblBirthYear;
	}
	
	public void setLblBirthYear(JLabel lblBirthYear) {
		this.lblBirthYear = lblBirthYear;
	}
	
	public JLabel getLblStartingYear() {
		return lblStartingYear;
	}
	
	public void setLblStartingYear(JLabel lblStartingYear) {
		this.lblStartingYear = lblStartingYear;
	}
	
	
	public StudentPanel() {
		String [] s = {"First Name", "Last Name", "Birth Year", "Starting Year", "Student ID"};
		studentTableModel = new DefaultTableModel(s, 0);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		btnAdd = new JButton("Add");
		add(btnAdd);

		
		btnRemove = new JButton("Remove");
		springLayout.putConstraint(SpringLayout.WEST, btnRemove, 257, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, -6, SpringLayout.WEST, btnRemove);
		springLayout.putConstraint(SpringLayout.NORTH, btnRemove, 0, SpringLayout.NORTH, btnAdd);
		add(btnRemove);
		
		btnBack = new JButton("Back");
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, btnAdd);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 6, SpringLayout.EAST, btnRemove);
		add(btnBack);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 164, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 451, SpringLayout.WEST, this);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		studentTable = new JTable(studentTableModel){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int colIndex) {
		        return false;   //Disallow the editing of any cell
		    }
		};

		studentTable.setColumnSelectionAllowed(false);
		
		studentScrollPane = new JScrollPane(studentTable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				studentTable.setVisible(true);
				studentTable.setBounds(0, 0, 200, 100);
		panel.add(studentScrollPane);
		
		btnDisplay = new JButton("Display");
		springLayout.putConstraint(SpringLayout.EAST, btnDisplay, -7, SpringLayout.WEST, btnAdd);
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 0, SpringLayout.NORTH, btnDisplay);
		add(btnDisplay);
		
		JLabel lblFirstName = new JLabel("First Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 10, SpringLayout.WEST, panel);
		add(lblFirstName);
		
		txtFirstName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtFirstName, 6, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, txtFirstName, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.EAST, txtFirstName, 125, SpringLayout.WEST, this);
		add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 49, SpringLayout.EAST, lblFirstName);
		add(lblLastName);
		
		txtLastName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtLastName, 0, SpringLayout.NORTH, txtFirstName);
		springLayout.putConstraint(SpringLayout.WEST, txtLastName, 6, SpringLayout.EAST, txtFirstName);
		add(txtLastName);
		txtLastName.setColumns(10);
		
		lblBirthYear = new JLabel("Birth Year");
		springLayout.putConstraint(SpringLayout.NORTH, lblBirthYear, 0, SpringLayout.NORTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblBirthYear, 66, SpringLayout.EAST, lblLastName);
		add(lblBirthYear);
		
		txtBirthYear = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtBirthYear, 266, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtLastName, -6, SpringLayout.WEST, txtBirthYear);
		springLayout.putConstraint(SpringLayout.NORTH, txtBirthYear, 0, SpringLayout.NORTH, txtFirstName);
		add(txtBirthYear);
		txtBirthYear.setColumns(10);
		
		lblStartingYear = new JLabel("Starting Year:");
		springLayout.putConstraint(SpringLayout.NORTH, lblStartingYear, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, lblStartingYear, -9, SpringLayout.EAST, this);
		add(lblStartingYear);
		
		txtStartingYear = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtBirthYear, -8, SpringLayout.WEST, txtStartingYear);
		springLayout.putConstraint(SpringLayout.NORTH, txtStartingYear, 0, SpringLayout.NORTH, txtFirstName);
		springLayout.putConstraint(SpringLayout.WEST, txtStartingYear, 349, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtStartingYear, 451, SpringLayout.WEST, this);
		add(txtStartingYear);
		txtStartingYear.setColumns(10);
		
		btnEdit = new JButton("Edit");
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, -6, SpringLayout.WEST, btnDisplay);
		springLayout.putConstraint(SpringLayout.NORTH, btnDisplay, 0, SpringLayout.NORTH, btnEdit);
		springLayout.putConstraint(SpringLayout.SOUTH, btnEdit, -10, SpringLayout.SOUTH, this);
		add(btnEdit);

}


	
}
