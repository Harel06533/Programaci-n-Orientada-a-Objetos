package Tests.StructTest.Structures;

/**
 * TODO - Crear funciones de sort()  
 */

public class Array {
  private static final int MAX_SIZE = 100;

  private int fixedIndex = 0;
  private int[] arr;
  private String output = "[";

  public Array () {
    arr = new int [MAX_SIZE];
  }

  public Array (int size) {
    arr = new int [size];
  }

  public String toString () {
    return (output + "]");
  }

  public void insert (int data) {
    if (fixedIndex + 1 > arr.length) 
      return;
    arr[fixedIndex] = data;
    output += arr[fixedIndex] + ", ";
    fixedIndex++;
  }

  public int length () {
    return (arr.length);
  }

  public int search (int value) {
    return (binarySearch(value, 0, arr.length));
  }

  public int getValue (int index) {
    return (arr[index]);
  }

  private void swap (int i1, int i2) {
    int temp = arr[i1];
    arr[i1] = arr[i2];
    arr[i2] = temp;
  }

  private int binarySearch (int value, int low, int high) {
    if (low < high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == value)
        return mid;
      if (value > arr[mid])
        return (binarySearch(value, mid + 1, high));
      if (value < arr[mid])
        return (binarySearch(value, low, mid - 1));
    }
    return -1;
  }
}