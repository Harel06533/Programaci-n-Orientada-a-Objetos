package Semana5.Lunes.Shapes;

public class Cylinder extends Shapes3D {
  // atributos
  private double radius;
  private double height;

  // constructor base
  protected Cylinder (int posx, int posy, int posz, double height, double radius) {
    super(posx, posy, posz);
    setDimensions(radius, height);
  } 

  @Override
  public String toString() {
    return (super.toString() + String.format("'radius': %.2f\n'height': %.2f\n'area': %.2f\n'perimeter': %.2f\n'volume': %.2f\n",
    radius, height, getArea(), getPerimeter(), getVolume()
    ));
  }

  // setea las dimensiones del radio y la altura
  public void setDimensions (double radius, double height) {
    setRadius(radius);
    setHeight(height);
  }

  // setea el radio
  public void setRadius (double radius) {
    this.radius = (radius >= 1 && radius <= 100) ? (radius) : (1);
  }

  // setea la altura
  public void setHeight(double height) {
    this.height = (height >= 1 && height <= 100) ? (height) : (1);
  }

  // calcula el perímetro
  @Override
  public double getPerimeter() {
    return (2 * Math.PI * radius);
  }

  // calcula el área
  @Override
  public double getArea() {
    return (Math.PI * radius * radius);
  }

  // calcula el volúmen
  @Override
  public double getVolume() {
    return (getArea() * height);
  }
}
