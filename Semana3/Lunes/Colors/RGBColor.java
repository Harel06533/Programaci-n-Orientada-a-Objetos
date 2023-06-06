package Semana3.Lunes.Colors;

public class RGBColor {
  private int red = 0;
  private int green = 0;
  private int blue = 0;

  /**
   * Constructor sin parámetros, inicializa {@code red}, {@code green}, {@code blue} en sus valores base
   * que son {0, 0, 0}.
   */
  public RGBColor () {};

  /**
   * Constructor con parámetros, valida los valores de {@code red}, {@code green} y {@code blue} y si
   * son válidos, setea esos valores, si no, los regresa a sus valores base.
   * @param red Intensidad del rojo
   * @param green Intensidad del verde
   * @param blue Intensidad del Azul
   */
  public RGBColor (int red, int green, int blue) {
    setRed(red);
    setGreen(green);
    setBlue(blue);
  } 

  /* SETTERS */

  /**
   * Setea la intensidad del rojo
   * @param red Intensidad del Rojo
   */
  public void setRed (int red) {
    if (isValidColorValue(red))
      this.red = red;
  }

  /**
   * Setea la intensidad del verde
   * @param green Intensidad del Verde
   */
  public void setGreen (int green) {
    if (isValidColorValue(green))
      this.green = green;
  }

  /**
   * Setea la intensidad del azul
   * @param blue Intensidad del Azul
   */
  public void setBlue (int blue) {
    if (isValidColorValue(blue))
      this.blue = blue;
  }

  /* GETTERS */
  /**
   * 
   * @return Intensidad del rojo
   */
  public int getRed () {
    return (red);
  }

  /**
   * 
   * @return Intensidad del verde
   */
  public int getGreen () {
    return (green);
  }

  /**
   * 
   * @return Intensidad del azul
   */
  public int getBlue () {
    return (blue);
  }

  /**
   * @return Formato de {@code String} con la información del objeto.
   */
  public String toString () {
    return (String.format("{'red': %d, 'green': %d, 'blue': %d}", red, green, blue));
  }

  /**
   * Evalúa el contenido del objeto {@code RGBColor} base con otra instancia y retorna si son iguales
   * @param color Instancia diferente del color
   * @return Si sus datos de {@code red}, {@code green} y {@code blue} son iguales
   */
  public boolean equals (Object object) {
    if (object instanceof RGBColor) {
      RGBColor color = (RGBColor) object;
      return(color.getRed() == red && color.getGreen() == green && color.getBlue() == blue);
    }
    return false;
  }

  /**
   * @return Una instancia con los mismos atributos base del Objeto padre
   */
  public RGBColor clone () {
    return (new RGBColor(red, green, blue));
  }

  /* MÉTODOS PRIVADOS */

  /**
   * Evalúa que un valor de rgb sea válido
   * @param color Cualquier valor de Color
   * @return Si es válido
   */
  private boolean isValidColorValue (int color) {
    return (color >= 0 && color <= 255); 
  }
}