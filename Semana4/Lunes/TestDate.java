package Semana4.Lunes;

import Semana4.Lunes.Time.Date;

public class TestDate {
  public static void main (String[] args) {
    Date date = new Date();
    Date date2 = new Date(12, 6, 2023);

    System.out.println(date);
    System.out.println(date.equals((date2)));
    System.out.println(Date.INSTANCES);
  }
}