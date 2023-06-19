package Semana5.Lunes.Shapes;

public class Box extends Shapes3D {
  // atributos
  private double width;
  private double height;

  // constructor base
  public Box (int posx, int posy, int posz, double width, double height) {
    super(posx, posy, posz);
    this.width = width;
    this.height = height;
  }

  // sobreescribe el método toString()
  @Override
  public String toString() {
    return (super.toString() + String.format("'width': %.2f\n'height': %.2f\n'area': %.2f\n'perimeter': %.2f\n'volume': %.2f\n",
    width, height, getArea(), getPerimeter(), getVolume()
    ));
  }

  // obtiene el perímetro
  @Override
  public double getPerimeter() {
    return (2 * (width + height));
  }

  // obtiene el área
  @Override
  public double getArea() {
    return (width * height);
  }

  // obtiene el volúmen (Todavía no está terminado!!)
  @Override
  public double getVolume() {
    return 0;
  }
}
