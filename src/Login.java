import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
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
            secretaryFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    secretaryFrame.dispose();
                    Login welcome = new Login();
                    welcome.setVisible(true);
                }
            });
        });

        // Button for hygienist login
        JButton HygienistLogin = new JButton("Hygienist");
        HygienistLogin.setBounds(253, 168, 115, 71);
        contentPane.add(HygienistLogin);

        // Button for dentist login
        JButton DentistLogin = new JButton("Dentist");
        DentistLogin.setBounds(438, 168, 115, 71);
        DentistLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.add(DentistLogin);

        // Settings for the frame
        setTitle("Sheffield Dental Care");
        setBounds(100, 100, 620, 310);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
