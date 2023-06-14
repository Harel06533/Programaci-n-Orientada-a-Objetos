package Semana4.Miercoles.Time;

import java.util.Calendar;

public class DateTime extends Date {

  // Obtiene la hora actual y la guarda en una constante
  public static final int CURRENT_HOUR = currCalendar.get(Calendar.HOUR_OF_DAY);
  public static final int CURRENT_MINUTE = currCalendar.get(Calendar.MINUTE);
  public static final int CURRENT_SECOND = currCalendar.get(Calendar.SECOND);

  // Los valores default de cada atributo
  public static final int DEFAULT_HOUR = 0;
  public static final int DEFAULT_MINUTE = 0;
  public static final int DEFAULT_SECOND = 0;

  // Atributos
  protected int hours;
  protected int minutes;
  protected int seconds;

  // Constructor, ingresa todos los datos
  public DateTime (int day, int month, int year, int hours, int minutes, int seconds) {
    super(day, month, year);
    setTime(hours, minutes, seconds);
  }

  // Constructor, únicamente require de los atributos exclusivos de la clase DateTime (hora, min, secs)
  public DateTime (int hours, int minutes, int seconds) {
    super();
    setTime(hours, minutes, seconds);
  }

  // Constructor, requiere de una instancia de Date y pasa los datos de la clase como parámetros
  public DateTime (Date date, int hours, int minutes, int seconds) {
    super(date.day, date.month, date.year);
    setTime(hours, minutes, seconds);
  }

  // Constructor, únicamente require una instancia de date para la fecha, la hora será la actuál
  public DateTime (Date date) {
    super(date.day, date.month, date.year);
    setTime(CURRENT_HOUR, CURRENT_MINUTE, CURRENT_SECOND);
  }


  // Constructor, No requiere parámetros, setea todo con la fecha y tiempo actual
  public DateTime () {
    super();
    setTime(CURRENT_HOUR, CURRENT_MINUTE, CURRENT_SECOND);
  }

  @Override
  public String toString () {
    return (super.toString() + String.format("'Hours': %d\n'Minutes': %d\n'Seconds': %d\n", hours, minutes, seconds));
  }

  @Override
  public boolean equals (Object o) {
    if (o instanceof DateTime) {
      DateTime dt = (DateTime)o;
      boolean equalDate = super.equals(dt);     //--> Esto es válido, ya que DateTime es una instancia de Date
      return (equalDate && dt.hours == hours && dt.minutes == minutes && dt.seconds == seconds);
    }
    return false;
  }

  @Override
  public DateTime clone () {
    return (new DateTime(super.day, super.month, super.year, hours, minutes, seconds));
  }

  @Override

  // Aumenta en 1 los segundos y recalcula si es necesario
  public void next () {
    seconds++;

    if (seconds > 59) {
      minutes++;
      seconds = 0;
      if (minutes > 59) {
        minutes = 0;
        hours++;
        if (hours > 23) {
          hours = 0;
          super.next();
        }
      }
    }
  }

  // Crea una instancia de Date para guardar únicamente los datos de fecha de un objeto DateTime
  public static Date toDate (DateTime dt) {
    return (new Date(dt.day, dt.month, dt.year));
  }


  public Date toDate () {
    return (toDate(this));
  }

  public void setHours (int hours) {
    this.hours = (hours >= 0 && hours <= 23) ? (hours) : (DEFAULT_HOUR);
  }

  public void setMinutes (int minutes) {
    this.minutes = (minutes >= 0 && minutes <= 59) ? (minutes) : (DEFAULT_MINUTE);
  }

  public void setSeconds (int seconds) {
    this.seconds = (seconds >= 0 && seconds <= 59) ? (seconds) : (DEFAULT_SECOND);
  }

  public void setTime (int hours, int minutes, int seconds) {
    setHours(hours);
    setMinutes(minutes);
    setSeconds(seconds);
  }

  public int getHours () {
    return (hours);
  }

  public int getMinutes () {
    return (minutes);
  }

  public int getSeconds () {
    return (seconds);
  }
}