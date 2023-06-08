package Semana3.Jueves.Time;

public class Date {

  // Obtiene el número total de instancias globales
  public static int INSTANCES = 0;

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
  
  //  Constantes para días de la semana
  public static final int SUNDAY = 0;
  public static final int MONDAY = 1;
  public static final int TUESDAY = 2;
  public static final int WEDNESDAY = 3;
  public static final int THURSDAY = 4;
  public static final int FRIDAY = 5;
  public static final int SATURDAY = 6;
  
  // Constantes para fechas base
  public final static int FIRST_DAY = 1;            //--> Primer día default
  public final static int FIRST_MONTH = JANUARY;    //--> Primer mes default
  public final static int FIRST_YEAR = 1970;        //--> Primer año default
  public final static int LAST_YEAR = 9999;         //--> Último año posible
  
  // String que guarda cada mes en órden
  private static final String[] monthArray = {
    "January", "February", "March",
    "April", "May", "June", 
    "July", "August", "September", 
    "October", "November", "December"
  };
  
  // String que guarda cada día de la semana en órden
  private static final String[] dowArray = {
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

  // Constructores

  public Date () {
    setYear(FIRST_YEAR);
    setMonth(FIRST_MONTH);
    setDay(FIRST_DAY);
    INSTANCES++;
  }

  public Date (int day, int month, int year) {
    setYear(year);
    setMonth(month);
    setDay(day);
    INSTANCES++;
  }

  // Sobreescritura de métodos

  /* Sobreescribe el método toString */
  public String toString () {
    if (!isValidDate())
      return ("Date is not valid");
    return String.format("{\n'WeekDay': %s,\n'Day': %d,\n'Month': %s,\n'Year': %d\n}", weekDay, day, strMonth, year);
  }

  /* Sobreescribe el método equals */
  public boolean equals (Object o) {
    if (o instanceof Date) {
      Date d = (Date)o;
      return (d.getDay() == day && d.getMonth() == strMonth && d.getYear() == year);
    }
    return false;
  }

  /* Sobreescribe el método clone */
  public Date clone () {
    return (new Date(day, year, month));
  }

  /* MÉTODOS ESTÁTICOS PÚBLICOS (Métodos de libre acceso al programador que pueden o no estar en una instancia de la clase) */

  // Retorna si el año es bisisesto
  public static boolean isLeap (int year) {
    return (year % 4 == 0 || year % 400 == 0 && year % 100 != 0);
  }

  // Retorna el día máximo de días en un mes, basado en el año por si es bisiesto
  public static int maxDays (int month, int year) {
    switch (month) {
      case JANUARY, MARCH, JULY, AUGUST, OCTOBER, DECEMBER:
        return 31;
      case APRIL, MAY, JUNE, SEPTEMBER, NOVEMBER:
        return 30;
      case FEBRUARY:
        return (isLeap(year) ? (29) : (28));
      default:
        return -1;
    }
  }

  // Retorna si una fecha es válida basado en el resultado de otros métodos estáticos
  public static boolean isValidDate (int day, int month, int year) {
    boolean validYear = isValidYear(year);
    boolean validMonth = isValidMonth(month);
    boolean validDay = isValidDay(day, maxDays(month, year));
    return (validDay && validMonth && validYear);
  }

  // Retorna el día de la semana basado en el número de día (0 - 6) mapeado al arreglo de String ("Sunday" - "Saturday") 
  public static String getWeekDay (int numDay) {
    if (numDay >= SUNDAY && numDay <= SATURDAY)
      return (dowArray[numDay]);
    return null;
  }
  
  // Retorna el día de la semana basado en día, mes y año, realiza el algoritmo de Zeller
  public static String getWeekDay (int day, int month, int year) {
    int dow = calcDayOfWeek(day, month, year);
    if (dow == -1)
      return null;
    return (dowArray[dow]); 
  }

  // Retorna el nombre del mes, basado en el número de mes (0 - 12) mapeado al arreglo de String ("January" - "December")
  public static String getMonthName (int month) {
    if (isValidMonth(month))
      return (monthArray[month - 1]);
    return null;
  }
  
  /* MÉTODOS ESTÁTICOS PRIVADOS (Métodos que no dependen de un objeto para su implementación, pero no son de libre uso para el programador) */

  // Utiliza el algoritmo de Zeller para obtener el día de la semana de una fecha (Siempre y cuando la fecha sea válida) y lo retorna
  private static int calcDayOfWeek (int day, int month, int year) {
    if (!isValidDate(day, month, year))
      return -1;
    int q = (14 - month) / 12;
    int y = year - q;
    int m = month + 12 * q - 2;
    int result = (day + y + (y / 4) - (y / 100) + (y / 400) + ((31 * m) / 12)) % 7;
    return result;
  }
  
  // Retorna si el año que se ingresa es válido
  private static boolean isValidYear (int year) {
    return (year >= FIRST_YEAR && year <= LAST_YEAR);
  }
  
  // Retorna si el mes que se ingresa es válido
  private static boolean isValidMonth (int month) {
    return (month >= FIRST_MONTH && month <= monthArray.length - 1);
  }

  // Retorna si el día que se ingresa es válido (Rango máximo son los días máximos de cada mes (Requiere operaciones externas))
  private static boolean isValidDay (int day, int maxDays) {
    return (day >= FIRST_DAY && day <= maxDays); 
  }


  /* MÉTODOS PÚBLICOS (Métodos de libre uso, no son estáticos por lo que requieren de una instancia de la clase para su uso) */

  // Retorna el resultado del máximo de días con los atributos de la instancia
  public int maxDays () {
    return (maxDays(month, year));
  }

  // Retorna el si la instancia es un año bisiesto o no, utilizando el método estático declarado previamente
  public boolean isLeap () {
    return (isLeap(year));
  }

  // Retorna si los atributos de la instancia actuál son válidos 
  public boolean isValidDate () {
    return (isValidDate(day, month, year));
  }

  /* SETTERS */

  // Setea el valor del año
  public void setYear (int year) {
    this.year = (isValidYear(year)) ? (year) : (FIRST_YEAR);
  } 

  // Setea el valor del mes (Numérico y Texto)
  public void setMonth (int month) {
    this.month = (isValidMonth(month)) ? (month) : (FIRST_MONTH);
    strMonth = monthArray[this.month - 1];
  }


  // Setea el valor del día (Numérico y Día de la semana)
  public void setDay (int day) {
    this.day = isValidDay(day, maxDays(month, year)) ? (day) : (FIRST_DAY);
    weekDay = getWeekDay(this.day, month, year);
  }

  /* GETTERS */

  // Retorna el valor del año
  public int getYear () {
    return (year);
  }

  // Retorna el número de mes
  public int getMonthNumber () {
    return (month);
  }

  // Retorna el texto del mes
  public String getMonth () {
    return (strMonth);
  }

  // Retorna el número de día
  public int getDay () {
    return (day);
  }

  // Retorna el día de la semana
  public String getWeekDay () {
    return getWeekDay(day, month, year);
  }
}