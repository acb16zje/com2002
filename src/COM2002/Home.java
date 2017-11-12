package COM2002;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints; 
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JScrollPane;

public class Home extends JFrame {
	
	JFrame frame;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel Appointment;
	private JPanel Patient;
	private JPanel healthcarePlan;
	private JButton btnNewButton;
	private JRadioButton Dentist;
	private JRadioButton Hygienist;
	private JTable appointmentTable;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JPanel tableControlPanel;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel appointmentPanel;
	private JPanel searchPatientPanel;
	private JPanel patientPanel;
	private JTextField patientID;
	private JButton searchPatientButton;
	private JLabel lblPatientId;
	private JButton addPatientButton;
	private JPanel patientEditPanel;
	private JButton editPatientButton;
	private JButton deletePatientButton;
	private JTable patientTable;
	private JPanel planPanel;
	private JButton btnCreateNewPlan;
	private JPanel searchPlanPanel;
	private JLabel healthCarePlan;
	private JTextField searchBox;
	private JButton searchPlan;
	private JTable planTable;
	private JPanel planEditPanel;
	private JButton removePlan;
	private JButton editPlan;
	private JButton btnViewPatientPlan;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Sheffield Dentistry Management Program");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		//UI for appointment
		Appointment = new JPanel();
		
		tabbedPane.addTab("Appointment\r\n", null, Appointment, null);
		
		ButtonGroup partnerGroup = new ButtonGroup();
		Appointment.setLayout(new BorderLayout(0, 0));
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		Calendar daycal = new GregorianCalendar(currentYear, currentMonth, 1);
		int daysInMonth = daycal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int currentDay = Calendar.getInstance().get(Calendar.DATE);
		
		tableControlPanel = new JPanel();
		Appointment.add(tableControlPanel, BorderLayout.NORTH);
		tableControlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Hygienist = new JRadioButton("Hygienist");
		tableControlPanel.add(Hygienist);
		
		Dentist = new JRadioButton("Dentist");
		tableControlPanel.add(Dentist);
		partnerGroup.add(Hygienist);
		partnerGroup.add(Dentist);
		Hygienist.setSelected(true);
		
		//reminder that month works as 0-11(JAN,FEB,...,DEC)
		JSpinner year = new JSpinner();
		year.setModel(new SpinnerNumberModel(currentYear, 1920, currentYear, 1));
		
		JSpinner month = new JSpinner();
		month.setModel(new SpinnerNumberModel(currentMonth+1,1,12,1));
		
		JSpinner day = new JSpinner();
		day.setModel(new SpinnerNumberModel(currentDay,1,daysInMonth,1));
		tableControlPanel.add(day);
		tableControlPanel.add(month);
		tableControlPanel.add(year);
		
		appointmentTable = new JTable();
		Appointment.add(appointmentTable, BorderLayout.CENTER);
		appointmentTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		
		appointmentPanel = new JPanel();
		Appointment.add(appointmentPanel, BorderLayout.EAST);
		appointmentPanel.setLayout(new BoxLayout(appointmentPanel, BoxLayout.Y_AXIS));
		
		btnNewButton = new JButton("Create new Appointment");
		btnNewButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		appointmentPanel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Find Appointment");
		appointmentPanel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_2 = new JButton("Delete Appointment");
		appointmentPanel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
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
		
		//UI for patient
		Patient = new JPanel();
		tabbedPane.addTab("Patient", null, Patient, null);
		Patient.setLayout(new BorderLayout(0, 0));
		
		searchPatientPanel = new JPanel();
		Patient.add(searchPatientPanel, BorderLayout.NORTH);
		
		lblPatientId = new JLabel("Patient ID:");
		searchPatientPanel.add(lblPatientId);
		
		patientID = new JTextField();
		searchPatientPanel.add(patientID);
		patientID.setColumns(20);
		
		searchPatientButton = new JButton("Search");
		searchPatientPanel.add(searchPatientButton);
		
		patientEditPanel = new JPanel();
		Patient.add(patientEditPanel, BorderLayout.SOUTH);
		FlowLayout fl_patientEditPanel = (FlowLayout) patientEditPanel.getLayout();
		fl_patientEditPanel.setAlignment(FlowLayout.LEADING);
		fl_patientEditPanel.setAlignOnBaseline(true);
		
		btnViewPatientPlan = new JButton("View Healthcare Plan");
		patientEditPanel.add(btnViewPatientPlan);
		
		editPatientButton = new JButton("Edit");
		editPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPatient.main(null);
			}
		});
		patientEditPanel.add(editPatientButton);
		
		deletePatientButton = new JButton("Delete");
		deletePatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(deletePatientButton,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){ 
					//insert delete patient sql stuff here
				 }  
			}
		});
		patientEditPanel.add(deletePatientButton);
		
		patientPanel = new JPanel();
		Patient.add(patientPanel, BorderLayout.EAST);
		
		addPatientButton = new JButton("Add Patient");
		addPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPatient.main(null);
			}
		});
		patientPanel.add(addPatientButton);
		
		patientTable = new JTable();
		Patient.add(new JScrollPane(patientTable), BorderLayout.CENTER);
		patientTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"P0000", "Blank", null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Patient ID", "Name", "Date Of Birth", "Phone No", "Adress", "Healthcare Plan"
			}
		));
		patientTable.setFillsViewportHeight(true);
		
		//UI for healthcare plan tab
		healthcarePlan = new JPanel();
		tabbedPane.addTab("Healthcare Plan", null, healthcarePlan, null);
		healthcarePlan.setLayout(new BorderLayout(0, 0));
		
		planPanel = new JPanel();
		healthcarePlan.add(planPanel, BorderLayout.EAST);
		planPanel.setLayout(new BoxLayout(planPanel, BoxLayout.Y_AXIS));
		
		btnCreateNewPlan = new JButton("Create New Plan");
		btnCreateNewPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HealthcarePlanEditor.main(null);
				}
		});
		planPanel.add(btnCreateNewPlan);
		
		searchPlanPanel = new JPanel();
		healthcarePlan.add(searchPlanPanel, BorderLayout.NORTH);
		
		healthCarePlan = new JLabel("Plan ID:");
		searchPlanPanel.add(healthCarePlan);
		
		searchBox = new JTextField();
		searchBox.setColumns(20);
		searchPlanPanel.add(searchBox);
		
		searchPlan = new JButton("Search");
		searchPlanPanel.add(searchPlan);
		
		planTable = new JTable();
		healthcarePlan.add(planTable, BorderLayout.CENTER);
		
		planEditPanel = new JPanel();
		FlowLayout fl_planEditPanel = (FlowLayout) planEditPanel.getLayout();
		fl_planEditPanel.setAlignment(FlowLayout.LEFT);
		fl_planEditPanel.setAlignOnBaseline(true);
		healthcarePlan.add(planEditPanel, BorderLayout.SOUTH);
		
		removePlan = new JButton("Remove Healthcare Plan");
		removePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){ 
					//insert delete plan sql stuff here
				 }  
			}
		});
		
		editPlan = new JButton("Edit Healthcare Plan");
		editPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HealthcarePlanEditor.main(null);
				}
		});
		planEditPanel.add(editPlan);
		planEditPanel.add(removePlan);
	}
}
