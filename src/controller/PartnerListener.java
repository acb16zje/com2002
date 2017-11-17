package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	
	public PartnerListener(int i,Calendar c,JTable t,JLabel l) {
		this.dayChange = i;
		this.calendar = c;
		this.table = t;
		this.label = l;
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
        label.setText(new SimpleDateFormat("EEEE").format(calendar.getTime())+" "+timeFormat.format(calendar.getTime()));
	}

}
