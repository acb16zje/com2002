package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.WeekGenerator;

public class PartnerListener implements ActionListener {

    private SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
    private int dayChange;
    private Calendar calendar;
    private JTable table;
    private JLabel label;
    private JButton editButton;
    private int id;

    public PartnerListener(int i, Calendar c, JTable t, JLabel l, int id, JButton button) {
        this.dayChange = i;
        this.calendar = c;
        this.table = t;
        this.label = l;
        this.editButton = button;
        this.id = id;
    }

    public static void buttonDisabler(JTable partnerTable, JButton editButton) {
        partnerTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int column = target.getSelectedColumn();
                int row = target.getSelectedRow();
                Object cell = partnerTable.getValueAt(row, column);
                if (column == 0 || cell == null || ((String) cell).substring(0, 1).equals("0")) {
                    editButton.setEnabled(false);
                } else {
                    editButton.setEnabled(true);
                }
            }
        });

        partnerTable.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                JTable target = (JTable) e.getSource();
                int column = target.getSelectedColumn();
                int row = target.getSelectedRow();
                Object cell = partnerTable.getValueAt(row, column);
                if (column == 0 || cell == null || ((String) cell).substring(0, 1).equals("0")) {
                    editButton.setEnabled(false);
                } else {
                    editButton.setEnabled(true);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calendar.add(Calendar.DAY_OF_YEAR, dayChange);
        table.setModel(
            new DefaultTableModel(WeekGenerator.appointmentList(), new String[]{"Time",
                timeFormat.format(calendar.getTime())}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
        label.setText(new SimpleDateFormat("EEEE").format(calendar.getTime()) + " " + timeFormat
            .format(calendar.getTime()));
        Date monDate = calendar.getTime();
        editButton.setEnabled(false);
        AppointmentQueries.getDayAppointmentList(table, monDate, id, 1);
    }

}
