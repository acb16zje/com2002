import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

public class Welcome extends JFrame {

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public Welcome() {
        setBounds(100, 100, 620, 310);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{51, 65, 120, 65, 120, 65, 120, 108, 0};
        gbl_contentPane.rowHeights = new int[]{76, 25, 58, 71, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblLogo = new JLabel("Sheffield Dentistry Manangement Program");
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        GridBagConstraints gbc_lblLogo = new GridBagConstraints();
        gbc_lblLogo.fill = GridBagConstraints.BOTH;
        gbc_lblLogo.insets = new Insets(0, 0, 5, 5);
        gbc_lblLogo.gridwidth = 5;
        gbc_lblLogo.gridx = 2;
        gbc_lblLogo.gridy = 1;
        contentPane.add(lblLogo, gbc_lblLogo);

        JButton SecretaryLogin = new JButton("Secretary");
        GridBagConstraints gbc_SecretaryLogin = new GridBagConstraints();
        gbc_SecretaryLogin.fill = GridBagConstraints.BOTH;
        gbc_SecretaryLogin.insets = new Insets(0, 0, 0, 5);
        gbc_SecretaryLogin.gridx = 2;
        gbc_SecretaryLogin.gridy = 3;
        contentPane.add(SecretaryLogin, gbc_SecretaryLogin);
        SecretaryLogin.addActionListener(new ActionListener() {
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
        GridBagConstraints gbc_HygienistLogin = new GridBagConstraints();
        gbc_HygienistLogin.fill = GridBagConstraints.BOTH;
        gbc_HygienistLogin.insets = new Insets(0, 0, 0, 5);
        gbc_HygienistLogin.gridx = 4;
        gbc_HygienistLogin.gridy = 3;
        contentPane.add(HygienistLogin, gbc_HygienistLogin);

        JButton DentistLogin = new JButton("Dentist");
        DentistLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        GridBagConstraints gbc_DentistLogin = new GridBagConstraints();
        gbc_DentistLogin.insets = new Insets(0, 0, 0, 5);
        gbc_DentistLogin.fill = GridBagConstraints.BOTH;
        gbc_DentistLogin.gridx = 6;
        gbc_DentistLogin.gridy = 3;
        contentPane.add(DentistLogin, gbc_DentistLogin);

        setTitle("Sheffield Dentistry Management Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

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

}