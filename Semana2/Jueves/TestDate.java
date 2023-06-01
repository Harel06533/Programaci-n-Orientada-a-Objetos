package Semana2.Jueves;

import Semana2.Jueves.Dates.Date;

public class TestDate {
  public static void main (String[] args) {
    Date d1 = new Date();
    Date d2 = new Date(29, 02, 1600);
    Date d3 = new Date(11, 02, 1556);
    Date d4 = new Date(-1, 10, 2040);

    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d3);
    System.out.println(d4);

    d2.setYear(1601);
    System.out.println(d2);
  }
}