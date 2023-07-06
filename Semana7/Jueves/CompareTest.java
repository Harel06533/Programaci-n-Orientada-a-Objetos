package Semana7.Jueves;

import java.util.PriorityQueue;

public class CompareTest {
  public static void main (String[] args) {
    PriorityQueue<Rectangle> rQueue = new PriorityQueue<>();

    for (int i = 0; i < 10; i++) {
      rQueue.add(new Rectangle((Math.random() * 100) + 1, (Math.random() * 100) + 1));
    }

    System.out.println(rQueue);
  } 
}
