package Tests.StructTest.Structures;

/**
 * Una Lista enlazada es una estructura de datos que permite el almacenamiento de datos de manera no contigua.
 * Esta forma permite que una lista enlazada sea una excelente herramienta para la inserción de elementos pero
 * no para la búsqueda y la obtención de los mismos.
 * @author Harel Alejandro Olguín Gaytán
 */
public class LinkedList <T> {
  /**
   * La clase {@code Node} engloba los atributos y métodos de un Nodo individual para una clase
   * {@code LinkedList}
   */
  private class Node {
    private T data;
    public Node next;

    /* Constructor */
    public Node (T data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node head;            //--> La cabeza de la lista
  private Node tail;            //--> La cola de la lista
  private int size;             //--> Tamaño de la lista

  /**
   * Constructor, crea una instancia de {@code LinkedList} donde el primer elemento {@code head} apunta a 
   * {@code null}.
   */
  public LinkedList () { this.head = null; };
  
  /**
   * Inserta un elemento de tipo indefinido {@code T} al final de la lista enlazada, si
   * la cabeza de la lista apunta a {@code null}, entonces crea un elemento y tanto {@code head}
   * como {@code tail} apuntarán a este.
   * @param data Dato indefinido a insertar
   */
  public void insert (T data) {
    Node newNode = new Node(data);
    if (head == null) {
      this.head = newNode;
      this.tail = this.head;
    } else {
      this.tail.next = newNode;
      this.tail = tail.next;
    }
    size++;
  }

  /**
   * Inserta un elemento de tipo indefinido {@code T} en un índice definido de la lista enlazada.
   * Si el índice es menor o mayor que el tamaño de la lista, finaliza.
   * @param data Datos a agregar
   * @param index Posición del dato a agregar
   */
  public void insert (T data, int index) {
    Node newNode = new Node(data);
    Node prevNode = this.head;

    if (index > this.size || index < 0)
      return;

    if ((head == null)) {
      this.head = newNode;
      this.tail = this.head;
    } else {
      for (int i = 0; i < index - 1; i++) {
        prevNode = prevNode.next;
      }
      newNode.next = prevNode.next;
      prevNode.next = newNode;
    }
    size++;
  }

  /**
   * 
   * @return El tamaño de la lista
   */
  public int size() {
    return (this.size);
  }

  public String toString () {
    String output = "[";
    Node curr = this.head;
    for (int i = 0; i < this.size; i++) {
      output += (i + 1 == this.size) ? (curr.data) : (curr.data + ", ");
      curr = curr.next;
    }
    output += "]";
    return output;
  }
}