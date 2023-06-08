package Tests.StructTest;

import Tests.StructTest.Structures.Array;

public class TestArray {
  public static void main (String[] args) {
    Array arr = new Array(10);
    for (int i = 0; i < arr.length(); i++) {
      arr.insert(((i * 2) - (i >> 1)) * 50);
    }
    System.out.println(arr);
    System.out.println(arr.search(400));
  }
}