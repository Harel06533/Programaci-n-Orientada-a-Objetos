package Semana5.Lunes.Shapes;

public class Sphere extends Shapes3D {
  // atributos
  private double radius;  
  
  // constructor base
  protected Sphere(int posx, int posy, int posz, double radius) {
    super(posx, posy, posz);
    setRadius(radius);
  }

  // sobreescribe el método toString()
  @Override
  public String toString() {
    return (super.toString() + String.format("'radius': %.2f\n'area': %.2f\n'perimeter': %.2f\n'volume': %.2f\n",
    radius, getArea(), getPerimeter(), getVolume()
    ));
  }

  // setea un radio válido
  public void setRadius(double radius) {
    this.radius = (radius >= 1 && radius <= 100) ? (radius) : (1);
  }

  // implementa el método para obtener el perímetro
  @Override
  public double getPerimeter() {
    return (2 * Math.PI * radius);
  }

  // implementa el método para obtener el área
  @Override
  public double getArea() {
    return (Math.PI * (radius * radius));
  }

  // implementa el método para obtener el volúmen
  @Override
  public double getVolume() {
    return ((4 / 3) * Math.PI * (radius * radius * radius)) ;
  }
}
