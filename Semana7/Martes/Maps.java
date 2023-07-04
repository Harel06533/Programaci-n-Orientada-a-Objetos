package Semana7.Martes;

import java.util.HashMap;

public class Maps {
  public static void main (String[] args) {
    HashMap<String, Integer> numberMap = new HashMap<>(); 
    numberMap.put("uno", 1);
    numberMap.put("dos", 2);
    numberMap.put("tres", 3);
    numberMap.put("cuatro", 4);
    numberMap.put("cinco", 5);

    System.out.println(numberMap.get("tres") + ", " + numberMap.get("siete"));
  } 
}
