package Semana2.Jueves.Dates;

public class Date {
  private int day = 1;
  private int month = 1;
  private int year = 1970;
  private String monthStr;
  private String[] monthArray = {
    "January", "February", "March", 
    "April",  "May", "June", 
    "July", "August", "September",
    "October", "November", "December"
  };

  /* Constructor 1 - Fecha default */
  public Date () {
    monthStr = monthArray[0];
  }

  /* Constructor 2 - Parámeteros */
  public Date (int day, int month, int year) {
    if (isValidDay(day) && isValidMonth(month) && isValidYear(year)) {
      this.day = day;
      this.month = month;
      this.year = year;
    }
    monthStr = mapMonth();
  }

  /* Métodos públicos */

  // -- Retorna el máximo de días posibles en el mes (Si es bisiesto, febrero varía) -- // 
  public int maxMonthDays () {
    switch (month) {
      case 1, 3, 7, 8, 10, 12:
        return 31;
      case 4, 6, 9, 11:
        return 30;
      case 2:
        int febDays = (isLeapYear()) ? (29) : (28);
        return febDays;
      default:
        return -1;
    }
  }

  // -- Retorna si una fecha es o no válida -- //
  public boolean isValidDate () {
    if (day > maxMonthDays() || maxMonthDays() == -1) 
      return false;
    return true; 
  }

  // -- Retorna si el año es bisiesto -- //
  public boolean isLeapYear () {
    return (year % 4 == 0 || year % 400 == 0 && year % 100 != 0);
  }

  // -- Al imprimir el objeto retorna un String (Si es válido, imprime la fecha, si no retorna que no es válido) -- //
  public String toString () {
    if (!isValidDate())
      return ("The date is not valid\n");
    return (day + "/" + monthStr + "/" + year + "\n");
  }

  // -- Retorna el día --//
  public int getDay () {
    return day;
  }

  public int getMonthNumber () {
    return month;
  }

  // -- Retorna el nombre mes -- //
  public String getMonth () {
    return monthStr;
  }

  // -- Retorna el año -- //
  public int getYear () {
    return year;
  }

  // -- Setter de día --//
  public void setDay (int day) {
    if (isValidDay(day))
      this.day = day;
  }

  // -- Setter del mes -- //
  public void setMonth (int month) {
    if (isValidMonth(month))
      this.month = month;
  }

  // -- Setter del año -- //
  public void setYear (int year) {
    if (isValidYear(year))
      this.year = year;
  }

  /* Métodos privados (Únicamente trabajan y deben de trabajar dentro de la clase) */

  // -- Retorna si el día está en un rango válido -- //
  private boolean isValidDay (int day) {
    return (day >= 1 && day <= 31);
  }

  // -- Retorna si el mes está en un rango válido -- //
  private boolean isValidMonth (int month) {
    return (month >= 1 && month <= 12);
  }

  // -- Retorna si el año está en un rango válido -- //
  private boolean isValidYear (int year) {
    return (year >= 0 && year <= 9999);
  }

  // -- Retrona el valor en string del mes (Mes = 1 -> "Enero")
  private String mapMonth () {
    return monthArray[month - 1];   
  };
}