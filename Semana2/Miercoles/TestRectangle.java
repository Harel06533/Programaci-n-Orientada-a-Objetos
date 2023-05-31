package Semana2.Miercoles;

import Semana2.Miercoles.Shapes2D.Rectangle;

public class TestRectangle {
  public static void main (String[] args) {
    Rectangle r1 = new Rectangle(4, 5); 
    Rectangle r2 = new Rectangle(8.8, 10.5);
    Rectangle r3 = new Rectangle(20, 100);

    String output = ""; 
    Rectangle[] rArray = {r1, r2, r3}; 
    for (int i = 0; i < rArray.length; i++) 
      output += String.format("Data of Rectangle %d\n%s\n\n", i + 1, rArray[i].getInfo());
    System.out.println(output);
  }
}