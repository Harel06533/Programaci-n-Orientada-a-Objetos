package Semana2.Miercoles;

import Semana2.Miercoles.Shapes2D.Circle;

public class TestCircle {
  public static void main (String[] args) {
    Circle c1 = new Circle(2.5);
    Circle c2 = new Circle(6.6);
    Circle c3 = new Circle(7.5);

    String output = "";
    Circle[] cArray = {c1, c2, c3};
    for (int i = 0; i < cArray.length; i++)  
      output += String.format("Data of Circle %d\n%s\n\n", i + 1, cArray[i].getInfo());
    System.out.println(output);
  }
}