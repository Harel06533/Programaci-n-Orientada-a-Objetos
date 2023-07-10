package Semana8;

import java.util.HashSet;

public class TestHash {
  public static void main (String[] args) {
    final int n = 100_000;
    HashSet<Date> setDate = new HashSet<>();

    for (int i = 0; i < n; i++) {
      setDate.add(Date.randomDate());
    }

    System.out.println(setDate.size());
    System.out.println(Date.HASH_CALLS);
    System.out.println(Date.EQUALS_CALLS);
  }
}
