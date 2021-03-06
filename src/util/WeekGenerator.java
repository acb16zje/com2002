package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;

public class WeekGenerator {

    private static SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
    private static Calendar currentCalendar = Calendar.getInstance();
    private static int currentWeek = currentCalendar.get(Calendar.WEEK_OF_YEAR);
    private static int selectedWeek;

    public static JComboBox weekSpinner(Calendar c) {
        JComboBox tempSpinner = new JComboBox(weekList(c));
        tempSpinner.setSelectedIndex(selectedWeek);
        return tempSpinner;
    }

    //returns the weeks in a month
    public static String[] weekList(Calendar c) {
        int currentMonth = c.get(Calendar.MONTH);
        int currentYear = c.get(Calendar.YEAR);
        Calendar tempCal = new GregorianCalendar(currentYear, currentMonth, 1);
        int arrayLen = 0;
        while (tempCal.get(Calendar.MONTH) == currentMonth) {
            int tempDay = tempCal.get(Calendar.DAY_OF_WEEK);
            if (tempDay == Calendar.MONDAY) {
                arrayLen++;
            }
            tempCal.add(Calendar.DAY_OF_YEAR, 1);
        }
        tempCal.set(Calendar.YEAR, currentYear);
        tempCal.set(Calendar.MONTH, currentMonth);
        tempCal.set(Calendar.DAY_OF_MONTH, 1);
        String[] weekList = new String[arrayLen];
        int weekSaved = 0;
        while (tempCal.get(Calendar.MONTH) == currentMonth) {
            int tempDay = tempCal.get(Calendar.DAY_OF_WEEK);
            if (tempDay == Calendar.MONDAY) {
                String tempMon = timeFormat.format(tempCal.getTime());
                tempCal.set(Calendar.DAY_OF_WEEK, 6);
                String tempFri = timeFormat.format(tempCal.getTime());
                weekList[weekSaved] = tempMon + " - " + tempFri;
                if (currentWeek == tempCal.get(Calendar.WEEK_OF_YEAR)) {
                    selectedWeek = weekSaved;
                }
                weekSaved++;
            }
            tempCal.add(Calendar.DAY_OF_YEAR, 1);
        }
        return weekList;
    }

    public static Date[] daysInWeekList(Date d) {
        Date[] daysInWeekList = new Date[5];
        currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(d);
        for (int i = 2; i <= Calendar.FRIDAY; i++) {
            currentCalendar.set(Calendar.DAY_OF_WEEK, i);
            daysInWeekList[i - 2] = (currentCalendar.getTime());
        }
        return daysInWeekList;
    }

    public static String[][] appointmentList() {
        String[][] appointmentList = new String[24][6];
        int row = 0;
        for (int i = 9; i <= 16; i++) {
            for (int j = 0; j <= 4; j += 2) {
                if (j == 4) {
                    String[] tempArray = {
                        Integer.toString(i) + ":" + Integer.toString(j) + "0 - " + Integer
                            .toString(i + 1) + ":00", null, null, null, null, null};
                    appointmentList[row] = tempArray;
                } else {
                    String[] tempArray = {
                        Integer.toString(i) + ":" + Integer.toString(j) + "0 - " + Integer
                            .toString(i) + ":" + Integer.toString(j + 2) + "0", null, null,
                        null, null, null};
                    appointmentList[row] = tempArray;
                }

                row++;
            }
        }

        return appointmentList;
    }
}
