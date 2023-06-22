package StructTest.Structures;

public class Queue<T> {
  private class Qnode  {
    T data;
    Qnode next;
    public Qnode (T data) {
      this.data = data;
      next = null;
    }
  } 

  // attributes
  private Qnode front;
  private Qnode rear;
  private int size;

  // base constructor
  public Queue () {
    front = null;
    size = 0;
  }

  // checks if queue is empty
  public boolean isEmpty() {
    return (front == null && rear == null);
  }

  // checks if a node can be inserted in an empty queue (initialize the lis), if so returns true and inserts, else returns false
  private boolean canInsertEmptyQueue (Qnode node) {
    if (isEmpty()) {
      front = node;
      rear = front;
      size++;
      return true;
    }
    return false; 
  }

  // offers new node to the queue
  public void offer (T data) {
    Qnode node = new Qnode(data);
    if (canInsertEmptyQueue(node)) return;
    rear.next = node;
    rear = node;
    size++;
  }

  // deletes front node from a queue
  public T poll () {
    if (isEmpty()) return null;
    Qnode toRemove = front;
    T toReturn = toRemove.data;
    front = front.next;
    size--;
    return (toReturn);
  }
}

