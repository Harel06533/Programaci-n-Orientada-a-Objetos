package Semana7.Jueves;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class CompareTest {
  public static void main (String[] args) {
    PriorityQueue<Rectangle> rQueue = new PriorityQueue<>();
    TreeMap<Integer, Rectangle> rMap = new TreeMap<>();
    TreeSet<Rectangle> rSet = new TreeSet<>();

    for (int i = 0; i < 10; i++) {
      int randBase = getRandomNumber(1, 100);
      int randHeight = getRandomNumber(1, 100);

      rQueue.add(new Rectangle(randBase, randHeight));
      rMap.put(getRandomNumber(i, ((i + 5) * 2)), new Rectangle(randBase, randHeight));
      rSet.add(new Rectangle(randBase, randHeight));
    }

    System.out.println("HEAP:\n" + rQueue);
    System.out.println("MAP:\n" + rMap);
    System.out.println("SET:\n" + rSet);
  } 

  public static int getRandomNumber (int min, int max) {
    return (int)((Math.random() * max) + min);
  }
}
