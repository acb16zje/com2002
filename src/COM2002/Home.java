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
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		Appointment = new JPanel();
		tabbedPane.addTab("Appointment\r\n", null, Appointment, null);
		Appointment.setLayout(new BorderLayout(0, 0));
		
		appointmentTable = new JPanel();
		Appointment.add(appointmentTable, BorderLayout.CENTER);
		appointmentTable.setLayout(null);
		
		btnNewButton = new JButton("Create new Appointment");
		btnNewButton.setBounds(615, 0, 154, 50);
		appointmentTable.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Find Appointment");
		btnNewButton_1.setBounds(615, 70, 154, 50);
		appointmentTable.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnNewButton_2 = new JButton("Delete Appointment");
		btnNewButton_2.setBounds(615, 140, 154, 50);
		appointmentTable.add(btnNewButton_2);
		
		table = new JTable();
		table.setBounds(0, 51, 614, 372);
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
		
		panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 615, 33);
		appointmentTable.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Hygienist = new JRadioButton("Hygienist");
		panel_4.add(Hygienist);
		
		Dentist = new JRadioButton("Dentist");
		panel_4.add(Dentist);
		
		ButtonGroup partnerGroup = new ButtonGroup();
		partnerGroup.add(Hygienist);
		partnerGroup.add(Dentist);
		
		comboBox = new JComboBox();
		panel_4.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		
		comboBox_2 = new JComboBox();
		panel_4.add(comboBox_2);
		
		comboBox_1 = new JComboBox();
		panel_4.add(comboBox_1);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Patient = new JPanel();
		tabbedPane.addTab("Patient", null, Patient, null);
		
		healthcarePlan = new JPanel();
		tabbedPane.addTab("Healthcare Plan", null, healthcarePlan, null);
	}

}
