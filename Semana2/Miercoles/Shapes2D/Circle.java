package Semana2.Miercoles.Shapes2D;

public class Circle {
  private double radius;                      //--> Radio del Círculo (1 como número base) 
  private double PI = Math.PI;                    //--> Constante Pi

  /* Constructor que inicializa el radio */
  public Circle(double rad) {
    setRadius(rad);
  }

  // --GETTERS-- //
  /* Retorna el área del círculo */
  public double getArea () {
    return ((radius * radius) * PI);
  }

  /* Retorna el perímetro del círculo */
  public double getPermiter () {
    return (2 * PI * radius);
  }

  /* Retorna una String con  */
  public String getInfo () {
    String output = String.format("(Radius = %.2f, Perimeter = %.2f, Area = %.2f)", radius, getPermiter(), getArea());
    return output;
  }
  // --SETTERS-- //
  /* Setea el valor del radio, si es < 0 lo evalúa a 1 */
  public void setRadius (double rad) {
    radius = (rad > 0) ? (rad) : 1;
  }
}