package Semana2.Miercoles;

import Semana2.Miercoles.Circle;

public class TestCircle {
  public static void main (String[] args) {
    Circle c1 = new Circle(2.5);
    Circle c2 = new Circle(6.6);
    Circle c3 = new Circle(7.5);

    String c1Data = c1.getInfo();
    String c2Data = c2.getInfo();
    String c3Data = c3.getInfo();

    String output = String.format("Data from Circle 1\n%s\n\nData from Circle 2\n%s\n\n Data from Circle 3\n%s\n", c1Data, c2Data, c3Data);
    System.out.println(output);
  }
}