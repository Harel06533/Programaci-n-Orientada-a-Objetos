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
    stringOutput = "[";
    size = 0;
  }

  // NOT VERY EFFICIENT (closes list format for printing)
  @Override
  public String toString () {
    return (stringOutput + "]");
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
    stringOutput += ", " + node.data;
    size++;
  }

  // returns size of the list
  public int getSize () {
    return (size);
  }

  /* Unable to find a way to add to ToString correctly here 
  public void insert (T data, int index) {1   
  }
  */
}
