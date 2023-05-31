package Semana2.Miercoles;

public class Circle {
  public double radius;                      //--> Radio del Círculo 
  private double PI = Math.PI;               //--> Constante Pi

  /**
   * Constructor - Inicializa el atributo "radio" al crear el objeto 
   * @param rad
   */
  public Circle(double rad) {
    radius = rad;
  }

  /**
   * Retorna el área del objeto
   * @return Un double con el valor del área del objeto
   */
  public double getArea () {
    return ((radius * radius) * PI);
  }

  /**
   * Retorna el perímetro del objeto
   * @return Un double con el valor del perímetro del objeto
   */
  public double getPermiter () {
    return (2 * PI * radius);
  }

  /**
   * Formatea una string con la información del objeto y la retorna
   * @return String con la información del objeto
   */
  public String getInfo () {
    String output = String.format("(Radius = %.2f, Perimeter = %.2f, Area = %.2f)", radius, getPermiter(), getArea());
    return output;
  }
}