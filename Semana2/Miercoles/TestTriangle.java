package Semana2.Miercoles;

import Semana2.Miercoles.Shapes2D.RightTriangle;

public class TestTriangle {
  public static void main (String[] args) {
    RightTriangle t1 = new RightTriangle(-1, -100);
    RightTriangle t2 = new RightTriangle(4.5, 9);
    RightTriangle t3 = new RightTriangle(15, 8);

    RightTriangle[] tArray = {t1, t2, t3};
    String output = "";
    for (int i = 0; i < tArray.length; i++) {
      output += String.format("Side data of Triangle %d\n%s\n", i + 1, tArray[i].getSidesInfo());
      output += String.format("Function data of Triangle %d\n%s\n\n", i + 1, tArray[i].getFunctionsInfo());
    } 
    System.out.println(output); 
  }
}