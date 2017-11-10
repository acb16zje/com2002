import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JSplitPane;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel Appointment;
	private JPanel Patient;
	private JPanel healthcarePlan;
	private JPanel appointmentControl;
	private JButton btnNewButton;
	private JPanel appointmentTable;
	private JRadioButton Dentist;
	private JRadioButton Hygienist;
	private JTable table;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JSplitPane splitPane;
	private JPanel panel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		appointmentControl = new JPanel();
		Appointment.add(appointmentControl, BorderLayout.EAST);
		
		btnNewButton = new JButton("Create new Appointment");
		appointmentControl.add(btnNewButton);
		
		appointmentTable = new JPanel();
		Appointment.add(appointmentTable, BorderLayout.CENTER);
		appointmentTable.setLayout(new BorderLayout(0, 0));
		
		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		appointmentTable.add(splitPane);
		
		table = new JTable();
		splitPane.setRightComponent(table);
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
		splitPane.setLeftComponent(panel_4);
		
		Hygienist = new JRadioButton("Hygienist");
		panel_4.add(Hygienist);
		
		Dentist = new JRadioButton("Dentist");
		panel_4.add(Dentist);
		
		comboBox = new JComboBox();
		panel_4.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		
		comboBox_2 = new JComboBox();
		panel_4.add(comboBox_2);
		
		comboBox_1 = new JComboBox();
		panel_4.add(comboBox_1);
		
		Patient = new JPanel();
		tabbedPane.addTab("Patient", null, Patient, null);
		
		healthcarePlan = new JPanel();
		tabbedPane.addTab("Healthcare Plan", null, healthcarePlan, null);
	}

}
