
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;

public class Welcome extends JFrame {

	private JPanel contentPane;

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
					Welcome frame = new Welcome();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setBackground(new Color(240, 240, 240));
		setTitle("Sheffield Dentistry Management Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("Sheffield Dentistry Manangement Program");
		lblLogo.setBounds(5, 76, 574, 25);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblLogo);
		
		JButton SecretaryLogin = new JButton("Secretary");
		SecretaryLogin.setBounds(65, 146, 110, 63);
		contentPane.add(SecretaryLogin);
		SecretaryLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home homeFrame = new Home();
				homeFrame.setVisible(true);
				homeFrame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						homeFrame.dispose();
						Welcome welcome = new Welcome();
						welcome.setVisible(true);
					}
				});
			}
		});
		
		JButton HygienistLogin = new JButton("Hygienist");
		HygienistLogin.setBounds(241, 146, 108, 63);
		contentPane.add(HygienistLogin);
		
		JButton DentistLogin = new JButton("Dentist");
		DentistLogin.setBounds(415, 146, 98, 63);
		DentistLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(DentistLogin);
	}
	
}
