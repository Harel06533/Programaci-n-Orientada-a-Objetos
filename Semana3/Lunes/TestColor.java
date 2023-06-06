package Semana3.Lunes;

import Semana3.Lunes.Colors.RGBColor;

public class TestColor {
  public static void main (String[] args) {
    RGBColor color1 = new RGBColor(20, 255, 80);
    RGBColor color2 = color1.clone();
    RGBColor color3 = new RGBColor (500, 255, 255);
    RGBColor color4 = color3.clone();
    String s = "Hola";
    System.out.println(color1);
    System.out.println(color2.equals(color1));
    System.out.println(color3);
    System.out.println(color4.equals(color3));
    System.out.println(color1.equals(s));
  }
}