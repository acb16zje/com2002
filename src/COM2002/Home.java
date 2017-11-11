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
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints; 
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel Appointment;
	private JPanel Patient;
	private JPanel healthcarePlan;
	private JButton btnNewButton;
	private JPanel appointmentTable;
	private JRadioButton Dentist;
	private JRadioButton Hygienist;
	private JTable table;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JPanel panel_4;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField patientID;
	private JButton searchPatientButton;
	private JLabel lblPatientId;
	private JButton addPatientButton;
	private JPanel panel_5;
	private JButton editPatientButton;
	private JButton deletePatientButton;
	private JTable table_1;
	private JPanel panel_6;
	private JButton btnCreateNewPlan;
	private JPanel panel_7;
	private JLabel healthCarePlan;
	private JTextField searchBox;
	private JButton searchPlan;
	private JTable table_2;
	private JPanel panel_8;
	private JButton removePlan;
	private JButton editPlan;
	private JButton btnViewPatientPlan;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		appointmentTable = new JPanel();
		Appointment.add(appointmentTable);
		appointmentTable.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		appointmentTable.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Hygienist = new JRadioButton("Hygienist");
		panel_4.add(Hygienist);
		
		Dentist = new JRadioButton("Dentist");
		panel_4.add(Dentist);
		partnerGroup.add(Hygienist);
		partnerGroup.add(Dentist);
		
		comboBox = new JComboBox();
		panel_4.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		
		comboBox_2 = new JComboBox();
		panel_4.add(comboBox_2);
		
		comboBox_1 = new JComboBox();
		panel_4.add(comboBox_1);
		
		table = new JTable();
		appointmentTable.add(table);
		table.setModel(new DefaultTableModel(
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
		
		panel = new JPanel();
		appointmentTable.add(panel, BorderLayout.EAST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		btnNewButton = new JButton("Create new Appointment");
		btnNewButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Find Appointment");
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_2 = new JButton("Delete Appointment");
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//UI for patient
		Patient = new JPanel();
		tabbedPane.addTab("Patient", null, Patient, null);
		Patient.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		Patient.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		lblPatientId = new JLabel("Patient ID:");
		panel_2.add(lblPatientId);
		
		patientID = new JTextField();
		panel_2.add(patientID);
		patientID.setColumns(20);
		
		searchPatientButton = new JButton("Search");
		panel_2.add(searchPatientButton);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		
		addPatientButton = new JButton("Add Patient");
		addPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPatient patientFrame = new EditPatient();
				patientFrame.setVisible(true);
				}
		});
		panel_3.add(addPatientButton);
		
		panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		panel_1.add(panel_5, BorderLayout.SOUTH);
		
		btnViewPatientPlan = new JButton("View Healthcare Plan");
		panel_5.add(btnViewPatientPlan);
		
		editPatientButton = new JButton("Edit");
		editPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPatient patientFrame = new EditPatient();
				patientFrame.setVisible(true);
				}
		});
		panel_5.add(editPatientButton);
		
		deletePatientButton = new JButton("Delete");
		deletePatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(deletePatientButton,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){ 
					//insert delete patient sql stuff here
				 }  
			}
		});
		panel_5.add(deletePatientButton);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setFillsViewportHeight(true);
		panel_1.add(table_1, BorderLayout.CENTER);
		
		//UI for healthcare plan tab
		healthcarePlan = new JPanel();
		tabbedPane.addTab("Healthcare Plan", null, healthcarePlan, null);
		healthcarePlan.setLayout(new BorderLayout(0, 0));
		
		panel_6 = new JPanel();
		healthcarePlan.add(panel_6, BorderLayout.EAST);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		btnCreateNewPlan = new JButton("Create New Plan");
		panel_6.add(btnCreateNewPlan);
		
		panel_7 = new JPanel();
		healthcarePlan.add(panel_7, BorderLayout.NORTH);
		
		healthCarePlan = new JLabel("Plan ID:");
		panel_7.add(healthCarePlan);
		
		searchBox = new JTextField();
		searchBox.setColumns(20);
		panel_7.add(searchBox);
		
		searchPlan = new JButton("Search");
		panel_7.add(searchPlan);
		
		table_2 = new JTable();
		healthcarePlan.add(table_2, BorderLayout.CENTER);
		
		panel_8 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setAlignOnBaseline(true);
		healthcarePlan.add(panel_8, BorderLayout.SOUTH);
		
		removePlan = new JButton("Remove Healthcare Plan");
		removePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(removePlan,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){ 
					//insert delete plan sql stuff here
				 }  
			}
		});
		
		editPlan = new JButton("Edit Healthcare Plan");
		panel_8.add(editPlan);
		panel_8.add(removePlan);
	}
}
