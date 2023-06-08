package Semana3.Miercoles;

import Semana3.Miercoles.Time.Date;

public class TestFinalDate {
  public static void main (String[] args) {
    Date d1 = new Date(29, 02, 2000);
    Date d2 = d1.clone();
    System.out.println(d1.equals(d2));
    System.out.println(d1);
    d2.setDay(28);
    System.out.println(d2);
  }
}