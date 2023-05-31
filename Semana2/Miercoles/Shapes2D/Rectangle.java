package Semana2.Miercoles.Shapes2D;

public class Rectangle {

  private double DEFAULT_SIZE = 1;
  private double base = DEFAULT_SIZE;
  private double height = DEFAULT_SIZE;

  public Rectangle(double base, double height) {
    setBase(base);
    setHeight(height);
  }

  /* GETTERS */
  public double getBase () {
    return (base);
  }

  public double getHeight () {
    return (height);
  }
  
  public double getArea () {
    return (height * base);
  }

  public double getPermiter () {
    return (2 * (height + base));
  }

  /* SETTERS */
  public void setBase (double b) {
    if (b < 0) 
      return;
    base = b;
  }

  public String getInfo () {
    String output = String.format("(Base = %.2f, Height = %.2f, Perimeter = %.2f, Area = %.2f)", base, height, getPermiter(), getArea());
    return output;
  }

  public void setHeight (double h) {
    if (h < 0) 
      height = DEFAULT_SIZE;
    height = h;
  }
}