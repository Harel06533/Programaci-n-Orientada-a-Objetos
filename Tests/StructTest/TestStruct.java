package StructTest;

import  StructTest.Structures.LinkedList;
import StructTest.Structures.Stack;

public class TestStruct {
  public static void main(String[] args) {
    /* LinkedList */  
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 15; i++) {
      list.insert(i + 1);
    }
    list.insert(777, 6);
    System.out.println("LinkedList:\n" + list);
    list.reverse();
    list.removeIndex(4);
    System.out.println(list);;

    /* Stack */
    Stack<Integer>stack = new Stack<>(); 
    for (int i = 0; i < 15; i++) {
      stack.push(i);
    }
    System.out.println("\nStack:\n" + stack);
  }
}
