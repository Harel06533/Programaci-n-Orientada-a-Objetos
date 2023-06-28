package Semana6.Miercoles;

public class Test {
  public static void main (String[] args) {
    for (Language lang : Language.values()) {
      for (WeekDay weekDay : WeekDay.values()) {
        weekDay.changeLanguage(lang);
        System.out.println(weekDay);
      }
      System.out.println();
    }
  } 
}
