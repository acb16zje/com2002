import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class Home extends JFrame {
	
	JFrame frame;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel Appointment;
	private JPanel Patient;
	private JPanel healthcarePlan;
	private JButton newAppointmentButton;
	private JRadioButton Dentist;
	private JRadioButton Hygienist;
	private JTable appointmentTable;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JPanel tableControlPanel;
	private JButton findAppointmentButton;
	private JButton deleteAppointmentButton;
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
	private JButton viewPatientPlanButton;
	private JScrollPane scrollPane;
	Date monDate;
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
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar currentCalendar = Calendar.getInstance();
		int currentYear =currentCalendar.get(Calendar.YEAR);
		int currentMonth = currentCalendar.get(Calendar.MONTH);
		int currentWeek = currentCalendar.get(Calendar.WEEK_OF_YEAR);
		int daysInMonth = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int currentDay = currentCalendar.get(Calendar.DATE);
		
		JSpinner year = new JSpinner();
		year.setModel(new SpinnerNumberModel(currentYear, currentYear-20, currentYear+1, 1));
		
		JSpinner month = new JSpinner();
		month.setModel(new SpinnerNumberModel(currentMonth+1,1,12,1));
		
		JComboBox week = WeekGenerator.weekSpinner(currentCalendar);
		
		tableControlPanel.add(week);
		tableControlPanel.add(month);
		tableControlPanel.add(year);	
		
		//Listeners for dates
		month.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				currentCalendar.set(Calendar.MONTH, (int)month.getValue()-1);
				week.setModel(new DefaultComboBoxModel(WeekGenerator.weekList(currentCalendar)));
				String selectedWeek = ((String)week.getSelectedItem()).substring(0, 10);
		    	try {
					monDate = timeFormat.parse(selectedWeek);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
		    	Date[] daysInWeekList = WeekGenerator.daysInWeekList(monDate);
		    	appointmentTable.setModel(new DefaultTableModel(WeekGenerator.appointmentList(),new String[] {"Time",
						"Monday "+timeFormat.format(daysInWeekList[0]),"Tuesday "+timeFormat.format(daysInWeekList[1]),"Wednesday "+timeFormat.format(daysInWeekList[2]),"Thursday "+timeFormat.format(daysInWeekList[3]),"Friday "+timeFormat.format(daysInWeekList[4])}) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}}
				);
			}
		});

		year.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				currentCalendar.set(Calendar.YEAR, (int)year.getValue());
				System.out.println(currentCalendar.getTime());
				week.setModel(new DefaultComboBoxModel(WeekGenerator.weekList(currentCalendar)));
				String selectedWeek = ((String)week.getSelectedItem()).substring(0, 10);
		    	try {
					monDate = timeFormat.parse(selectedWeek);
					System.out.println(monDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
		    	Date[] daysInWeekList = WeekGenerator.daysInWeekList(monDate);
		    	appointmentTable.setModel(new DefaultTableModel(WeekGenerator.appointmentList(),new String[] {"Time",
						"Monday "+timeFormat.format(daysInWeekList[0]),"Tuesday "+timeFormat.format(daysInWeekList[1]),"Wednesday "+timeFormat.format(daysInWeekList[2]),"Thursday "+timeFormat.format(daysInWeekList[3]),"Friday "+timeFormat.format(daysInWeekList[4])}) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}}
				);
			}
		});
		
		week.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	String selectedWeek = ((String)week.getSelectedItem()).substring(0, 10);
		    	try {
					monDate = timeFormat.parse(selectedWeek);
					System.out.println(monDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
		    	Date[] daysInWeekList = WeekGenerator.daysInWeekList(monDate);
		    	appointmentTable.setModel(new DefaultTableModel(WeekGenerator.appointmentList(),new String[] {"Time",
						"Monday "+timeFormat.format(daysInWeekList[0]),"Tuesday "+timeFormat.format(daysInWeekList[1]),"Wednesday "+timeFormat.format(daysInWeekList[2]),"Thursday "+timeFormat.format(daysInWeekList[3]),"Friday "+timeFormat.format(daysInWeekList[4])}) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}}
				);
		    }
		});

		appointmentTable = new JTable();
		JScrollPane appointmentScrollPane = new JScrollPane(appointmentTable);
		Appointment.add(appointmentScrollPane, BorderLayout.CENTER);
		
		Date[] daysInWeekList = WeekGenerator.daysInWeekList(currentCalendar.getTime());
		appointmentTable.setModel(new DefaultTableModel(WeekGenerator.appointmentList(),new String[] {"Time",
				"Monday "+timeFormat.format(daysInWeekList[0]),"Tuesday "+timeFormat.format(daysInWeekList[1]),"Wednesday "+timeFormat.format(daysInWeekList[2]),"Thursday "+timeFormat.format(daysInWeekList[3]),"Friday "+timeFormat.format(daysInWeekList[4])}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}}
		);
		appointmentPanel = new JPanel();
		Appointment.add(appointmentPanel, BorderLayout.SOUTH);
		appointmentPanel.setLayout(new BoxLayout(appointmentPanel, BoxLayout.X_AXIS));
		
		newAppointmentButton = new JButton("Create new Appointment");
		appointmentPanel.add(newAppointmentButton);
		
		findAppointmentButton = new JButton("Find Appointment");
		appointmentPanel.add(findAppointmentButton);
		findAppointmentButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		findAppointmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		deleteAppointmentButton = new JButton("Delete Appointment");
		appointmentPanel.add(deleteAppointmentButton);
		deleteAppointmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		viewPatientPlanButton = new JButton("View Healthcare Plan");
		viewPatientPlanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subscriptionPlan.main(null);
			}
		});
		patientEditPanel.add(viewPatientPlanButton);
		
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
				"Patient ID", "Name", "Date Of Birth", "Phone No", "Address", "Healthcare Plan"
			}
		));
		patientTable.setFillsViewportHeight(true);
		
		//UI for healthcare plan tab
		healthcarePlan = new JPanel();
		tabbedPane.addTab("Healthcare Plan", null, healthcarePlan, null);
		healthcarePlan.setLayout(new BorderLayout(0, 0));
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
		/**
		
		planPanel = new JPanel();
		healthcarePlan.add(planPanel, BorderLayout.EAST);
		planPanel.setLayout(new BoxLayout(planPanel, BoxLayout.Y_AXIS));
		
		btnCreateNewPlan = new JButton("Create New Plan");
		btnCreateNewPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HealthcarePlanEditors.main(null);
			}
		});
		planPanel.add(btnCreateNewPlan);
		
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
		**/
	}
}
