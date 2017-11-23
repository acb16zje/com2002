package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class RefreshTableListener implements WindowListener {

    private JTable partnerTable;
    private JComboBox comboWeek;
    private JButton cancelButton;
    private JButton viewButton;
    private int partnerID;

    public RefreshTableListener(JTable partnerTable, JComboBox comboWeek, JButton cancelButton,
        JButton viewButton, int partnerID) {
        this.partnerTable = partnerTable;
        this.comboWeek = comboWeek;
        this.cancelButton = cancelButton;
        this.viewButton = viewButton;
        this.partnerID = partnerID;
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        AppointmentTableListener
            .refreshTable(partnerTable, (String) comboWeek.getSelectedItem(), partnerID,
                cancelButton, viewButton);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        AppointmentTableListener
            .refreshTable(partnerTable, (String) comboWeek.getSelectedItem(), partnerID,
                cancelButton, viewButton);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }

}
