package StructTest.Structures;

public class Stack<T> {
  // gets className
  public final String className = "Stack"; 

  // attributes
  StackNode top;
  int size;

  // inner class that declares a single node for a stack (binary tree)
  public class StackNode {
    private StackNode next;
    private T data;
    public StackNode (T data) {
      this.data = data;
      next = null;
    }
  }

  // initializes an empty stack
  public Stack () {
    top = null;
    size = 0;
  }

  // overrides toString method
  @Override
  public String toString () {
    String output = "";
    StackNode current = top;
    while (current != null) {
      output += "| " + current.data + " |\n" ;
      current = current.next;
    }
    return output;
  }

  // checks if stack is empty (head points to null)
  public boolean isEmpty () {
    return (top == null);
  }

  // checks if a node can be inserted in an empty stack, if so initializes the stack and returns true, otherwise returns false
  private boolean canPushEmptyStack (StackNode node) {
    if (!isEmpty()) return false;
    top = node;
    size++;
    return true;

  }

  public void push (T data) {
    StackNode node = new StackNode(data);
    if (canPushEmptyStack(node)) return;
    node.data = data;
    node.next = top;
    top = node;
    size++;
  }

  public T pop () {
    if (isEmpty()) return null;
    StackNode toRemove = top;
    T data = toRemove.data;
    top = top.next;
    return data;
  }
}
