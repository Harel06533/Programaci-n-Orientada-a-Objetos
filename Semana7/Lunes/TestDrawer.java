package Semana7.Lunes;

import Semana7.Lunes.Drawers.Drawer;

import Semana3.Lunes.Colors.RGBColor;

public class TestDrawer {
  public static void main (String[] args) {
    Drawer<RGBColor> rgbDrawer = new Drawer<>();
    Drawer<Drawer<RGBColor>> drawer = new Drawer<>();

    rgbDrawer.insert(new RGBColor(255, 100, 30));
    drawer.insert(rgbDrawer);

    System.out.println(drawer);
  }
}
