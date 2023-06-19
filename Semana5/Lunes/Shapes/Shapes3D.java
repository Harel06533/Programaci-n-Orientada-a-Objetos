package Semana5.Lunes.Shapes;

import java.util.HashMap;

public abstract class Shapes3D {
  // constantes
  public static final int SPHERE = 0;
  public static final int CYLINDER = 1;
  public static final int BOX = 2;

  // atributos
  protected int posx;
  protected int posy;
  protected int posz;

  private static HashMap<Integer, Shapes3D> shapesMap = new HashMap<>();     //--> HashMap para determinar el objeto que retorna

  // constructor base 
  protected Shapes3D (int posx, int posy, int posz) {
    this.posx = posx;
    this.posy = posy;
    this.posz = posz;
  }

  // sobreescribe el método toString()
  @Override
  public String toString() {
    return (String.format("'x': %d\n'y': %d\n'z': %d\n", posx, posy, posz));
  }

  // métodos para calcular valores de cada figura
  public abstract double getArea (); 
  public abstract double getPerimeter ();
  public abstract double getVolume (); 

  // retorna la figura en base al mapa (diseño factory)
  public static Shapes3D createShape (int id, int posx, int posy, int posz, double... dimensions) { 
    if (id < SPHERE || id > BOX) return null;
    if (dimensions.length > 1) {
      shapesMap.put(CYLINDER, new Cylinder(posx, posy, posz, dimensions[0], dimensions[1]));
      shapesMap.put(BOX, new Box(posx, posy, posz, dimensions[0], dimensions[1]));
    } else {
      shapesMap.put(SPHERE, new Sphere(posx, posy, posz, dimensions[0]));
    }
    return shapesMap.get(id);
  }
}
