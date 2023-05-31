package Semana2.Miercoles.Shapes2D;

public class RightTriangle {
  private double adyacent = 1;;
  private double oppose = 1;
  private double hipotenuse;

  /* Constructor - Inicializa el cateto adyacente y opuesto y calcula la hipotenusa */
  public RightTriangle (double ad, double op) {
    if (this.adyacent < 0 || this.oppose < 0) {
      hipotenuse = calcHipotenuse(1, 1);
      return;
    }
    adyacent = ad;
    oppose = op;
    hipotenuse = calcHipotenuse(ad, op);
  }

  /* Métodos de cálculo */

  /* Calcula la hipotenusa basada en los catetos dados */
  private double calcHipotenuse (double ad, double op) {
    return (Math.sqrt(Math.pow(ad, 2) + Math.pow(op, 2)));
  }

  /* Calcula el seno del triángulo */
  public double sineOfTriangle () {
    return (oppose / hipotenuse);
  }

  public double cosineOfTriangle () {
    return (adyacent / hipotenuse);
  }

  public double tangentOfTriangle () {
    return (oppose / adyacent);
  }

  /* SETTERS */

  /* Setea un nuevo valor para el cateto adyacente - recalcula la hipotenusa */
  public void setAdyacent (double value) {
    if (value < 0) {
      hipotenuse = calcHipotenuse(1, 1);
      return;
    }
    adyacent = value;
    hipotenuse = calcHipotenuse(adyacent, oppose);
  }

  /* Setea un nuevo valor para el cateto opuesto - recalcula la hipotenusa */
  public void setOppose (double value) {
    if (value < 0) {
      hipotenuse = calcHipotenuse(1, 1);
      return;
    }
    oppose = value;
    hipotenuse = calcHipotenuse(adyacent, oppose);
  }

  /* GETTERS */
  public double getAdyacent () {
    return adyacent;
  }

  public double getOppose () {
    return oppose;
  }

  public double getHipotenuse () {
    return hipotenuse;
  }

  public double getArea () {
    return ((adyacent * oppose) / 2);
  }

  public double getPerimeter () {
    return ((adyacent + oppose + hipotenuse));
  }

  public String getSidesInfo () {
    double ad = getAdyacent();
    double op = getOppose();
    double hip = getHipotenuse();
    double area = getArea();
    double per = getPerimeter();
    return(String.format("(Ad-Side = %.2f, Op-Side = %.2f, Hip = %.2f, Area = %.2f, Perimeter = %.2f)", ad, op, hip, area, per));
  }

  public String getFunctionsInfo () {
    double sine = sineOfTriangle();
    double cos = cosineOfTriangle();
    double tan = tangentOfTriangle();
    return (String.format("(Sine = %f, Cosine = %f, Tangen = %f)", sine, cos, tan));
  }
}