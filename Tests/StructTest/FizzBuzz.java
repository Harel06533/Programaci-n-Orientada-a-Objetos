package StructTest;


public class FizzBuzz {
  public static void main (String[] args) {
    String output;
    for (int i = 0; i < 100; i++) {
      output = "";
      if (i % 3 == 0) output += "Fizz";
      if (i % 5 == 0) output += "Buzz";

      if ("".equals(output)) output += i;

      System.out.println(output);
    }
  } 
}
