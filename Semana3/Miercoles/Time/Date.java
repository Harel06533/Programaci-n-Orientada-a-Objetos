package Semana3.Miercoles.Time;

public class Date {

  // Constantes para cada mes
  public final static int JANUARY = 1;
  public final static int FEBRUARY = 2;
  public final static int MARCH = 3;
  public final static int APRIL = 4;
  public final static int MAY = 5;
  public final static int JUNE = 6;
  public final static int JULY = 7;
  public final static int AUGUST = 8;
  public final static int SEPTEMBER = 9;
  public final static int OCTOBER = 10;
  public final static int NOVEMBER = 11;
  public final static int DECEMBER = 12;

  // Constantes para fechas base
  private final int FIRST_DAY = 1;            //--> Primer día default
  private final int FIRST_MONTH = JANUARY;    //--> Primer mes default
  private final int FIRST_YEAR = 1970;        //--> Primer año default
  private final int LAST_YEAR = 9999;         //--> Último año posible

  // String que guarda cada mes en órden
  private final String[] months = {
    "January", "February", "March",
    "April", "May", "June", 
    "July", "August", "September", 
    "October", "November", "December"
  };

  // String que guarda cada día de la semana en órden
  private final String[] weekDays = {
    "Sunday", "Monday", "Tuesday",
    "Wednesday", "Thursday", "Friday",
    "Saturday"
  };

  // Atributos privados que guardarán información importante
  private int day;
  private int month;
  private int year;
  private String strMonth;
  private String weekDay;

  /**
   * Constructor base, inicializa la fecha con valores default que son {@code 1/January/1970}
   */
  public Date () {
    day = FIRST_DAY;
    month = FIRST_MONTH;
    year = FIRST_YEAR;
    strMonth = months[0];
  }

  /**
   * Constructor compuesto, el programador asignará el valor de {@code day}, {@code month} y {@code year}, utilizando los métodos Setters en
   * el siguiente orden:
   * 1. {@code setYear()}, 2. {@code setMonth()} y 3. {@code setDay()}. Este órden es muy importante ya que primero se necesita el año para determinar
   * si es bisiesto, luego el mes para determinar la cantidad de días máximos y luego el día para determinar si este último cumple estando en el rango de
   * días máximos.
   * @param day El día a ingresar
   * @param month El mes a ingresar
   * @param year El año a ingresar
   */
  public Date (int day, int month, int year) {
    setYear(year);
    setMonth(month);
    setDay(day);
  }

  /**
   * Este método sobreescribe el método {@code toString()} de la superclase {@code Object} mostrando los datos de {@code day},
   * {@code month} como una cadena de Texto, {@code year} y {@code weekDay}.
   * @return Representación de los datos en formato String
   */
  public String toString () {
    if (!isValidDate())
      return ("Input not a valid Date");
    return (day + "/" + strMonth + "/" + year + ": -> " + weekDay);
  }

  /**
   * Este método sobreescribe el método {@code equals()} de la superclase {@code Object}. Determina si dos Objetos (Principalmente de clase {@code Date})
   * contienen los mismos atributos
   * @return Retorna {@code true} si los atributos de la instancia son iguales a los de la otra instancia. Si no retorna {@code false}.
   */
  public boolean equals (Object o) {
    if (o instanceof Date) {
      Date d = (Date)o;
      return (year == d.getYear() && month == d.getMonthNumber() && day == d.getDay());
    }
    return false;
  }

  /**
   * Este método sobreescribe el método {@code clone()} de la superclase {@code Object}. Copia los atributos del objeto actual y retorna un
   * nuevo objeto con estos mismos datos copiados.
   * @return Retorna un nuevo objeto de tipo {@code Date} con los datos del objeto actual.
   */
  public Date clone () {
    return (new Date(day, month, year));
  }

  //-- SETTERS --//

  /**
   * Setter para ingresar valor a {@code year}, si es válido lo ingresa y si no recibe el valor por default.
   * @param year El valor del año a ingresar
   */
  public void setYear (int year) {
    this.year = (isValidYear(year)) ? (year) : (FIRST_YEAR);
  }

  /**
   * Setter para ingresar el valor a {@code month}, si es válido, lo ingresa y si no recibe el valor por default.
   * Además, mapea el dato {@code strMonth}, como la string pertenciente al mes. Ejemplo "0" -> "January".
   * @param month El valor del mes a ingresar
   */
  public void setMonth (int month) {
    this.month = (isValidMonth(month)) ? (month) : (FIRST_MONTH);
    strMonth = months[this.month - 1];
  }

  /**
   * Setter para ingresar el valor a {@code day}, si es válido, lo ingresa y si no recibe el valor por default.
   * Además, mapea el dato {@code weekDay}, como la string perteneciente al día. Ejemplo "15" -> "Sunday". Esto se hace
   * mediante un método que utiliza el algoritmo de Zeller.
   * @param day El valor del día a ingresar
   */
  public void setDay (int day) {
    this.day = (isValidDay(day)) ? (day) : (FIRST_DAY);
    weekDay = weekDays[calcWeekDay()];
  }

  /**
   * Retorna el valor del año
   * @return El valor del año
   */
  public int getYear () {
    return (year);
  }

  /**
   * Retorna el valor del mes numérico
   * @return El valor del mes numérico
   */
  public int getMonthNumber () {
    return (month);
  }

  /**
   * Retorna el valor del mes en texto
   * @return El valor del mes en texto
   */
  public String getMonth () {
    return (strMonth);
  }

  /**
   * Retorna el valor del día
   * @return El valor del día
   */
  public int getDay () {
    return (day);
  }

  /**
   * Retorna el día de la semana al que pertenece la fecha
   * @return El día de la semana
   */
  public String getWeekDay () {
    return (weekDay);
  }
  
  /**
   * Determina si el año es o no un año bisisesto
   * @return Retorna {@code true} si el año fue bisiseto, retorna {@code false} en otro caso.
   */
  public boolean isLeapYear () {
    return (year % 4 == 0 || year % 400 == 0 && year % 100 != 0);
  }

  /**
   * Retorna la cantidad de días máximos que existen en un mes, basandose en el atributo {@code month}.
   * @return La cantidad máxima de días en un mes
   */
  public int maxDays () {
    switch (month) {
      case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER:
        return 31;
      case APRIL, JUNE, SEPTEMBER, NOVEMBER:
        return 30;
      case FEBRUARY:
        return isLeapYear() ? (29) : (28);
      default:
        return -1;
    } 
  }

  /**
   * Calcula el día de la semana que pertenece a una fecha, utilizando el algorítmo de Congruencia de Zeller.
   * Retorna un tipo de dato {@code int} que indica el día, por ejemplo "0 -> Domingo". Este número retornado se utilizará 
   * para mapear en el arreglo {@code weekDays}, el día de la semana que pertenece y guardar ese valor en {@code weekDay}.
   * @return Un valor {@code int} con el número de día
   */
  private int calcWeekDay () {
    int q = day;
    int m = month;
    int y = year;

    if (m < 3) {
      m += 12;
      y--;
    }

    int h = (q + (13 * (m + 1)) / 5 + y + (y / 4) - (y / 100) + (y / 400)) % 7;
    return ((h + 6) & 7);
  }

  /**
   * Retorna si la fecha, basandose en la cantidad de días, es válida
   * @return Retorna {@code false} si el día es mayor que los días posibles o no es una fecha válida, si no retorna {@code true}
   */
  private boolean isValidDate () {
    if (day > maxDays() || maxDays() == -1)
      return false;
    return true;
  }

  /**
   * Retorna si el año ingresado es un año válido en el rango (1970 - 9999)
   * @param year Año ingresado
   * @return Si el año ingresado es válido.
   */
  private boolean isValidYear (int year) {
    return (year >= FIRST_YEAR && year <= LAST_YEAR);
  }

  /**
   * Retorna si el mes ingresado es un mes válido en el rango (1 - 12)
   * @param month El mes ingresado
   * @return Si el mes ingresado es válido
   */
  private boolean isValidMonth (int month) {
    return (month >= FIRST_MONTH && month <= months.length);
  }

  /**
   * Retorna si el día ingresado es un día válido en el rango (1 - [Días máximos posbiles en el mes actual])
   * @param day El día ingresado
   * @return Si el día ingresado es válido
   */
  private boolean isValidDay (int day) {
    return (day >= FIRST_DAY && day <= maxDays());
  }
}