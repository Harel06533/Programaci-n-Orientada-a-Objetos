package Tests.StructTest;

import Tests.StructTest.Structures.LinkedList;

public class TestList {
  public static void main (String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      list.insert(lrand(1, 50));
    }
    System.out.println(list + "\nList size = " + list.size());
    list.insert(900, 7);
    System.out.println(list + "\nList size = " + list.size());
  }

  public static int lrand (int start, int limit) {
    return ((int)(Math.random() * limit) + start);
  }
}