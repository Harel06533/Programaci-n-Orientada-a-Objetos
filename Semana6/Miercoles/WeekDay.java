package Semana6.Miercoles;

import java.util.HashMap;

public enum WeekDay {
  MONDAY, 
  TUESDAY, 
  WEDNESDAY, 
  THURSDAY, 
  FRIDAY, 
  SATURDAY, 
  SUNDAY;

  WeekDay () {
    language = Language.ENGLISH;
  };
  Language language;
  
  private static HashMap<Language, String[]> langDayMap;
  private static String[] englishLang = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
  private static String[] spanishLang = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
  private static String[] frenchLang = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Diamanche"};

  static {
    langDayMap = new HashMap<>();
    langDayMap.put(Language.ENGLISH, englishLang);
    langDayMap.put(Language.SPANISH, spanishLang);
    langDayMap.put(Language.FRENCH, frenchLang);
  }
  

  public String toString() {
    return (langDayMap.get(language)[ordinal()]);
  }

  public void changeLanguage (Language language) {
    this.language = language;
  }
}
