package Semana3.Jueves;

import Semana3.Jueves.Time.Date;

public class StaticDate {
  public static void main (String[] args) {
    Date d1 = new Date();
    Date d2 = new Date(29, Date.FEBRUARY, 2000);

    System.out.println(d1);             //--> {'Thursday', '1', 'January', '1970'}
    System.out.println(d2);             //--> {'Tuesday', '29', 'February', '2000'}

    System.out.println(d2.getWeekDay());                          //--> 'Tuesday'
    System.out.println(Date.getWeekDay(4));                   //--> 'Thursday'
    System.out.println(Date.getWeekDay(28, Date.FEBRUARY, 2000));   //--> 'Monday'

    System.out.println(Date.getMonthName(3));                 //--> 'March'
  }
}