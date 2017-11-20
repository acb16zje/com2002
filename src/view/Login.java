package view;

import controller.LoginListener;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    /**
     * Create the Main Frame
     */
    public Login() {
        // Content panel for everything
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Main label for the logo
        JLabel logoLabel = new JLabel("Sheffield Dental Care");
        logoLabel.setBounds(68, 81, 485, 24);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(logoLabel);

        // Button for secretary login
        JButton SecretaryLogin = new JButton("Secretary");
        SecretaryLogin.setBounds(68, 168, 115, 71);
        contentPane.add(SecretaryLogin);
        SecretaryLogin.addActionListener(e -> {
            dispose();
            SecretaryInterface secretaryFrame = new SecretaryInterface();
            secretaryFrame.setVisible(true);
            secretaryFrame.addWindowListener(new LoginListener(secretaryFrame));
        });

        // Button for hygienist login
        JButton HygienistLogin = new JButton("Hygienist");
        HygienistLogin.setBounds(253, 168, 115, 71);
        HygienistLogin.addActionListener(e -> {
            dispose();
            PartnerInterface partnerFrame = new PartnerInterface("Hygienist");
            partnerFrame.setVisible(true);
            partnerFrame.addWindowListener(new LoginListener(partnerFrame));
        });
        contentPane.add(HygienistLogin);

        // Button for dentist login
        JButton DentistLogin = new JButton("Dentist");
        DentistLogin.setBounds(438, 168, 115, 71);
        DentistLogin.addActionListener(e -> {
            dispose();
            PartnerInterface partnerFrame = new PartnerInterface("Dentist");
            partnerFrame.setVisible(true);
            partnerFrame.addWindowListener(new LoginListener(partnerFrame));
        });
        contentPane.add(DentistLogin);

        // Settings for the frame
        setTitle("Sheffield Dental Care");
        setBounds(100, 100, 620, 310);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * The main method for dentistry program
     *
     * @param args Command line arguments, not used
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
