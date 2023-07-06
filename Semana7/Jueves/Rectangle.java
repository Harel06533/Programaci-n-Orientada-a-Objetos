package Semana7.Jueves;

public class Rectangle implements Comparable<Rectangle> {
  // constnates
  public static final int DEFAULT_HEIGHT = 2;
  public static final int DEFAULT_BASE = 4;

  // atributos
  private double base;
  private double height;

  public Rectangle () {
    setDimension(DEFAULT_BASE, DEFAULT_HEIGHT);
  }

  public Rectangle (double base, double height) {
    setDimension(base, height);
  }

  @Override
  public String toString () {
    return ("{" + 
    "'base': " + base + 
    ", 'height': " + height + 
    ", 'area': " + getArea() + 
    ", 'perimter': " + getPerimeter() +
    "}\n");
  }

  // compara las áreas y retorna la diferencia
  @Override
  public int compareTo (Rectangle r) {
    return ((int)(this.getArea() - r.getArea()));
  }

  public double getBase () {
    return base;
  }
  
  public double getHeight () {
    return height;
  }

  public double getArea () {
    return (base * height);
  }

  public double getPerimeter () {
    return (2 * (base + height));
  }

  public void setBase (double base) {
    this.base = (base > 0) ? (base) : (DEFAULT_BASE);
  }

  public void setHeight (double height) {
    this.height = (height > 0) ? (height) : (DEFAULT_HEIGHT);
  }

  public void setDimension (double base, double height) {
    setBase(base);
    setHeight(height);
  }
  
}
