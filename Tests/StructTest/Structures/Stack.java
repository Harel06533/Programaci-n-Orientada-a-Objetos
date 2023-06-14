package Tests.StructTest.Structures;

public class Stack<Type> {
  protected class Node { 
    Type data;
    Node next;

    public Node (Type data) {
      this.data = data;
      next = null;
    }
  }

  int size;
  String output = "";
  Type data;
  Node top;

  public Stack () { top = null; }

  public String toString () {
    Node curr = top;
    for (int i = 0; i < size; i++) {
      output += curr.data + "\n";
      output += "|" + "\n";
      curr = curr.next;
    }
    output += "NULL";
    return output;
  }

  public void insert (Type data) {
    Node toAdd = new Node(data);
    toAdd.next = null;
    if (top == null) {
      top = toAdd;
    } else {
      toAdd.next = top;
      top = toAdd;
    }
    size++;
  }

  public Type pop () {
    Node toRemove = top;
    top = top.next;
    size--;
    return toRemove.data;
  }

  public Type peek () {
    return (top.data);
  }

  public int getSize () {
    return (size);
  }
}