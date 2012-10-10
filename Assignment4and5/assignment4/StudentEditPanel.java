package assignment4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentEditPanel extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtBirthyear;
	private JTextField txtStartingyear;
	private JButton okButton;
	private int studentNumber;

	/**
	 * Create the dialog.
	 * @param snumber 
	 */
	public StudentEditPanel(Student student) {
		String fname = student.getFirstName();
		String lname = student.getLastName();
		String byear = "" + student.getBirthYear();
		String syear = "" + student.getStartingYear();
		int snumber = student.getId();
		this.studentNumber = snumber;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);

		JLabel lblEditStudentInformation = new JLabel(
				"Edit Student Information");
		sl_contentPanel
				.putConstraint(SpringLayout.NORTH, lblEditStudentInformation,
						10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel
				.putConstraint(SpringLayout.WEST, lblEditStudentInformation,
						142, SpringLayout.WEST, contentPanel);
		contentPanel.add(lblEditStudentInformation);

		JLabel lblFirstName = new JLabel("First Name:");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblFirstName, 26,
				SpringLayout.SOUTH, lblEditStudentInformation);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblFirstName, 87,
				SpringLayout.WEST, contentPanel);
		contentPanel.add(lblFirstName);

		JLabel lblLastname = new JLabel("Last Name:");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblLastname, 0,
				SpringLayout.WEST, lblFirstName);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblLastname, -127,
				SpringLayout.SOUTH, contentPanel);
		contentPanel.add(lblLastname);

		JLabel lblBirthYear = new JLabel("Birth Year:");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblBirthYear, 0,
				SpringLayout.WEST, lblFirstName);
		contentPanel.add(lblBirthYear);

		JLabel lblStartingYear = new JLabel("Starting Year:");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblStartingYear, 159,
				SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblBirthYear, -19,
				SpringLayout.NORTH, lblStartingYear);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblStartingYear, 0,
				SpringLayout.WEST, lblFirstName);
		contentPanel.add(lblStartingYear);

		txtFirstname = new JTextField(fname);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtFirstname, 25,
				SpringLayout.SOUTH, lblEditStudentInformation);
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtFirstname, 32,
				SpringLayout.EAST, lblFirstName);
		contentPanel.add(txtFirstname);
		txtFirstname.setColumns(10);

		txtLastname = new JTextField(lname);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtLastname, 0,
				SpringLayout.NORTH, lblLastname);
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtLastname, 0,
				SpringLayout.WEST, txtFirstname);
		contentPanel.add(txtLastname);
		txtLastname.setColumns(10);

		txtBirthyear = new JTextField(byear);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtBirthyear, 0,
				SpringLayout.NORTH, lblBirthYear);
		sl_contentPanel.putConstraint(SpringLayout.EAST, txtBirthyear, 0,
				SpringLayout.EAST, txtFirstname);
		contentPanel.add(txtBirthyear);
		txtBirthyear.setColumns(10);

		txtStartingyear = new JTextField(syear);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtStartingyear, 0,
				SpringLayout.NORTH, lblStartingYear);
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtStartingyear, 0,
				SpringLayout.WEST, txtFirstname);
		contentPanel.add(txtStartingyear);
		txtStartingyear.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		okButton = new JButton("OK");
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JTextField getTxtFirstname() {
		return txtFirstname;
	}

	public void setTxtFirstname(JTextField txtFirstname) {
		this.txtFirstname = txtFirstname;
	}

	public JTextField getTxtLastname() {
		return txtLastname;
	}

	public void setTxtLastname(JTextField txtLastname) {
		this.txtLastname = txtLastname;
	}

	public JTextField getTxtBirthyear() {
		return txtBirthyear;
	}

	public void setTxtBirthyear(JTextField txtBirthyear) {
		this.txtBirthyear = txtBirthyear;
	}

	public JTextField getTxtStartingyear() {
		return txtStartingyear;
	}

	public void setTxtStartingyear(JTextField txtStartingyear) {
		this.txtStartingyear = txtStartingyear;
	}

}
