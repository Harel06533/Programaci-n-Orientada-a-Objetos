package Tests.StructTest;

import Tests.StructTest.Structures.Stack;


public class TestStack {
  public static void main (String[] args) {
    Stack<Integer> operators = new Stack<Integer>();
    Stack<Integer> operands = new Stack<Integer>();
    String expression = "2 + 5 * 3";
  }

  public static int getPrecedence (char value) {
    if (value == '+' || value == '-')
      return 1;
    if (value == '*' || value == '/')
      return 2;
    return -1;
  }
}