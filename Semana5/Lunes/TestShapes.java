package Semana5.Lunes;

import Semana5.Lunes.Shapes.Shapes3D;

public class TestShapes {
  public static void main(String[] args) {
    Shapes3D sphere = Shapes3D.createShape(Shapes3D.SPHERE, 10, 7, -9, 10);
    Shapes3D cylinder = Shapes3D.createShape(Shapes3D.CYLINDER, 50, 8, 4, 70, 30 );
    Shapes3D box = Shapes3D.createShape(Shapes3D.BOX, 10, 80, -5, 70, 80);

    Shapes3D[] shapes = {sphere, cylinder, box};

    for (int i = 0; i < shapes.length; i++)
      System.out.println(shapes[i]);
  }
}
