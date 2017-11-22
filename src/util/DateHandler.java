package util;

import java.sql.Date;

public class DateHandler {

    public static Date newDate(int year, int month, int day) {
        return new Date(year - 1900, month - 1, day);
    }

}
