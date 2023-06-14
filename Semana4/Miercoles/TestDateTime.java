package Semana4.Miercoles;

import Semana4.Miercoles.Time.*;

public class TestDateTime {
  public static void main (String[] args) {
    
    // Instancias de DateTime
    DateTime time1 = new DateTime();
    DateTime time2 = new DateTime(0, 26, 3);
    DateTime time3 = new DateTime(31, Date.DECEMBER, 2017, 23, 59, 59);
    
    // Clona y suma 1 al día
    DateTime time4 = time3.clone();
    time4.next();

    // Crea un Date que guarda únicamente los datos de fecha de time3 (Una instancia de DateTime)
    Date date5 = time3.toDate();

    // Clona los datos de date5 para poder sumarle 1 al día únicamente a la fecha
    Date date6 = date5.clone();
    date6.next();

    // time6 guarda los datos de date6 y añade el tiempo de time3
    DateTime time6 = new DateTime(date6, time3.getHours(), time3.getMinutes(), time3.getSeconds());
    
    // Pruebas

    DateTime t2c = time2.clone();

    // Da verdadero puesto que t2c es un clon identico de time2
    System.out.println(time2.equals(t2c));

    // Da falso, puesto que DateTime.equals() compara instancias de DateTime, que son hijos de Date, a esta última pertenece date5
    System.out.println(time3.equals(date5));
    
    // Da true, puesto que un objeto DateTime es instancia de Date y Date.equals() únicamente requiere los atributos que ambos comparten, sin especialización
    System.out.println(date5.equals(time3));


    System.out.println(time1);
    System.out.println(time2);
    System.out.println(time3);
    System.out.println(time4);
    System.out.println(date5);
    System.out.println(time6);
  }
}