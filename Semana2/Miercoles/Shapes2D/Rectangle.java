package Semana2.Miercoles.Shapes2D;

public class Rectangle {

  private double base;
  private double height;

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
    base = (b > 0) ? (b) : 1;
  }

  public void setHeight (double h) {
    height = (h > 0) ? (h) : 1;
  }

  public String getInfo () {
    String output = String.format("(Base = %.2f, Height = %.2f, Perimeter = %.2f, Area = %.2f)", base, height, getPermiter(), getArea());
    return output;
  }

}