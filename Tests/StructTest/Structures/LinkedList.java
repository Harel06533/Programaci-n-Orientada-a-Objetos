package StructTest.Structures;

public class LinkedList<T> {
  // gets className
  public final String className = "LinkedList";

  // attributes
  private ListNode head;
  private ListNode tail;
  private int size;
  private String stringOutput;

  // inner class that declares a single node
  public class ListNode {
    private T data;
    private ListNode next;

    public ListNode (T data) {
      this.data = data;
      next = null;
    }
  }

  // initializes an empty linkedlist
  public LinkedList () {
    head = null;
    tail = null;
    size = 0;
  }

  // NOT VERY EFFICIENT (closes list format for printing)
  @Override
  public String toString () {
    ListNode curr = head;
    stringOutput = "[" + curr.data;
    curr = curr.next;
    while (curr != null) {
      stringOutput += ", " + curr.data;
      curr = curr.next;
    }
    stringOutput += "]";
    return stringOutput;
  }

  // checks if the list is empty (neither head nor tail point to a node)
  public boolean isEmpty () {
    return (head == null && tail == null);
  }

  // checks if it can initialize an empty list, if possible, initializes an return true, otherwise it returns false
  private boolean canInitEmptyList (ListNode node) {
    if (isEmpty()) {
      head = node;
      tail = node;
      stringOutput += node.data;
      size++;
      return true;
    }
    return false;
  }

  // inserts (append) a node to the list, checks if the list has not yet been initialized, if so, initializes and returns, else just appends to the list
  public void insert (T data) {
    ListNode node = new ListNode(data);
    if (canInitEmptyList(node)) return;
    tail.next = node;
    tail = node;
    size++;
  }

  // reverses a linked list in case it's needed
  public void reverse () {
    if (isEmpty()) return;
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = curr;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
  }

  // returns size of the list
  public int getSize () {
    return (size);
  }

  // inserts a node based on an index input, if list is empy, initializes it, and if index is out of bounds, throws exception
  public void insert (T data, int index) {   
    ListNode node = new ListNode(data);
    if (canInitEmptyList(node)) return;
    if (index > size)
      throw (new IndexOutOfBoundsException("The index is out of range for list with size = " + size));
    ListNode prev = head;
    ListNode curr = prev;
    for (int i = 0; i < index - 1; i++) {
      prev = prev.next;
    }
    curr = prev.next;
    prev.next = node;
    node.next = curr;
  }

  // removes a node based on an index
  public void removeIndex (int index) {
    ListNode prevToRemove = head;
    ListNode toRemove;
    for (int i = 0; i < index - 1; i++) {
      prevToRemove = prevToRemove.next;
    }
    toRemove = prevToRemove.next;
    prevToRemove.next = toRemove.next;
    toRemove = null;
    System.gc();
  }
}
