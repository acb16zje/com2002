package COM2002;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class EditPatient extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private enum Title {MR,MRS,MS};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPatient frame = new EditPatient();
					frame.setModal(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditPatient() {
		setTitle("Patient Editor");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("Title:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JComboBox comboBox = new JComboBox(Title.values());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel label_1 = new JLabel("Forename:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		
		JLabel label_2 = new JLabel("Surname:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		
		JLabel label_3 = new JLabel("Date Of Birth:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 3;
		panel.add(label_3, gbc_label_3);
		
		//reminder that month works as 0-11(JAN,FEB,...,DEC)
		JSpinner year = new JSpinner();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		year.setModel(new SpinnerNumberModel(currentYear, 1920, currentYear, 1));
		GridBagConstraints gbc_year = new GridBagConstraints();
		gbc_year.fill = GridBagConstraints.HORIZONTAL;
		gbc_year.insets = new Insets(0, 0, 5, 5);
		gbc_year.gridx = 4;
		gbc_year.gridy = 3;
		panel.add(year, gbc_year);
		
		JSpinner month = new JSpinner();
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		month.setModel(new SpinnerNumberModel(currentMonth+1,1,12,1));
		GridBagConstraints gbc_month = new GridBagConstraints();
		gbc_month.fill = GridBagConstraints.HORIZONTAL;
		gbc_month.insets = new Insets(0, 0, 5, 5);
		gbc_month.gridx = 3;
		gbc_month.gridy = 3;
		panel.add(month, gbc_month);
		
		JSpinner day = new JSpinner();
		Calendar daycal = new GregorianCalendar(currentYear, currentMonth, 1);
		int daysInMonth = daycal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int currentDay = Calendar.getInstance().get(Calendar.DATE);
		day.setModel(new SpinnerNumberModel(currentDay,1,daysInMonth,1));
		GridBagConstraints gbc_day = new GridBagConstraints();
		gbc_day.fill = GridBagConstraints.HORIZONTAL;
		gbc_day.insets = new Insets(0, 0, 5, 5);
		gbc_day.gridx = 2;
		gbc_day.gridy = 3;
		panel.add(day, gbc_day);
		
		//Listeners for dates
		month.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int newMonth = (int) month.getValue();
				Calendar cal = new GregorianCalendar(currentYear, newMonth-1, 1);
				int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				day.setModel(new SpinnerNumberModel(currentDay,1,daysInMonth,1));
			}
		});
		year.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int newYear = (int) year.getValue();
				Calendar cal = new GregorianCalendar(newYear, (int)month.getValue()-1, 1);
				int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				day.setModel(new SpinnerNumberModel(currentDay,1,daysInMonth,1));
			}
		});
		
		JLabel label_4 = new JLabel("Phone No:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 5;
		panel.add(label_4, gbc_label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(13);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		panel.add(textField_2, gbc_textField_2);
		
		JLabel lblHealthPlan = new JLabel("Healthcare Plan:");
		GridBagConstraints gbc_lblHealthPlan = new GridBagConstraints();
		gbc_lblHealthPlan.anchor = GridBagConstraints.EAST;
		gbc_lblHealthPlan.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealthPlan.gridx = 3;
		gbc_lblHealthPlan.gridy = 5;
		panel.add(lblHealthPlan, gbc_lblHealthPlan);
		
		JComboBox comboBox_4 = new JComboBox();
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_4.gridx = 4;
		gbc_comboBox_4.gridy = 5;
		panel.add(comboBox_4, gbc_comboBox_4);
		
		JCheckBox chckbxUpdateHealthcarePlan = new JCheckBox("Update Healthcare Plan");
		chckbxUpdateHealthcarePlan.setForeground(new Color(128, 128, 128));
		GridBagConstraints gbc_chckbxUpdateHealthcarePlan = new GridBagConstraints();
		gbc_chckbxUpdateHealthcarePlan.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxUpdateHealthcarePlan.gridx = 4;
		gbc_chckbxUpdateHealthcarePlan.gridy = 6;
		panel.add(chckbxUpdateHealthcarePlan, gbc_chckbxUpdateHealthcarePlan);
		
		JLabel label_5 = new JLabel("House No:");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 7;
		panel.add(label_5, gbc_label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(20);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 7;
		panel.add(textField_3, gbc_textField_3);
		
		JLabel label_6 = new JLabel("Street:");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 8;
		panel.add(label_6, gbc_label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(20);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 8;
		panel.add(textField_4, gbc_textField_4);
		
		JLabel label_7 = new JLabel("District:");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 9;
		panel.add(label_7, gbc_label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(20);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 9;
		panel.add(textField_5, gbc_textField_5);
		
		JLabel label_8 = new JLabel("City:");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 1;
		gbc_label_8.gridy = 10;
		panel.add(label_8, gbc_label_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(20);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 10;
		panel.add(textField_6, gbc_textField_6);
		
		JLabel label_9 = new JLabel("Postcode:");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 1;
		gbc_label_9.gridy = 11;
		panel.add(label_9, gbc_label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(20);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.insets = new Insets(0, 0, 0, 5);
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 11;
		panel.add(textField_7, gbc_textField_7);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(doneButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(cancelButton);
	}

}
