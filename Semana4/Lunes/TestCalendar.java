package Semana4.Lunes;

import java.util.Calendar;
import Semana4.Lunes.Time.Date;

public class TestCalendar {
  public static void main (String[] args) {    
    int currYear = Date.CURRENT_YEAR;
    int currMonth = Date.CURRENT_MONTH;
    int currDay = Date.CURRENT_DAY;

    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();

    c1.set(2021, 9, 23);
    c2.set(currYear, currMonth, currDay);

    Calendar oldestDate = (c1.compareTo(c2) < 0) ? (c1) : (c2);

    printCalendar(oldestDate);

    c1.add(Calendar.DAY_OF_MONTH, 14);
    c1.add(Calendar.YEAR, -4);

    printCalendar(c1);

    Calendar t1 = Calendar.getInstance();
    Calendar dt1 = Calendar.getInstance();

    int currHour = t1.get(Calendar.HOUR_OF_DAY);
    int c1Year = c1.get(Calendar.YEAR);
    int c1Month = c1.get(Calendar.MONTH);
    int c1Day = c1.get(Calendar.DAY_OF_WEEK);

    dt1.set(c1Year, c1Month, c1Day, currHour, 0);

    printCalendar(dt1);
    System.out.println(dt1.get(Calendar.HOUR_OF_DAY));
  }

  public static void printCalendar (Calendar calendar) {
    int calYear = calendar.get(Calendar.YEAR);
    int calMonth = calendar.get(Calendar.MONTH);
    int calDay = calendar.get(Calendar.DAY_OF_WEEK);
    System.out.println(calYear + "/" + calMonth + "/" + calDay);
  }
}