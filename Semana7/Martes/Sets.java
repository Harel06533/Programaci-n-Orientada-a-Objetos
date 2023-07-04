package Semana7.Martes;

import java.util.TreeSet;

public class Sets {
  public static void main (String[] args) { 
    int[] array = {100, 150, 120, 100, 180, 200, 120, 180, 100};
    TreeSet<Integer> set = new TreeSet<>();

    for (int i = 0; i < array.length; i++) {
      set.add(array[i]);
    }

    System.out.println("size of set: " + set.size());
    System.out.println(set);
  }
}
