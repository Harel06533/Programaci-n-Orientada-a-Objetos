package Semana7.Martes;

import java.util.ArrayList;

public class Lists {
  public static void main (String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("Uno");
    list.add("Dos");
    list.add("Tres");
    list.add("Cuatro");
    list.add("Cinco");
    list.add("Seis");
    
    System.out.println(list);

    int index1 = list.indexOf("Dos");                        //--> Obtiene el índice 
    String value = list.get(list.indexOf("Cuatro"));         //--> Obtiene el valor del índice de "Cuatro"
    list.set(list.indexOf("Cuatro"), list.get(index1));      //--> Setea en el índice de "Cuatro", "Dos"
    list.set(index1, value);                                   //--> Setea en el índice de "Dos", "Cuatro"

    for (int i = 0; i < list.size(); i++) {
      list.set(i, list.get(i).toUpperCase());
    }

    System.out.println(list);

    int i = list.size() - 1;
    while (!list.isEmpty()) {
      list.remove(i);
      i--;
    }

    System.out.println(list);
  } 
}
